package com.untilthecore.edu.info.manager.controller;

import com.untilthecore.edu.info.manager.domain.Person;
import com.untilthecore.edu.info.manager.domain.Student;
import com.untilthecore.edu.info.manager.service.StudentService;

import java.util.ArrayList;

public class StudentController extends BaseController<Student> {

    public StudentController() {
        super(new StudentService());
    }

    @Override
    public void start() {
        super.start("学生");
    }

    protected Person add() {
        Person p = super.add();
        // 若有其他字段，则在此处继续扩展
        if(p != null) {
            if(this.service.add(new Student(p.getId(), p.getName(), p.getAge(), p.getGender()))) {
                System.out.println("添加学生成功!");
            } else {
                System.out.println("添加学生失败!");
            }
        }
        return p;
    }

    @Override
    protected void find() {
        Student student = (Student)super.find(this.service);

        if (student != null) {
            System.out.println("查到学生信息：" + student.toString());
        } else {
            System.out.println("无此学生");
        }
    }

    @Override
    protected void findAll() {
        ArrayList<Person> personArr = super.findAll(this.service);
        if (personArr.size() > 0) {
            System.out.println("查询到学生信息列表，容量:" + personArr.size());
            for (Person person : personArr) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("暂无学生信息列表");
        }
    }

    @Override
    protected void remove() {
        super.remove(this.service);
    }

    @Override
    protected void update() {
        super.update(this.service);
    }
}
