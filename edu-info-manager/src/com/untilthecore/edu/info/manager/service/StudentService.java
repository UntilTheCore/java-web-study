package com.untilthecore.edu.info.manager.service;

import com.untilthecore.edu.info.manager.dao.StudentDao;
import com.untilthecore.edu.info.manager.domain.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
  private final StudentDao sDao = new StudentDao();

  public void addStudent() {
    Scanner scanner = new Scanner(System.in);
    String id;
    while (true) {
      System.out.print("请输入学号:");
      id = scanner.nextLine();
      if (sDao.findById(id) != null) {
        System.out.println("学号重复，请重新输入");
      } else {
        break;
      }
    }

    System.out.print("请输入姓名:");
    String name = scanner.nextLine();
    System.out.print("请输入性别:");
    String gender = scanner.nextLine();
    System.out.print("请输入年龄");
    int age = scanner.nextInt();
    if (sDao.add(new Student(id, name, age, gender))) {
      System.out.println("学生信息添加成功!");
    }
  }

  public void removeStudent() {
    System.out.print("请输入待删除的学生ID:");
    Scanner scanner = new Scanner(System.in);
    String id = scanner.nextLine();

    Student student = sDao.findById(id);
    if (student != null) {
      if (sDao.remove(student)) {
        System.out.println("ID:" + id + "删除成功");
      } else {
        System.out.println("删除失败");
      }
    } else {
      System.out.println("无此学生");
    }
  }

  public void updateStudent() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("请输入要修改的用户ID");
    String id = scanner.nextLine();
    Student student = sDao.findById(id);
    if (student != null) {
      System.out.println("请输入姓名");
      String name = scanner.nextLine();
      System.out.println("请输入性别");
      String gender = scanner.nextLine();
      System.out.println("请输入年龄");
      int age = scanner.nextInt();
      if(sDao.update(student, name, gender, age)) {
        System.out.println("更新成功!");
      }
    } else {
      System.out.println("查无此人");
    }
  }

  public void findStudent() {
    System.out.print("请输入学生学号:");
    Scanner sc = new Scanner(System.in);
    String id = sc.nextLine();
    Student student = sDao.findById(id);
    if (student != null) {
      System.out.println("查到学生信息：" + student.toString());
    } else {
      System.out.println("查无此人");
    }
  }

  public void findAll() {
    ArrayList<Student> studentArr = sDao.findAll();
    if (studentArr.size() > 0) {
      System.out.println("查询到学生列表，容量:" + studentArr.size());
      for (Student student : studentArr) {
        System.out.println(student.toString());
      }
    } else {
      System.out.println("暂无学生信息列表");
    }
  }
}
