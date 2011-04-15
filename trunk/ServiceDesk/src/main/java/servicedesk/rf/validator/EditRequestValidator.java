package servicedesk.rf.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import servicedesk.rf.domain.RequestAttribute;
import servicedesk.rf.domain.ServiceRequest;

@Component
public class EditRequestValidator implements Validator {
	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#support(Class clazz)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ServiceRequest.class);
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#validate(Object target, Errors errors)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void validate(Object target, Errors errors) {
		ServiceRequest request = (ServiceRequest)target;
		
		int counter = 0;
		for(RequestAttribute attr : request.getAttributes()) {
			if(attr.getAttributeType().getRequired()) {
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "attributes[" + counter + "].value", "field.required");
			}
			++counter;
		}
	}
}