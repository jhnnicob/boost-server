package com.wkt.boost.model.transfer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.wkt.boost.model.UUIDModel;
import com.wkt.boost.util.ReflectionUtil;

public class TFConverter {

	// Convert Model to Destination model
	// TFUUIDModel = Base model for transferable objects
	// UUIDModel = Base model for source objects
	/*
	 * public static <D extends TFUUIDModel, S extends UUIDModel> D newFrom(S
	 * source, Class<?> destination) { if (source == null) { return null; }else {
	 * ModelMapper mapper = new ModelMapper(); D obj = (D) mapper.map(source,
	 * destination); return obj; } }
	 */

	public static <D extends TFUUIDModel, S extends UUIDModel> List<D> fromList(List<S> list, Class<?> destination)
			throws Exception {
		List<D> res = new ArrayList<>();

		if (list == null || list.isEmpty()) {
		} else {
			for (S source : list) {

				Constructor<?> constructor = destination.getConstructors()[0];
				D newD = (D) constructor.newInstance();
				// D newD = new D();

				D obj = newD.newFrom(source, destination);

				// D obj = D.newFrom(source, destination);
				if (obj == null) {
				} else {
					res.add(obj);
				}

			}
		}

		return res;
	}

	public static <S extends UUIDModel> JsonArray toJsonList(List<S> list, Class<?> clazz)
			throws IllegalArgumentException, IllegalAccessException {
		JsonArray res = new JsonArray();

		if (list == null || list.isEmpty()) {
		} else {

			for (S item : list) {
					
				JsonObject object = new JsonObject();
				String nullString = null;
				
				//Field[] fields = clazz.getDeclaredFields();
				List<Field> fields = ReflectionUtil.getAllFields(clazz);
				
				for (Field field : fields) {
					// set value from json object
					boolean access = field.isAccessible();
					field.setAccessible(true);

					Object value = field.get(item);
					Class<?> type = field.getType();
					String fieldName = field.getName();

					//System.out.println("Field name" + fieldName);
					
					// check field type
					if (UUIDModel.class.isAssignableFrom(type)) {
						// field here is expected to be a uuid string
						object.remove(fieldName);
						if (value != null) {
							object.addProperty(fieldName, ((UUIDModel) value).getUuId());
						}else {
							object.addProperty(fieldName, nullString);
						}
					} else if (List.class.isAssignableFrom(type)) {
						// field is a collection
						List<?> valueList = (List<?>) value;
						JsonArray arr = new JsonArray();
						if (valueList == null || valueList.isEmpty()) {
						} else {
							for (Object listItem : valueList) {
								if (listItem == null) {
								} else {
									if (UUIDModel.class.isAssignableFrom(listItem.getClass())) {
										UUIDModel uumodel = (UUIDModel) listItem;
										arr.add(uumodel.getUuId());
									}else {
										System.out.println(clazz.getName() + " : Unhandle list type. Field Name: " + fieldName
												+ ", Type: " + type.getName());
									}
								}
							}
						}
						object.add(fieldName, arr);
					} else if (Number.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (Number) value);
					} else if (String.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (String) value);
					} else if (long.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (long) value);
					} else if (int.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (int) value);
					} else if (short.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (short) value);
					} else if (float.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (float) value);
					} else if (boolean.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (boolean) value);
					} else if (Boolean.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (Boolean) value);
					} else if (Double.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (Double) value);
					} else if (double.class.isAssignableFrom(type)) {
						object.addProperty(fieldName, (double) value);
					} else if (Date.class.isAssignableFrom(type)) {
						if (value == null) {
							object.addProperty(fieldName, nullString);
						}else {
							object.addProperty(fieldName, ((Date)value).toString());
						}
						
					} else {
						System.out.println(clazz.getName() + " : Unhandle field type. Field Name: " + fieldName
								+ ", Type: " + type.getName());
					}

					field.setAccessible(access);
				}

				res.add(object);

			}
		}

		return res;
	}

}
