package com.untilthecore.edu.info.manager.service;

import com.untilthecore.edu.info.manager.dao.StudentDao;
import com.untilthecore.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class StudentService {
  private final StudentDao studentDao = new StudentDao();


  public boolean update(String id, String name, String gender, int age) {
    return studentDao.update(id, name, gender, age);
  }

  public ArrayList<Student> findAll() {
    return studentDao.findAll();
  }

  public boolean isExists(String id) {
    StudentDao studentDao = new StudentDao();
    ArrayList<Student> all = studentDao.findAll();
    boolean exists = false;
    for (Student student : all) {
      if(student.getId().equals(id)) {
        exists = true;
        break;
      }
    }
    return exists;
  }

  public boolean add(Student student) {
    StudentDao studentDao = new StudentDao();
    return studentDao.add(student);
  }

  public Student find(String id) {
    boolean exists = this.isExists(id);
    if(!exists) {
      return null;
    }

    ArrayList<Student> all = this.findAll();
    for (Student student : all) {
      if(student.getId().equals(id)) {
        return student;
      }
    }

    return null;
  }

  public boolean remove(String id) {
    StudentDao studentDao = new StudentDao();
    return studentDao.remove(id);
  }
}
