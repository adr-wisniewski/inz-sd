package sd.im.validator;

import org.junit.runner.Request;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AddRequestValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Request.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
	}

}
