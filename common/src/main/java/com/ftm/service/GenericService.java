package com.ftm.service;

import java.util.List;

/**
 * Created by awharshana on 7/9/2017.
 */
public interface GenericService<T> {

    /**
     * find the data object by it's ID
     * @param id - object id
     * @return
     */
    T getById(String id);

    /**
     * Add data object to the db
     * @param obj
     * @return
     */
    T add(T obj);

    /**
     * Edit the object details and modify the data object in db
     * @param obj - edited object
     * @return
     */
    T edit(T obj);

    /**
     * Delete the given object from the DB
     * @param object
     * @return
     */
    Boolean delete(T object);

    /**
     * Get the all records
     * @return
     */
    List<T> getAll();

}
