package com.abc.geode.ApacheGeode;

import java.util.Properties;

import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.LoaderHelper;

public class EmployeeCacheLoader implements CacheLoader<Long,Employee>, Declarable {

  @Override
  public Employee load(LoaderHelper<Long, Employee> helper) throws CacheLoaderException {
    Employee e=new Employee();
    e.setEmail("a@b.com");
    e.setIdEmployee(2L);

    return e;
  }

  @Override
  public void close() {
  }

  @Override
  public void init(Properties props) {
  }
}
