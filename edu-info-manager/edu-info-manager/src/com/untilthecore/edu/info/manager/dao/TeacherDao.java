package com.untilthecore.edu.info.manager.dao;

import com.untilthecore.edu.info.manager.domain.Student;
import com.untilthecore.edu.info.manager.domain.Teacher;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TeacherDao extends BaseDao<Teacher> {
    private static final ArrayList<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher("t001", "核二三", 20, "男"));
        teachers.add(new Teacher("t002", "王五", 20, "女"));
    }
    @Override
    public boolean add(Teacher teacher) {
        return teachers.add(teacher);
    }

    @Override
    public boolean remove(String id) {
        Teacher teacher = findById(id);
        return teachers.remove(teacher);
    }

    @Override
    public boolean update(String id, String name, String gender, int age) {
        Teacher teacher = findById(id);
        teacher.setName(name);
        teacher.setGender(gender);
        teacher.setAge(age);
        return true;
    }

    @Override
    public ArrayList<Teacher> findAll() {
        return teachers;
    }

    public Teacher findById(String id) {
        for(Teacher teacher: teachers) {
            if(teacher.getId().equals(id)) {
                return teacher;
            }
        }
        return null;
    }
}
