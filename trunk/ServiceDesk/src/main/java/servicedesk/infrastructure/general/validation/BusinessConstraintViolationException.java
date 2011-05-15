/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.general.validation;

import org.springframework.validation.BindingResult;

/**
 *
 * @author Adrian
 */
public class BusinessConstraintViolationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private BindingResult errors;

    public BusinessConstraintViolationException(BindingResult errors) {
        this.errors = errors;
    }

    public BindingResult getErrors() {
        return errors;
    }
}
