/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.validation;

import org.springframework.validation.BindingResult;

/**
 *
 * @author Adrian
 */
public class BusinessConstraintViolationException extends RuntimeException {

    private BindingResult errors;

    public BusinessConstraintViolationException(BindingResult errors) {
        this.errors = errors;
    }

    public BindingResult getErrors() {
        return errors;
    }
}
