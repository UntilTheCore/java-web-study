package com.untilthecore.edu.info.manager.domain;

public class Student extends Person{

  public Student() {
  }

  public Student(String id, String name, int age, String gender) {
    super(id, name, age, gender);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
