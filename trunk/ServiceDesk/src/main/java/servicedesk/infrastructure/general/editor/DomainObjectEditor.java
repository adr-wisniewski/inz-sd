/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.general.editor;

import java.beans.PropertyEditorSupport;
import java.io.Serializable;
import org.springframework.util.StringUtils;
import servicedesk.infrastructure.general.dao.Dao;
import servicedesk.infrastructure.general.domain.DomainObject;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public class DomainObjectEditor<Type extends DomainObject<Integer>> 
    extends PropertyEditorSupport {
    
    protected Dao<Type, Integer> dao;
    
    public DomainObjectEditor(Dao<Type, Integer> dictionaryPropertyDao) {
        this.dao = dictionaryPropertyDao;
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
