package com.wkt.boost.dao;

import java.util.Date;
import java.util.List;

import com.wkt.boost.exception.DaoException;
import com.wkt.boost.model.UUIDModel;

public interface IBaseDao<T extends UUIDModel> {
	
	Class<T> getType();
	
	T save(T object) throws DaoException;
	
	T update(T object, int id) throws DaoException;
	
	boolean delete(int Id) throws DaoException;
	
	List<T> list() throws DaoException;
	
	T find(int id) throws DaoException;
	
	List<T> getUpdates(Date lastSyncDate) throws DaoException;
}
