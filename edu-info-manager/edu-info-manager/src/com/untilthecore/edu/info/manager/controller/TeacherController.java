package com.untilthecore.edu.info.manager.controller;

import com.untilthecore.edu.info.manager.domain.Person;
import com.untilthecore.edu.info.manager.domain.Teacher;
import com.untilthecore.edu.info.manager.service.TeacherService;

import java.util.ArrayList;

public class TeacherController extends BaseController {
    public TeacherController() {
        super(new TeacherService());
    }

    @Override
    public void start() {
        super.start("教师");
    }

    @Override
    protected void add() {
        Person p = super.add(this.service);
        if (p != null) {
            if (this.service.add(new Teacher(p.getId(), p.getName(), p.getAge(), p.getGender()))) {
                System.out.println("添加教师成功!");
            } else {
                System.out.println("添加教师失败!");
            }
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

    @Override
    protected void find() {
        Teacher teacher = (Teacher)super.find(this.service);

        if (teacher != null) {
            System.out.println("查到教师信息：" + teacher.toString());
        } else {
            System.out.println("无此教师");
        }
    }

    @Override
    protected void findAll() {
        ArrayList<Person> personArr = super.findAll(this.service);
        if (personArr.size() > 0) {
            System.out.println("查询到教师信息列表，容量:" + personArr.size());
            for (Person person : personArr) {
                System.out.println(person.toString());
            }
        } else {
            System.out.println("暂无教师信息列表");
        }
    }

}
