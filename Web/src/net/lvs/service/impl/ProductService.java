package net.lvs.service.impl;

import net.lvs.connect.manager.IProductConnector;
import net.lvs.connect.manager.impl.ProductConnector;
import net.lvs.model.Product;
import net.lvs.service.base.IService;

import java.util.List;

public class ProductService implements IService<Product> {
    IProductConnector connector = new ProductConnector();
    @Override
    public List<Product> getList() {
        return connector.getList();
    }

    @Override
    public void addNew(Product product) {
        connector.addNew(product);
    }

    @Override
    public void delete(String id) {
        connector.delete(id);
    }

    @Override
    public void update(String id, Product product) {
        connector.update(id, product);
    }
}
