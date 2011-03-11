/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.cmdb.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.springframework.stereotype.Component;
import sd.cmdb.domain.helper.ItemClassVisitor;

/**
 *
 * @author Adrian
 */
@Component
public class EmployeeItemClass extends AdaptorItemClass {

    protected static final Integer ID = new Integer(1);
    protected static final String NAME = "Pracownik";
    protected static final String DESCRIPTION = "Pracownik";

    protected static final Attribute ATTRIBUTE_LOGIN = new Attribute();
    protected static final Attribute ATTRIBUTE_FIRSTNAME = new Attribute();
    protected static final Attribute ATTRIBUTE_LASTNAME = new Attribute();
    protected static final Attribute ATTRIBUTE_PHONENUMBER = new Attribute();
    protected static final Attribute ATTRIBUTE_MOBILEPHONE = new Attribute();
    protected static final Attribute ATTRIBUTE_EMAIL = new Attribute();
    protected static final List<Attribute> ATTRIBUTES = new LinkedList<Attribute>();


    static {
        ATTRIBUTE_LOGIN.setName("Login");
        ATTRIBUTE_LOGIN.setDescription("Login");
        ATTRIBUTE_LOGIN.setDisplayNo(0);
        //ATTRIBUTES.add(ATTRIBUTE_LOGIN);

        
        // "Firstname"
        //    "Lastname"
        //    "PhoneNumber"
        //    "MobilePhone"
        //    "Email"
    }

    public EmployeeItemClass() {
        super(ID, NAME, DESCRIPTION, ATTRIBUTES);
    }

    @Override
    public void accept(ItemClassVisitor visitor) {
        visitor.visit(this);
    }
}
