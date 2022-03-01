package net.lvs.connect.factory;

import net.lvs.model.Catalog;
import org.bson.Document;
import system.mongo.core.IDynamicObject;
import system.mongo.core.data.IMongoObjectFactory;
import system.mongo.core.data.MongoDynamicObject;

import java.util.UUID;

public class CatalogFactory implements IMongoObjectFactory {
    @Override
    public Catalog createObject(Document document) {
        Catalog catalog = new Catalog();
        if(null != document.get("_id")){
            catalog.setId(document.get("_id").toString());
        }
        if(null != document.get("name")){
            catalog.setName(document.get("name").toString());
        }
        return catalog;
    }
    public IDynamicObject createObject(Catalog model) {
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
