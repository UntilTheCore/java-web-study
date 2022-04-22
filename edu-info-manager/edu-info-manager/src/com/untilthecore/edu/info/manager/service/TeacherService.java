package com.untilthecore.edu.info.manager.service;

import com.untilthecore.edu.info.manager.dao.TeacherDao;
import com.untilthecore.edu.info.manager.domain.Teacher;

import java.util.ArrayList;

public class TeacherService extends BaseService<Teacher> {

    public TeacherService() {
        super(new TeacherDao());
    }

    @Override
    public boolean add(Teacher person) {
        return false;
    }

    @Override
    public boolean remove(String id) {
        return false;
    }

    @Override
    public boolean update(String id, String name, String gender, int age) {
        return false;
    }

    @Override
    public Teacher find(String id) {
        return null;
    }

    @Override
    public ArrayList<Teacher> findAll() {
        return null;
    }

}
