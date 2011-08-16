/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servicedesk.core.itil.change.domain.entity;

/**
 *
 * @author Adrian
 */
public enum RfcState {
    NEW("Nowy"),
    ASSIGNED("Przypisany"),
    REVIEWED("Po przeglądzie"),
    ASSESSED("Oceniony"),
    AUTHORIZED("Autoryzowany"),
    SCHEDULED("Zaplanowany"),
    BUILT("Wdrożony"),
    CLOSED("Zamknięty"),
    REJECTED("Odrzucony"),
    APPEALED("Apelacja"),
    REOPENED("Otwarty ponownie");
    
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
