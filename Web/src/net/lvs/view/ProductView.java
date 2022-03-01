package net.lvs.view;


import net.lvs.model.Catalog;
import net.lvs.model.Product;
import net.lvs.service.impl.ProductService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "ProductView")
@ViewScoped
public class ProductView {
    List<Product> products;
    Product product;
    Product selected;
    ProductService service = new ProductService();

    @PostConstruct
    public void initData(){
        product = new Product();
        selected = new Product();
        products = new ArrayList<Product>();
        products = service.getList();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getSelected() {
        return selected;
    }

    public void setSelected(Product selected) {
        this.selected = selected;
    }

    public ProductService getService() {
        return service;
    }

    public void setService(ProductService service) {
        this.service = service;
    }

    public void viewAddProduct() {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("addProduct", options, null);
    }
    public void viewUpdateProduct(Catalog catalog) {
        Map<String, Object> options = new HashMap<>();
        options.put("resizable", false);
        PrimeFaces.current().dialog().openDynamic("updateProduct", options, null);
    }
    public void delete(String id){
        addMessage("Confirmed", "Record deleted");
        service.delete(id);
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
