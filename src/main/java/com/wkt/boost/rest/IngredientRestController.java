package com.wkt.boost.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.model.Ingredient;
import com.wkt.boost.service.api.CrudService;
import com.wkt.boost.service.api.IngredientService;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientRestController extends CrudRestController<Ingredient>{
	
	@Autowired
	private IngredientService ingredientService;
	
	@Override
	public CrudService<Ingredient> getService() {
		return ingredientService;
	}

}
