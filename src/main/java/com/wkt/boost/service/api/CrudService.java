package com.wkt.boost.service.api;

import java.util.List;

import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.exception.ServiceException;
import com.wkt.boost.model.UUIDModel;

public interface CrudService<T extends UUIDModel> {
	
	//Dao use for the implementation
	IBaseDao<T> getDao();
	
	T save(T object) throws ServiceException;
	
	T update(T object, int id) throws ServiceException;
	
	boolean delete(int Id) throws ServiceException;
	
	List<T> list() throws ServiceException;
	
	T find(int id) throws ServiceException;
	
}
