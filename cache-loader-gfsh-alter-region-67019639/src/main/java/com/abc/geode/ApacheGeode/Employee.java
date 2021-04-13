package com.abc.geode.ApacheGeode;

import java.io.Serializable;

public class Employee implements Serializable {
  public String email;
  public Long idEmployee;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Long getIdEmployee() {
    return idEmployee;
  }

  public void setIdEmployee(Long idEmployee) {
    this.idEmployee = idEmployee;
  }
}
