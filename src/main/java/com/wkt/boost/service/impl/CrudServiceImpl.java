package com.wkt.boost.service.impl;

import java.util.List;

import com.wkt.boost.exception.DaoException;
import com.wkt.boost.exception.ServiceException;
import com.wkt.boost.model.UUIDModel;
import com.wkt.boost.service.api.CrudService;

public abstract class CrudServiceImpl<T extends UUIDModel> implements CrudService<T> {
	
	
	@Override
	public T save(T object) throws ServiceException {
		try {
			return getDao().save(object);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	@Override
	public T update(T object, int id) throws ServiceException {
		try {
			return getDao().update(object, id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	@Override
	public boolean delete(int id) throws ServiceException {
		try {
			return getDao().delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	@Override
	public T find(int id) throws ServiceException {
		try {
			return getDao().find(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
	
	@Override
	public List<T> list() throws ServiceException {
		try {
			return getDao().list();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
	}
}