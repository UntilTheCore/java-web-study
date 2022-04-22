package com.untilthecore.edu.info.manager.service;

import com.untilthecore.edu.info.manager.dao.TeacherDao;
import com.untilthecore.edu.info.manager.domain.Teacher;

import java.util.ArrayList;

public class TeacherService extends BaseService<Teacher, TeacherDao> {

    public TeacherService() {
        super(new TeacherDao());
    }

    @Override
    public boolean add(Teacher teacher) {
        return dao.add(teacher);
    }

    @Override
    public boolean remove(String id) {
        return dao.remove(id);
    }

    @Override
    public boolean update(String id, String name, String gender, int age) {
        return dao.update(id, name, gender, age);
    }

    @Override
    public Teacher find(String id) {
        boolean exists = this.isExists(id);
        if(!exists) {
            return null;
        }

        ArrayList<Teacher> all = this.findAll();
        for (Teacher teacher : all) {
            if(teacher.getId().equals(id)) {
                return teacher;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Teacher> findAll() {
        return dao.findAll();
    }

    public boolean isExists(String id) {
        ArrayList<Teacher> teachers = dao.findAll();
        boolean exists = false;
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

}
