/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p.lodz.pl.library.converters;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import p.lodz.pl.mob.endpoints.MOBEndpointLocal;

/**
 *
 * @author Paweł
 */
@ManagedBean(name = "authorConverterBean")
@FacesConverter(value = "authorConverter")
public class AuthorConverter implements Converter {

    @EJB
    private MOBEndpointLocal mOBEndpoint;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String[] parts = value.split(" ");
        value = (parts[0].trim());
        return mOBEndpoint.getAuthorByName(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object obj) {
        return obj.toString();
    }
    
}
