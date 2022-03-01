package net.lvs.connect.manager;

import net.lvs.model.Catalog;

import java.util.List;

public interface ICatalogConnector {
    List<Catalog> getList();

    void addNew(Catalog catalog);

    void update(String id, Catalog catalog);

    void delete (String id);
}
