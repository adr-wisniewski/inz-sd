/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.criterion;

/**
 *
 * @author Adrian
 */
public class SimpleCriterion implements Criterion {
    private final String propertyName;
    private final CriterionOperation type;
    private final Object value;
   
    public SimpleCriterion(String propertyName, CriterionOperation type, Object value) {
        this.propertyName = propertyName;
        this.type = type;
        this.value = value;
    }
    
    /**
     * @return the propertyName
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * @return the type
     */
    public CriterionOperation getType() {
        return type;
    }

    @Override
    public <C> void accept(CriterionVisitor<C> visitor, C context) {
        visitor.visit(this, context);
    }
}
