package com.untilthecore.edu.info.manager.dao;

import com.untilthecore.edu.info.manager.domain.Teacher;

import java.util.ArrayList;

public class TeacherDao extends BaseDao<Teacher> {
    @Override
    public boolean add(Teacher teacher) {
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
    public Teacher findById(String id) {
        return null;
    }

    @Override
    public ArrayList<Teacher> findAll() {
        return null;
    }
}
