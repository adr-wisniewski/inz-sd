/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.validation;

import org.springframework.validation.BindingResult;

/**
 *
 * @author Adrian
 */
public class Validated<Target> {

    Target target;
    BindingResult errors;

    public Validated(Target target, BindingResult errors) {
        this.target = target;
        this.errors = errors;
    }

    public Target getObject() {
        return target;
    }

    public BindingResult getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return errors != null && errors.hasErrors();
    }
}
