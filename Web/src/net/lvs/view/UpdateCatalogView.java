package net.lvs.view;

import net.lvs.model.Catalog;
import net.lvs.service.impl.CatalogService;
import org.apache.commons.validator.GenericValidator;
import org.primefaces.PrimeFaces;

public class UpdateCatalogView extends BaseBean{
    private String id;
    private String name;


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

    CatalogService service = new CatalogService();

    public void Update(String preID){
        if(validate()){
            service.update(preID,new Catalog(id, name));
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
