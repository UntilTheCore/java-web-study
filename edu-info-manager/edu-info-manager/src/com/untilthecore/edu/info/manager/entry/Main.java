package com.untilthecore.edu.info.manager.entry;

import com.untilthecore.edu.info.manager.controller.StudentController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------欢迎使用老师（学生）信息管理系统-----------");
            System.out.println("请输入你的选择：1.学生管理      2.老师管理      3.退出");
            String choice = sc.next();
            switch (choice) {
                case "1":
                    // 学生管理系统
                    System.out.println("学生管理系统");
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    // 教师管理系统
                    System.out.println("教师管理系统");
                    break;
                case "3":
                    // 退出
                    System.out.println("系统退出");
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新输入!");
            }
        }
    }
}
