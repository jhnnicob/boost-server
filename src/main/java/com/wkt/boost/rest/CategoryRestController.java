package com.wkt.boost.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.model.Category;
import com.wkt.boost.service.api.CategoryService;
import com.wkt.boost.service.api.CrudService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController extends CrudRestController<Category>{
	
	@Autowired
	private CategoryService categoryService;
	
	@Override
	public CrudService<Category> getService() {
		return categoryService;
	}

}
