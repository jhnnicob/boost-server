package com.wkt.boost.rest;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.wkt.boost.model.UUIDModel;
import com.wkt.boost.service.api.CrudService;
import com.wkt.boost.util.ExceptionUtil;

public abstract class CrudRestController<T extends UUIDModel> {
	
	public abstract CrudService<T> getService();
	
	//Override to set Intercepter
	public RestCrudIntercepter<T> getIntercepter(){
		return null;
	}
	
	@PostMapping("")
	public RestResult save(@RequestBody T object) {
		RestResult res = RestResult.negativeInstance();
		try {
			
			if (getIntercepter() != null) {
				object = getIntercepter().beforeSave(object);
			} 
			
			if (object.getUuId() == null) {
				object.setUuId(UUID.randomUUID().toString());
			}
			
			object.setDateCreated(new Date());
			
			res.setData(getService().save(object));
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setStackTrace(ExceptionUtil.toString(e));
		}
		return res;
	}
	
	@PutMapping("")
	public RestResult update(@RequestBody T object) {
		RestResult res = RestResult.negativeInstance();
		try {
			Class<?> someClass = getService().getDao().getType();
			Field idField = someClass.getDeclaredField("id");
			idField.setAccessible(true);
			int id =  (int) idField.get(object);
			object.setDateModified(new Date());
			
			if (getIntercepter() != null) {
				object = getIntercepter().beforeUpdate(object);
			} 
			
			res.setData(getService().update(object, id));
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setStackTrace(ExceptionUtil.toString(e));
		}
		return res;
	}
	
	@DeleteMapping("/{id}")
	public RestResult delete(@PathVariable("id") int id) {
		RestResult res = RestResult.negativeInstance();
		
		try {
			res.setData(getService().delete(id));
			res.setSuccess(true);
			res.setMessage("Record deleted");
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setStackTrace(ExceptionUtil.toString(e));
		}
		return res;
	}
	
	@GetMapping("/{id}")
	public RestResult find(@PathVariable("id") int id) {
		RestResult res = RestResult.negativeInstance();
		try {
			res.setData(getService().find(id));
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setStackTrace(ExceptionUtil.toString(e));
		}
		return res;
	}
	
	@GetMapping("")
	public RestResult list(){
		RestResult res = RestResult.negativeInstance();
		try {
			res.setData(getService().list());
			res.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			res.setMessage(e.getMessage());
			res.setStackTrace(ExceptionUtil.toString(e));
		}
		return res;
	}
	
	
	//Interceptors
	protected T beforeSave(T object) {
		return null;
	}
}
