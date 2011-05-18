/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.extensions.hibernate.search;

/**
 *
 * @author Adrian
 */
public class DetachedCriteriaBuilderTypeContext {
    private String name;
    private Object value;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
