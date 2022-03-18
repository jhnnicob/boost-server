package com.wkt.boost.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.model.Material;
import com.wkt.boost.service.api.CrudService;
import com.wkt.boost.service.api.MaterialService;

@RestController
@RequestMapping("/api/material")
public class MaterialRestController extends CrudRestController<Material>{

	@Autowired
	private MaterialService materialService;
	
	@Override
	public CrudService<Material> getService() {
		return materialService;
	}
	
}
