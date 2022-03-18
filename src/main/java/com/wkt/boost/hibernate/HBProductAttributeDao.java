package com.wkt.boost.hibernate;

import org.springframework.stereotype.Repository;

import com.wkt.boost.dao.IProductAttributeDao;
import com.wkt.boost.model.ProductAttribute;

@Repository
public class HBProductAttributeDao extends HBBaseDao<ProductAttribute> implements IProductAttributeDao {

}
