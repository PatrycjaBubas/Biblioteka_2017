/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.mob.web.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import p.lodz.pl.library.entities.Categories;

/**
 *
 * @author Paweł
 */
@ManagedBean
@ViewScoped
public class AddCategoryPageBean {
    
    @Inject
    private Session session;
    
    private String name;
    private String description;
    
    private final Categories category = new Categories();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String addCategory() {
        category.setName(name);
        category.setDescription(description);
        
        session.addCategory(category);
        return "successAfterCategoryAdded";
    }
}
