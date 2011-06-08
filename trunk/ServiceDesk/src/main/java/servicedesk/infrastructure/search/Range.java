/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.infrastructure.search;

/**
 *
 * @param <Type> 
 * @author Adrian
 */
public class Range<Type> {
    private Type min;
    private Type max;

    /**
     * @return the min
     */
    public Type getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(Type min) {
        this.min = min;
    }

    /**
     * @return the max
     */
    public Type getMax() {
        return max;
    }

    /**
     * @param max the max to set
     */
    public void setMax(Type max) {
        this.max = max;
    }
}
