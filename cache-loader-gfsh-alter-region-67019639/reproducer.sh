#!/bin/bash
export JAVA_HOME="$(/usr/libexec/java_home -v 1.8)"
export JAVA_ARGS="-Dgfsh.log-level=config -Dgfsh.log-dir=."
export GEMFIRE="$HOME/Applications/Apache/Geode/1.13.2/apache-geode-1.13.2"
export PATH="$PATH:$GEMFIRE/bin"

clean() {
  ../gradlew :cache-loader-gfsh-alter-region-67019639:clean

  rm -Rf locator1 server1 gfsh-*.log
  for KILLPID in $(ps ax | grep 'gemfire' | awk ' { print $1; }'); do
	  kill -9 "$KILLPID";
  done
}

clean
../gradlew :cache-loader-gfsh-alter-region-67019639:build

gfsh -e "start locator --name=locator1 --port=10334 --locators=localhost[10334]"
gfsh \
	-e "connect --locator=localhost[10334]" \
	-e "start server --name=server1 --server-port=40401 --locators=localhost[10334]" \
	-e "list members" \
	-e "deploy --jar=build/libs/cache-loader.jar" \
	-e "create region --name=TradesPartition --type=PARTITION_REDUNDANT" \
	-e "alter region --name=TradesPartition --cache-loader=com.abc.geode.ApacheGeode.EmployeeCacheLoader" \
	-e "list regions" \
	-e "get --key=\"key1\" --region=/TradesPartition"

read -rp "Press Enter to shutdown everything..."
gfsh -e "connect --locator=localhost[10334]" -e "shutdown --include-locators=true"
