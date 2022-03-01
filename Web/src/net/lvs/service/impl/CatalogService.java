package net.lvs.service.impl;

import net.lvs.connect.manager.ICatalogConnector;
import net.lvs.connect.manager.impl.CatalogConnector;
import net.lvs.model.Catalog;
import net.lvs.service.base.IService;

import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import java.util.List;

@Named
@ApplicationScoped
public class CatalogService implements IService<Catalog>{

    ICatalogConnector connect = new CatalogConnector();

    @Override
    public List<Catalog> getList() {

        return connect.getList();
    }

    @Override
    public void addNew(Catalog catalog) {
        connect.addNew(catalog);
    }

    @Override
    public void delete(String id) {
        connect.delete(id);
    }

    @Override
    public void update(String id, Catalog catalog) {
        connect.update(id, catalog);
    }
}
