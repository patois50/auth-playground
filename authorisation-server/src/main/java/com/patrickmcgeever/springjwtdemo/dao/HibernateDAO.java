package com.patrickmcgeever.springjwtdemo.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface HibernateDAO<T extends Serializable> {
    T findOne(long id);

    List<T> findAll();

    void persist(T entity);

    T update(T entity);

    void delete(T entity);

    void deleteById(long id);

    Session getCurrentSession();
}
