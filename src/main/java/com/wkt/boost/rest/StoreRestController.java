package com.wkt.boost.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.model.Store;
import com.wkt.boost.service.api.CrudService;
import com.wkt.boost.service.api.StoreService;

@RestController
@RequestMapping("/api/store")
public class StoreRestController extends CrudRestController<Store>{
	
	@Autowired
	private StoreService storeService;
	
	@Override
	public CrudService<Store> getService() {
		return storeService;
	}

}
