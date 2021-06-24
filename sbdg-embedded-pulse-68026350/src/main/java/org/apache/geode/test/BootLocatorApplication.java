package org.apache.geode.test;

import java.util.Scanner;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.gemfire.config.annotation.EnableManager;
import org.springframework.data.gemfire.config.annotation.LocatorApplication;

@SpringBootApplication
@LocatorApplication
@EnableManager(start = true)
public class BootLocatorApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(BootLocatorApplication.class)
        .web(WebApplicationType.NONE)
        .build()
        .run(args);

    System.err.println("Press <enter> to exit!");
    new Scanner(System.in).nextLine();
  }
}
