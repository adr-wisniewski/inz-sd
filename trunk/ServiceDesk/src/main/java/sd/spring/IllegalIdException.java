/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.spring;

/**
 *
 * @author Adrian
 */
public class IllegalIdException extends IllegalValueException {
    public IllegalIdException(String id)
    {
        super("illegalValue.objectNotFound", new Object[] {id} );
    }
}
