package com.untilthecore.edu.info.manager.controller;

import com.untilthecore.edu.info.manager.domain.Student;
import com.untilthecore.edu.info.manager.service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
  Scanner scanner = new Scanner(System.in);

  public void start() {
    StudentService studentService = new StudentService();
    while (true) {
      System.out.println("----------欢迎使用学生息管理系统-----------");
      System.out.println("请输入你的选择：1.添加学生    2.删除学生    3.修改信息    4.查询学生    5.查询所有学生    6.退出");
      String choice = scanner.next();
      switch (choice) {
        case "1":
          add();
          break;
        case "2":
          remove();
          break;
        case "3":
          update();
          break;
        case "4":
          find();
          break;
        case "5":
          findAll();
          break;
        case "6":
          System.out.println("退出学生信息管理系统!");
          return;
        default:
          System.out.println("输入有误，请重新输入!");
      }
    }

  }

  void add() {
    StudentService studentService = new StudentService();
    String id;
    while (true) {
      System.out.print("请输入学号:");
      id = scanner.next();
      boolean exists = studentService.isExists(id);

      if (exists) {
        System.out.println("学号重复，请重新输入");
      } else {
        break;
      }
    }

    System.out.print("请输入姓名:");
    String name = scanner.next();
    System.out.print("请输入性别:");
    String gender = scanner.next();
    System.out.print("请输入年龄");
    int age = scanner.nextInt();
    if (studentService.add(new Student(id, name, age, gender))) {
      System.out.println("学生信息添加成功!");
    } else {
      System.out.println("学生信息添加失败!");
    }
  }

  void find() {
    StudentService studentService = new StudentService();
    System.out.print("请输入学生学号:");
    String id = scanner.next();
    Student student = studentService.find(id);
    if (student != null) {
      System.out.println("查到学生信息：" + student.toString());
    } else {
      System.out.println("查无此人");
    }
  }

  void findAll() {
    StudentService studentService = new StudentService();

    ArrayList<Student> studentArr = studentService.findAll();
    if (studentArr.size() > 0) {
      System.out.println("查询到学生列表，容量:" + studentArr.size());
      for (Student student : studentArr) {
        System.out.println(student.toString());
      }
    } else {
      System.out.println("暂无学生信息列表");
    }
  }

  void remove() {
    StudentService studentService = new StudentService();
    System.out.print("请输入待删除的学生ID：");
    String id = scanner.next();
    boolean isOk = studentService.remove(id);
    if (isOk) {
      System.out.println("删除成功!");
    } else {
      System.out.println("删除失败!");
    }

  }

  void update() {
    StudentService studentService = new StudentService();
    String id;
    while (true) {
      System.out.print("请输入要修改的用户ID:");
      id = scanner.next();
      boolean exists = studentService.isExists(id);

      if (exists) {
        break;
      } else {
        System.out.println("查无此人");
      }
    }

    System.out.println("请输入姓名");
    String name = scanner.next();
    System.out.println("请输入性别");
    String gender = scanner.next();
    System.out.println("请输入年龄");
    int age = scanner.nextInt();
    if (studentService.update(id, name, gender, age)) {
      System.out.println("更新成功!");
    }
  }
}
