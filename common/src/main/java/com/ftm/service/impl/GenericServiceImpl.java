package com.ftm.service.impl;

import com.ftm.dao.GenericDao;
import com.ftm.exception.DataAccessException;
import com.ftm.service.GenericService;

import java.util.Collections;
import java.util.List;

/**
 * Created by awharshana on 7/9/2017.
 */
public class GenericServiceImpl<T> implements GenericService<T> {

    private Class<? extends T> type;
    protected GenericDao<T> genericDao;

    protected void init(Class<? extends T> type, GenericDao<T> dao) {
        this.type = type;
        this.genericDao = dao;
    }

    public T getById(String id) {
        try {
            return genericDao.getById(id);
        } catch (DataAccessException de) {
            return null;
        }
    }

    public T add(T obj) {
        try {
            return genericDao.add(obj);
        } catch (DataAccessException de) {
            return null;
        }
    }

    public T edit(T obj) {
        try {
            return genericDao.modify(obj);
        } catch (DataAccessException de) {
            return null;
        }
    }

    public Boolean delete(T object) {
        try {
            genericDao.delete(object);
            return true;
        } catch (DataAccessException de) {
            return false;
        }
    }

    public List<T> getAll() {
        try {
            return genericDao.getAll();
        } catch (DataAccessException de) {
            return Collections.emptyList();
        }
    }
}

