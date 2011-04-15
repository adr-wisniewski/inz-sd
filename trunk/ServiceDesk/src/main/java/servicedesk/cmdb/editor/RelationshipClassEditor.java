/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.cmdb.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import servicedesk.cmdb.domain.RelationshipClass;
import servicedesk.cmdb.service.RelationshipClassService;

/**
 *
 * @author Adrian
 */
@Component
public class RelationshipClassEditor extends PropertyEditorSupport {
    @Autowired
    RelationshipClassService service;

    @Override
    public void setAsText(String text) {
        if(StringUtils.hasText(text))
        {
            Integer id = Integer.parseInt(text);
            RelationshipClass relationshipClass = service.load(id);
            setValue(relationshipClass);
        }
        else
        {
            setValue(null);
        }
    }
}
