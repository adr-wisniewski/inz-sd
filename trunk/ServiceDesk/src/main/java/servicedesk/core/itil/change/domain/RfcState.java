/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain;

/**
 *
 * @author Adrian
 */
public enum RfcState {
    NEW("Nowy"),
    REOPENED("Apelacja"),
    ASSIGNED("Przypisany"),
    ALLOCATED("Zaalokowany"),
    AUTHORIZED("Autoryzowany");
    
    private String name;
    
    private RfcState(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getId() {
        return ordinal();
    }
}
