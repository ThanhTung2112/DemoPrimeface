package net.lvs.view;

import net.lvs.model.Catalog;
import net.lvs.service.impl.CatalogService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "CatalogView")
@ViewScoped
public class CatalogView {
    private List<Catalog> catalogs;

    private Catalog catalog;

    private Catalog selected;

    public Catalog getSelected() {
        return selected;
    }

    public void setSelected(Catalog selected) {
        this.selected = selected;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    private CatalogService service = new CatalogService();

    public List<Catalog> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public CatalogService getService() {
        return service;
    }

    public void setService(CatalogService service) {
        this.service = service;
    }

    @PostConstruct
    public void initData(){
        catalog = new Catalog();
        selected = new Catalog();
        catalogs = new ArrayList<Catalog>();
        catalogs = service.getList();
    }
    public void delete(String id){
        service.delete(id);
        initData();
    }
    public void viewAddCatalogs() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("addCatalog", options, null);
    }
    public void viewUpdateCatalogs(Catalog catalog) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("updateCatalog", options, null);
    }

    public void test(){
        System.out.println("catalog Name:" + catalog.getName());
        System.out.println("catalog ID: " + catalog.getId());
        System.out.println("test");
    }


}
