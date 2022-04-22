package com.untilthecore.edu.info.manager.dao;

import com.untilthecore.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class StudentDao {
  private static final ArrayList<Student> students = new ArrayList<>();

  public boolean add(Student s) {
    return students.add(s);
  }

  public boolean remove(String id) {
    Student student = findById(id);
    return students.remove(student);
  }

  public boolean update(String id, String name, String gender, int age) {
    Student student = findById(id);
    student.setName(name);
    student.setGender(gender);
    student.setAge(age);
    return true;
  }

  public Student findById(String id) {
    for(Student nextStudent : students) {
      if(nextStudent.getId().equals(id)) {
        return nextStudent;
      }
    }
    return null;
  }

  public ArrayList<Student> findAll() {
    return students;
  }
}