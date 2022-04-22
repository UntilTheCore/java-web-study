package com.untilthecore.edu.info.manager.dao;

import java.util.ArrayList;

public abstract class BaseDao<T> {
    public abstract boolean add(T person);

    public abstract boolean remove(String id);

    public abstract boolean update(String id, String name, String gender, int age);

    public abstract T findById(String id);

    public abstract ArrayList<T> findAll();
}
