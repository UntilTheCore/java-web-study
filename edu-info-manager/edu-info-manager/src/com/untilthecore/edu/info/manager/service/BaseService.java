package com.untilthecore.edu.info.manager.service;

import com.untilthecore.edu.info.manager.dao.BaseDao;
import com.untilthecore.edu.info.manager.domain.Person;

import java.util.ArrayList;

public abstract class BaseService<T> {
    public BaseDao dao;

    public BaseService(BaseDao dao) {
        this.dao = dao;
    }

    public abstract boolean add(T person);

    public abstract boolean remove(String id);

    public abstract boolean update(String id, String name, String gender, int age);

    public abstract T find(String id);

    public abstract ArrayList<T> findAll();

    public boolean isExists(String id) {
        ArrayList<Person> all = dao.findAll();
        boolean exists = false;
        for (Person person : all) {
            if (person.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }
}
