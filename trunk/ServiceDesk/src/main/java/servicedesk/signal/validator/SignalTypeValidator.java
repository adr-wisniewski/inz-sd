package servicedesk.signal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import servicedesk.signal.domain.SignalObjectAttributeType;
import servicedesk.signal.domain.SignalType;

@Component
public class SignalTypeValidator implements Validator {
	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#support(Class clazz)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean supports(Class<?> clazz) {
		return clazz.equals(SignalType.class);
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#validate(Object target, Errors errors)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void validate(Object target, Errors errors) {
		SignalType signalType = (SignalType)target;

		ValidationUtils.rejectIfEmpty(errors, "subjectTemplate", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "messageTemplate", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "name", "field.required");
		
		if(signalType.getObjectType() == null) {
			errors.rejectValue("objectType", "field.required");
		}
		
		if(signalType.getSignificance() == null) {
			errors.rejectValue("significance", "field.required");
		}
		
		validateTemplate(errors, signalType, signalType.getSubjectTemplate(), "subjectTemplate");
		validateTemplate(errors, signalType, signalType.getMessageTemplate(), "messageTemplate");
	}

	protected void validateTemplate(Errors errors, SignalType signalType, String template, String field) {
		int fromIndex = -1;
		while((fromIndex = template.indexOf("${", fromIndex + 1)) != -1) {
			int toIndex = template.indexOf("}", fromIndex);
			String param = template.substring(fromIndex + 2, toIndex);
			if(!validParam(param, signalType)) {
				errors.rejectValue(field, "wrong_attribute", new Object[] {param}, "Nie poprawny atrybut: " + param);
			}
		}
	}
	
	private boolean validParam(String param, SignalType signalType) {
		for(SignalObjectAttributeType at : signalType.getObjectType().getAttributeTypes()) {
			if(at.getName().equals(param)) {
				return true;
			}
		}
		return false;
	}
}