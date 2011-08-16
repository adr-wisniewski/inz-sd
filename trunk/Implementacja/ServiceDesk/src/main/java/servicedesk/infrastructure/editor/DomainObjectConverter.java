/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.editor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import servicedesk.infrastructure.interfaces.domain.DomainObject;

/**
 *
 * @author Adrian
 */
@Component
public class DomainObjectConverter implements Converter<DomainObject, String> {

    @Override
    public String convert(DomainObject source) {
        return source.getId() != null ? source.getId().toString() : "";
    }
}
