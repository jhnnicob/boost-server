package com.wkt.boost.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.wkt.boost.dao.IBaseDao;
import com.wkt.boost.dao.ICategoryDao;
import com.wkt.boost.dao.IIngredientDao;
import com.wkt.boost.dao.IMaterialDao;
import com.wkt.boost.dao.IProductAttributeDao;
import com.wkt.boost.dao.IProductAttributeValueDao;
import com.wkt.boost.dao.IProductDao;
import com.wkt.boost.dao.IProductIngredient;
import com.wkt.boost.exception.ServiceException;
import com.wkt.boost.model.Category;
import com.wkt.boost.model.Ingredient;
import com.wkt.boost.model.Material;
import com.wkt.boost.model.Product;
import com.wkt.boost.model.ProductAttribute;
import com.wkt.boost.model.ProductAttributeValue;
import com.wkt.boost.model.ProductIngredient;
import com.wkt.boost.model.UUIDModel;
import com.wkt.boost.model.transfer.TFConverter;
import com.wkt.boost.model.transfer.TFUUIDModel;
import com.wkt.boost.service.api.SyncService;

@Service
public class SyncServiceImpl implements SyncService {

	@Autowired
	private ICategoryDao categoryDao;
	@Autowired
	private IProductDao productDao;
	@Autowired
	private IMaterialDao materialDao;
	@Autowired
	private IIngredientDao ingredientDao;
	@Autowired
	private IProductIngredient productIngredientDao;
	@Autowired 
	private IProductAttributeDao productAttributeDao;
	@Autowired
	private IProductAttributeValueDao productAttributeValueDao;
	
	// private Gson gson = new Gson();

	@Override
	public String getUserData(int companyId, Date lastSyncDate) throws ServiceException {

		JsonObject json = new JsonObject();

		try {
			getData("Category", Category.class, categoryDao, json);
			getData("Product", Product.class, productDao, json);
			getData("Material", Material.class, materialDao, json);
			getData("Ingredient", Ingredient.class, ingredientDao, json);
			getData("ProductIngredient", ProductIngredient.class, productIngredientDao, json);
			getData("ProductAttribute", ProductAttribute.class, productAttributeDao, json);
			getData("ProductAttributeValue", ProductAttributeValue.class, productAttributeValueDao, json);

		} catch (Exception e) {
			throw new ServiceException(e);
		}

		return json.toString();
	}

	private <T extends UUIDModel, M extends TFUUIDModel> void getData(String key, Class<?> destType, IBaseDao<T> dao,
			JsonObject json) throws Exception {

		// Get data updates from using DAO
		List<T> list = dao.list();

		// Convert data to transferable object
		// List<M> mlist = TFConverter.fromList(list, destType);

		JsonArray aList = TFConverter.toJsonList(list, destType);

		// Convert data to json array and add to returning json object
		// String data = gson.toJson(mlist);
		// String data = gson.toJson(mlist);
		// JsonArray jsonArray = JsonParser.parseString(data).getAsJsonArray();
		// JsonArray jsonArray = JsonParser.parseString(data).getAsJsonArray();

		// JsonElement element = gson.toJsonTree(mlist, new TypeToken<List<M>>()
		// {}.getType());

		json.add(key, aList);
	}
}
