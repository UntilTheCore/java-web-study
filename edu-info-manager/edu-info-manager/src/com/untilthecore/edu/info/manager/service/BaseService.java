package com.untilthecore.edu.info.manager.service;

import com.untilthecore.edu.info.manager.dao.BaseDao;
import com.untilthecore.edu.info.manager.domain.Person;

import java.util.ArrayList;

public abstract class BaseService<T, E> {
    public E dao;

    public BaseService(E dao) {
        this.dao = dao;
    }

    public abstract boolean add(T person);

    public abstract boolean remove(String id);

    public abstract boolean update(String id, String name, String gender, int age);

    public abstract T find(String id);

    public abstract ArrayList<T> findAll();

    public abstract boolean isExists(String id);
}
