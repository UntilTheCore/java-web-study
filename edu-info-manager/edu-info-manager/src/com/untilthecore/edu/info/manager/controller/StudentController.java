package com.untilthecore.edu.info.manager.controller;

import com.untilthecore.edu.info.manager.dao.StudentDao;
import com.untilthecore.edu.info.manager.domain.Person;
import com.untilthecore.edu.info.manager.domain.Student;
import com.untilthecore.edu.info.manager.service.StudentService;

import java.util.ArrayList;

public class StudentController extends BaseController<Student, StudentDao> {

    public StudentController() {
        super(new StudentService());
    }

    @Override
    public void start() {
        super.start("学生");
    }

    protected void add() {
        Person p = super.createPerson();
        // 若有其他字段，则在此处继续扩展
        if (p != null) {
            if (this.service.add(new Student(p.getId(), p.getName(), p.getAge(), p.getGender()))) {
                System.out.println("添加学生成功!");
            } else {
                System.out.println("添加学生失败!");
            }
        }
    }

    @Override
    protected void find() {
        Student student = super.findUser();

        if (student != null) {
            System.out.println("查到学生信息：" + student.toString());
        } else {
            System.out.println("无此学生");
        }
    }

    @Override
    protected void findAll() {
        ArrayList<Student> studentArrayList = super.findAllUser();
        if (studentArrayList.size() > 0) {
            System.out.println("查询到学生信息列表，容量:" + studentArrayList.size());
            for (Student student: studentArrayList) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("暂无学生信息列表");
        }
    }
}
