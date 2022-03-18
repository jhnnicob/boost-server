package com.wkt.boost.rest;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wkt.boost.model.Product;
import com.wkt.boost.model.ProductAttribute;
import com.wkt.boost.model.ProductAttributeValue;
import com.wkt.boost.model.ProductIngredient;
import com.wkt.boost.service.api.CrudService;
import com.wkt.boost.service.api.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductRestController extends CrudRestController<Product> implements RestCrudIntercepter<Product>{
	
	@Autowired
	ProductService productService;
	
	@Override
	public CrudService<Product> getService() {
		return productService;
	}
	
	@Override
	public RestCrudIntercepter<Product> getIntercepter() {
		return this;
	}
	
	@Override
	public Product beforeSave(Product object) {
		/**
		 * Set UUID on productIngredient and Ingredient Model
		 * */
		if (object == null) {
		}else if (object.getProductIngredientList() == null || object.getProductIngredientList().isEmpty()) {
		}else {
			//set productIngredient UUID
			for (ProductIngredient pi : object.getProductIngredientList()) {
				if (pi.getUuId() == null) {
					pi.setUuId(UUID.randomUUID().toString());
				}
				
				//set Ingredient UUID
				if (pi.getIngredient() == null) {
				}else {
					if (pi.getIngredient().getUuId() == null) {
						pi.getIngredient().setUuId(UUID.randomUUID().toString());
					}
				}
			}
		}
		
		/**
		 * Set UUID on Product Attribute and Product Attribute Value
		 * */
		if (object == null) {
		}else if (object.getAttributeList() == null || object.getAttributeList().isEmpty()) {
		}else {
			//Product Attribute UUID
			for (ProductAttribute pa : object.getAttributeList()) {
				if (pa.getUuId() == null) {
					pa.setUuId(UUID.randomUUID().toString());
				}
				
				//product ingredient UUID
				if (pa.getValueList() == null || pa.getValueList().isEmpty()) {
				}else {
					for (ProductAttributeValue pav : pa.getValueList()) {
						if (pav.getUuId() == null) {
							pav.setUuId(UUID.randomUUID().toString());
						}
					}
				}
			}
		}
		
		return object;
	}
	
	@Override
	public Product beforeUpdate(Product t) {
		return t;
	}
	
}
