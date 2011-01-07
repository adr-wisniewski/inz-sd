package sd.signal.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sd.signal.domain.SignalGenerator;

@Component
public class SignalGeneratorValidator implements Validator {
	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#support(Class clazz)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean supports(Class<?> clazz) {
		return clazz.equals(SignalGenerator.class);
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#validate(Object target, Errors errors)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void validate(Object target, Errors errors) {
		SignalGenerator generator = (SignalGenerator)target;

		ValidationUtils.rejectIfEmpty(errors, "criterion", "field.required");
		
		if(generator.getReceiverType() == null) {
			ValidationUtils.rejectIfEmpty(errors, "receiverType", "field.required");
		}
		
		if(generator.getType() == null) {
			ValidationUtils.rejectIfEmpty(errors, "type", "field.required");
		}
	}
}