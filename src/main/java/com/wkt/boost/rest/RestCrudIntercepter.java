package com.wkt.boost.rest;

import com.wkt.boost.model.UUIDModel;

public interface RestCrudIntercepter<T extends UUIDModel> {

	T beforeSave(T t); 
	
	T beforeUpdate(T t);
	
}
