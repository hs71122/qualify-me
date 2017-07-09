package com.ftm.dao.impl;

import com.ftm.dao.GenericDao;
import com.ftm.exception.DataAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

/**
 * Created by awharshana on 7/9/2017.
 */
public class GenericMongoDaoImpl <T> implements GenericDao<T> {

    private static final Logger logger = LoggerFactory.getLogger(GenericMongoDaoImpl.class);

    @Autowired
    protected MongoOperations mongoOperations;
    private Class<T> type;

    public GenericMongoDaoImpl(Class<T> type) {
        this.type = type;
    }

    public T getById(Object id) throws DataAccessException {
        if (logger.isDebugEnabled())
            logger.debug("type {} getById", type);
        try{
            return mongoOperations.findById(id, type);
        }catch(Exception e){
            throw new DataAccessException(e);
        }
    }

    public List<T> getAll() throws DataAccessException {
        if (logger.isDebugEnabled())
            logger.debug("type {} getAll", type);
        try {
            return mongoOperations.findAll(type);
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }

    public T add(T object) throws DataAccessException {
        if (logger.isDebugEnabled())
            logger.debug("type {} add", type);
        try {
            mongoOperations.insert(object);
            return object;
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }

    public T modify(T object) throws DataAccessException {
        if (logger.isDebugEnabled())
            logger.debug("type {} modify", type);
        try {
            mongoOperations.save(object);
            return object;
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }

    public T delete(T object) throws DataAccessException {
        if (logger.isDebugEnabled())
            logger.debug("type {} delete", type);
        try {
            mongoOperations.remove(object);
            return object;
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }
}