package sd.im.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sd.im.app.Request;

public class EditRequestValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Request.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		Request request = (Request)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
		if(request.getPriority().equals("-1")) {
			errors.rejectValue("priority", "priority.required");
		}
		
		if(request.getStatus() == null) {
			errors.rejectValue("status", "status.required");
		}
		
		if(request.getImpact() == null) {
			errors.rejectValue("impact", "impact.required");
		}
		
	}

}
