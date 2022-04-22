package com.untilthecore.edu.info.manager.controller;

import com.untilthecore.edu.info.manager.dao.TeacherDao;
import com.untilthecore.edu.info.manager.domain.Person;
import com.untilthecore.edu.info.manager.domain.Teacher;
import com.untilthecore.edu.info.manager.service.TeacherService;

import java.util.ArrayList;

public class TeacherController extends BaseController<Teacher, TeacherDao> {
    public TeacherController() {
        super(new TeacherService());
    }

    @Override
    public void start() {
        super.start("教师");
    }

    @Override
    protected void add() {
        Person p = super.createPerson();
        if (p != null) {
            if (this.service.add(new Teacher(p.getId(), p.getName(), p.getAge(), p.getGender()))) {
                System.out.println("添加教师成功!");
            } else {
                System.out.println("添加教师失败!");
            }
        }
    }

    @Override
    protected void find() {
        Teacher teacher = super.findUser();

        if (teacher != null) {
            System.out.println("查到教师信息：" + teacher.toString());
        } else {
            System.out.println("无此教师");
        }
    }

    @Override
    protected void findAll() {
        ArrayList<Teacher> teacherArrayList = super.findAllUser();
        if (teacherArrayList.size() > 0) {
            System.out.println("查询到教师信息列表，容量:" + teacherArrayList.size());
            for (Teacher teacher : teacherArrayList) {
                System.out.println(teacher.toString());
            }
        } else {
            System.out.println("暂无教师信息列表");
        }
    }

}
