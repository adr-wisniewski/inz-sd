/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.spring;

import org.springframework.beans.PropertyAccessException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.FieldError;

/**
 *
 * @author Adrian
 */
public class ExtendedBindingErrorProcessor extends DefaultBindingErrorProcessor{

    @Override
    public void processPropertyAccessException(PropertyAccessException ex, BindingResult bindingResult)
    { 
        String[] codes;
        Object[] arguments;
        String field = ex.getPropertyName();
        Object rejectedValue = ex.getValue();

        if (rejectedValue != null && rejectedValue.getClass().isArray()) {
                rejectedValue = StringUtils.arrayToCommaDelimitedString(ObjectUtils.toObjectArray(rejectedValue));
        }

        if (ex.getCause() != null && ex.getCause() instanceof IllegalValueException)
        {
            IllegalValueException valEx = (IllegalValueException)ex.getCause();
            codes = bindingResult.resolveMessageCodes(valEx.getErrorCode(), field);
            arguments = valEx.getArgs();
        }
        else
        {
            codes = bindingResult.resolveMessageCodes(ex.getErrorCode(), field);
            arguments = getArgumentsForBindError(bindingResult.getObjectName(), field);
        }

        bindingResult.addError(new FieldError(
                        bindingResult.getObjectName(), field, rejectedValue, true,
                        codes, arguments, ex.getLocalizedMessage()));
    }
}