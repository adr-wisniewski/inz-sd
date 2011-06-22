/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.editor;

import java.beans.PropertyEditorSupport;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.util.StringUtils;

/**
 *
 * @author Adrian
 */
public class BeanPropertyEditor extends PropertyEditorSupport {

    private BeanFactory beanFactory;
    private final Class<?> requiredType;
    
    public BeanPropertyEditor(Class<?> requiredType, BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        this.requiredType = requiredType;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if(StringUtils.hasText(text)) {
            String beanName = text.trim();
            try {
                Object bean = beanFactory.getBean(beanName, requiredType);
                setValue(bean);
            } catch(BeansException ex) {
                throw new IllegalArgumentException("Incorrect bean name" + beanName, ex);
            }
        } else {
            setValue(null);
        }
    }
}
