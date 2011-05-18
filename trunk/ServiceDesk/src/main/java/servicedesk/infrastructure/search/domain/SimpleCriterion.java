/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search.domain;

/**
 *
 * @author Adrian
 */
public class SimpleCriterion implements Criterion {
    private final String name;
    private final Object value;
    private final ComparisonType type;

    public SimpleCriterion(String name, Object value, ComparisonType type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return value;
    }
    
    /**
     * @return the value
     */
    public ComparisonType getType() {
        return type;
    }

    @Override
    public <C> void accept(QueryVisitor<C> visitor, C context) {
        visitor.visit(this, context);
    }
}
