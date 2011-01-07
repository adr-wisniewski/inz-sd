/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.validation;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

/**
 *
 * @author Adrian
 */
public abstract class ValidationUtils {
     static public <Target> Validated<Target> validate(Target target, String targetName, Validator... validators) {

        BindingResult errors = new BeanPropertyBindingResult(target, "target");

        for(Validator validator: validators) {
            validator.validate(target, errors);
        }

        return new Validated<Target>(target, errors);
    }
}
