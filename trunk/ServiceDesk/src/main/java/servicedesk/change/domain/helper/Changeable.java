/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.change.domain.helper;

/**
 *
 * @author Adrian
 */
public class Changeable<Type> {
    private Type previousValue;
    private Type nextValue;
    private boolean changed;

    public Changeable() {
        
    }
    
    public Changeable(Type previousValue, Type nextValue) {
        this.previousValue = previousValue;
        this.nextValue = nextValue;
        
        this.changed =
            this.previousValue == null && this.nextValue != null
            || this.previousValue != null && !this.previousValue.equals(this.nextValue);
    }
    
    /**
     * @return the previousValue
     */
    public Type getPreviousValue() {
        return previousValue;
    }

    /**
     * @param previousValue the previousValue to set
     */
    public void setPreviousValue(Type previousValue) {
        this.previousValue = previousValue;
    }

    /**
     * @return the currentValue
     */
    public Type getNextValue() {
        return nextValue;
    }

    /**
     * @param currentValue the currentValue to set
     */
    public void setNextValue(Type nextValue) {
        this.nextValue = nextValue;
    }

    /**
     * @return the changed
     */
    public boolean isChanged() {
        return changed;
    }

    /**
     * @param changed the changed to set
     */
    public void setChanged(boolean changed) {
        this.changed = changed;
    }
}
