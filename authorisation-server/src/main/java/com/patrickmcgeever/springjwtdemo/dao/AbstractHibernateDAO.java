package com.patrickmcgeever.springjwtdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDAO< T extends Serializable> implements HibernateDAO<T> {

    private Class< T > clazz;

    public AbstractHibernateDAO(Class< T > clazz) {
        this.clazz = clazz;
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public T findOne(long id) {
        return (T) getCurrentSession().get( clazz, id );
    }
    @Override
    public List< T > findAll() {
        return getCurrentSession()
                .createQuery( "from " + clazz.getName() ).list();
    }

    @Override
    public void persist(T entity) {
        getCurrentSession().persist( entity );
    }

    @Override
    public T update(T entity) {
        return (T) getCurrentSession().merge( entity );
    }

    @Override
    public void delete(T entity) {
        getCurrentSession().delete( entity );
    }
    @Override
    public void deleteById(long id) {
        final T entity = findOne( id);
        delete( entity );
    }

    @Override
    public final Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}
