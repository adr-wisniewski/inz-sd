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
    
    public static RfcState get(int id) throws IllegalArgumentException {
        for(RfcState state: RfcState.values()) {
            if(state.ordinal() == id)
                return state;
        }
        
        throw new IllegalArgumentException("Invalid ordinal");
    }
}
