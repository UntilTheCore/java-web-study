package com.untilthecore.edu.info.manager.dao;

import com.untilthecore.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class StudentDao {
  private final ArrayList<Student> students = new ArrayList<>();

  public boolean add(Student s) {
    return this.students.add(s);
  }

  public boolean remove(Student s) {
    return this.students.remove(s);
  }

  public boolean update(Student s, String name, String gender, int age) {
    s.setName(name);
    s.setGender(gender);
    s.setAge(age);
    return true;
  }

  public Student findById(String id) {
    for(Student nextStudent : this.students) {
      if(nextStudent.getId().equals(id)) {
        return nextStudent;
      }
    }
    return null;
  }

  public ArrayList<Student> findAll() {
    return this.students;
  }
}
