package net.lvs.connect.manager.impl;

import net.lvs.connect.factory.ProductFactory;
import net.lvs.connect.manager.IProductConnector;
import net.lvs.connect.manager.base.BaseConnector;
import net.lvs.model.Catalog;
import net.lvs.model.Product;
import system.mongo.core.connector.MongoObjectConnector;

import java.util.List;

public class ProductConnector extends BaseConnector implements IProductConnector {
    private MongoObjectConnector getMongoObjectConnectorProduct() {
        return getMongoObjectConnector("Product");
    }

    @Override
    public List<Product> getList() {
        return getMongoObjectConnectorProduct().listAll(new ProductFactory());
    }

    @Override
    public void addNew(Product product) {
        getMongoObjectConnectorProduct().insert(new ProductFactory().createObject(product));
    }

    @Override
    public void update(String id, Product product) {
        getMongoObjectConnectorProduct().removeDocument("_id", id);
        getMongoObjectConnectorProduct().insert(new ProductFactory().createObject(product));
    }

    @Override
    public void delete(String id) {
        getMongoObjectConnectorProduct().removeDocument("_id", id);
    }
}
