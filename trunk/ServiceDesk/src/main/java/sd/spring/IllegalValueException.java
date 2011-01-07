/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.spring;

/**
 *
 * @author Adrian
 */
public class IllegalValueException extends IllegalArgumentException {
    private String errorCode;
    private Object[] args;

    public IllegalValueException(String errorCode, Object[] args)
    {
        this.errorCode=errorCode;
        this.args=args;
    }

    public IllegalValueException(String errorCode)
    {
        this(errorCode,null);
    }

    public Object[] getArgs()
    {
        return args;
    }

    public String getErrorCode()
    {
        return errorCode;
    }
}
