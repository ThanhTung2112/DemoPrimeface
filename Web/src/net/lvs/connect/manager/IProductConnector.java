package net.lvs.connect.manager;

import net.lvs.model.Catalog;
import net.lvs.model.Product;

import java.util.List;

public interface IProductConnector {
    List<Product> getList();

    void addNew(Product product);

    void update(String id, Product product);

    void delete (String id);
}
