package com.untilthecore.edu.info.manager.controller;

import com.untilthecore.edu.info.manager.service.StudentService;

import java.util.Scanner;

public class StudentController {
  public void start() {
    Scanner sc = new Scanner(System.in);
    StudentService studentService = new StudentService();
    while (true) {
      System.out.println("----------欢迎使用学生息管理系统-----------");
      System.out.println("请输入你的选择：1.添加学生    2.删除学生    3.修改信息    4.查询学生    5.查询所有学生    6.退出");
      String choice = sc.next();
      switch (choice) {
        case "1":
          studentService.addStudent();
          break;
        case "2":
          studentService.removeStudent();
          break;
        case "3":
          studentService.updateStudent();
          break;
        case "4":
          studentService.findStudent();
          break;
        case "5":
          // 查询所有学生列表
          studentService.findAll();
          break;
        case "6":
          System.out.println("退出学生信息管理系统!");
          return;
        default:
          System.out.println("输入有误，请重新输入!");
      }
    }

  }
}
