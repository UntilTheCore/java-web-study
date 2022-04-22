package com.untilthecore.edu.info.manager.controller;

import com.untilthecore.edu.info.manager.domain.Person;
import com.untilthecore.edu.info.manager.service.BaseService;

import java.util.ArrayList;
import java.util.Scanner;

abstract class BaseController<T, E> {
    Scanner scanner = new Scanner(System.in);
    BaseService<T, E> service;

    public BaseController(BaseService<T, E> service) {
        this.service = service;
    }

    protected void start(String type) {
        while (true) {
            System.out.println("----------欢迎使用" + type + "息管理系统-----------");
            System.out.println("请输入你的选择：1.添加    2.删除    3.修改    4.查询    5.查询所有    6.退出");
            String choice = this.scanner.next();
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
                    System.out.println("退出" + type + "信息管理系统!");
                    return;
                default:
                    System.out.println("输入有误，请重新输入!");
            }
        }
    }

    protected Person createPerson() {
        String userId;
        while (true) {
            System.out.print("请输入用户ID:");
            userId = scanner.next();
            boolean exists = service.isExists(userId);
            if (exists) {
                System.out.println("ID重复，请重新添加");
            } else {
                break;
            }
        }

        System.out.print("请输入姓名:");
        String name = scanner.next();
        System.out.print("请输入性别:");
        String gender = scanner.next();
        System.out.print("请输入年龄:");
        int age = scanner.nextInt();
        return new Person(userId, name, age, gender);
    }

    protected void remove() {
        String id = checkUserId();

        if(id.equals("")) {
            return;
        }

        boolean isOk = service.remove(id);
        if (isOk) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
    }

    protected void update() {
        String userId = checkUserId();

        if(userId.equals("")) {
            System.out.println("查无此人");
            return;
        }

        System.out.println("请输入姓名");
        String name = scanner.next();
        System.out.println("请输入性别");
        String gender = scanner.next();
        System.out.println("请输入年龄");
        int age = scanner.nextInt();
        if (service.update(userId, name, gender, age)) {
            System.out.println("更新成功!");
        }
    }

    protected T findUser() {
        String userId = checkUserId();
        if(userId.equals("")) {
            return null;
        }
        return service.find(userId);
    }

    protected ArrayList<T> findAllUser() {
        return service.findAll();
    }

    protected String checkUserId() {
        String id;
        System.out.print("请输入用户ID:");
        id = scanner.next();
        boolean exists = service.isExists(id);

        if (!exists) {
            id = "";
        }
        return id;
    }

    protected abstract void findAll();

    public abstract void start();

    protected abstract void add();

    protected abstract void find();
}
