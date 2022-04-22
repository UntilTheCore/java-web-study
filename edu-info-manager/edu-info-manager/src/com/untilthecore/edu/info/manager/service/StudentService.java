package com.untilthecore.edu.info.manager.service;

import com.untilthecore.edu.info.manager.dao.StudentDao;
import com.untilthecore.edu.info.manager.domain.Person;
import com.untilthecore.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class StudentService extends BaseService<Student, StudentDao> {

  public StudentService() {
    super(new StudentDao());
  }

  public boolean update(String id, String name, String gender, int age) {
    return dao.update(id, name, gender, age);
  }

  public ArrayList<Student> findAll() {
    return dao.findAll();
  }

  public boolean add(Student person) {
    return dao.add(person);
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
    return dao.remove(id);
  }

  public boolean isExists(String id) {
    ArrayList<Student> students = dao.findAll();
    boolean exists = false;
    for (Student student : students) {
      if (student.getId().equals(id)) {
        exists = true;
        break;
      }
    }
    return exists;
  }
}
