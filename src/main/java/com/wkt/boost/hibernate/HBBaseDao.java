package com.wkt.boost.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.exception.DaoException;
import com.wkt.boost.model.UUIDModel;

@Repository
public abstract class HBBaseDao<T extends UUIDModel> implements IBaseDao<T>{
	
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public T save(T object) throws DaoException {
		Session currSession = entityManager.unwrap(Session.class);
		Transaction tx = currSession.beginTransaction();
		try {
			Integer id = (Integer) currSession.save(object);
			tx.commit();
			return find(id); 
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	

	@Override
	public T update(T object, int id) throws DaoException{
		Session currSession = entityManager.unwrap(Session.class);
		Transaction tx = currSession.beginTransaction();
		try {
			currSession.update(object);
			tx.commit();
			return find(id);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public boolean delete(int id) throws DaoException{
		Session currSession = entityManager.unwrap(Session.class);
		Transaction tx = currSession.beginTransaction();
		try {			
			T emp = (T) currSession.get(getType(), id);
			currSession.delete(emp);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public List<T> list() throws DaoException{
		try {
			Session currSession = entityManager.unwrap(Session.class);
			Query<T> query = currSession.createQuery("from " + getType().getSimpleName(), getType());
			List<T> list = query.getResultList();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

	@Override
	public T find(int id) throws DaoException{
		try {
			Session currSession = entityManager.unwrap(Session.class);
			 T object = currSession.get(getType(), id);
			 return object;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}
	
	@Override
	public List<T> getUpdates(Date lastSyncDate) throws DaoException {
		//TODO: Sync logic query. Return all for the meantime
		
		try {
			Session currSession = entityManager.unwrap(Session.class);
			Query<T> query = currSession.createQuery("from " + getType().getSimpleName(), getType());
			List<T> list = query.getResultList();
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e);
		}
	}

}
