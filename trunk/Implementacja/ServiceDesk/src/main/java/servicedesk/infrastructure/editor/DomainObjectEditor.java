/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.util.StringUtils;
import servicedesk.infrastructure.interfaces.dao.Dao;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public class DomainObjectEditor<Type extends DomainObject<Integer>> 
    extends PropertyEditorSupport {
    
    protected Dao<Type, Integer> dao;
    
    public DomainObjectEditor(Dao<Type, Integer> dao) {
        this.dao = dao;
    }
    
    @Override
    public void setAsText(String text) {
        if(StringUtils.hasText(text))
        {
            Integer id = Integer.parseInt(text);
            Type domainObject = dao.load(id);
            setValue(domainObject);
            // TODO: get instead of load + error checking?
        }
        else
        {
            setValue(null);
        }
    }
}
