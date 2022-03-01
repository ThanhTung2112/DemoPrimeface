package net.lvs.connect.factory;

import net.lvs.model.Catalog;
import net.lvs.model.Product;
import org.bson.Document;
import system.mongo.core.IDynamicObject;
import system.mongo.core.data.IMongoObjectFactory;
import system.mongo.core.data.MongoDynamicObject;

import java.util.UUID;

public class ProductFactory implements IMongoObjectFactory<Product> {
    @Override
    public Product createObject(Document document) {
        Product product = new Product();
        if(null != document.get("_id")){
            product.setId(document.get("_id").toString());
        }
        if(null != document.get("name")){
            product.setName(document.get("name").toString());
        }
        if(null != document.get("image")){
            product.setImage(document.get("image").toString());
        }
        if(null != document.get("price")){
            product.setPrice(document.getDouble("price"));
        }
        if(null != document.get("catalogID")){
            product.setCatalogID(document.get("catalogID").toString());
        }
        return product;
    }
    public IDynamicObject createObject(Product model) {
        IDynamicObject iDynamicObject = null;
        if (null == model.getId() || model.getId().length() == 0) {
            iDynamicObject = new MongoDynamicObject(UUID.randomUUID().toString());
        } else {
            iDynamicObject = new MongoDynamicObject(model.getId());
        }

        iDynamicObject.put("_id", model.getId());
        iDynamicObject.put("name", model.getName());
        return iDynamicObject;
    }
}
