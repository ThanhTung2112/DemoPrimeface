package net.lvs.connect.manager.impl;

import net.lvs.connect.factory.CatalogFactory;
import net.lvs.connect.manager.ICatalogConnector;
import net.lvs.connect.manager.base.BaseConnector;
import net.lvs.model.Catalog;
import system.mongo.core.connector.MongoObjectConnector;

import java.util.List;


public class CatalogConnector extends BaseConnector implements ICatalogConnector {
    private MongoObjectConnector getMongoObjectConnectorCatalog() {
        return getMongoObjectConnector("Catalog");
    }

    @Override
    public List<Catalog> getList() {
        return getMongoObjectConnectorCatalog().listAll(new CatalogFactory());
    }

    @Override
    public void addNew(Catalog catalog) {
        getMongoObjectConnectorCatalog().insert(new CatalogFactory().createObject(catalog));
    }

    @Override
    public void update(String id, Catalog catalog) {
        getMongoObjectConnectorCatalog().removeDocument("_id", id);
        getMongoObjectConnectorCatalog().insert(new CatalogFactory().createObject(catalog));
      //  getMongoObjectConnectorCatalog().update(catalog);
    }

    @Override
    public void delete(String id) {
        getMongoObjectConnectorCatalog().removeDocument("_id", id);
    }
}
