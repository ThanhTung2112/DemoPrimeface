package net.lvs.view;

import net.lvs.model.Catalog;
import net.lvs.model.Product;
import net.lvs.service.impl.ProductService;
import org.apache.commons.validator.GenericValidator;
import org.primefaces.PrimeFaces;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "UpdateProductView")
public class UpdateProductView extends BaseBean{
    String id;
    String name;
    String catalogID;
    double price;
    String image;

    ProductService service = new ProductService();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public void setImage(String image) {
        this.image = image;
    }
    public void Update(String preID){
        if(validate()){
            Product product = new Product();
            product.setCatalogID(catalogID);
            product.setId(id);
            product.setPrice(price);
            product.setName(name);
            product.setImage(image);

        }
        PrimeFaces.current().dialog().closeDynamic(new Catalog(id,name));

        return;
    }
    private boolean validate() {
        if (GenericValidator.isBlankOrNull(id)) {
            addValidateError("Vui lòng nhập username");
            return false;
        }
        if (GenericValidator.isBlankOrNull(name)) {
            addValidateError("Vui lòng nhập password");
            return false;
        }
        return true;
    }
}
