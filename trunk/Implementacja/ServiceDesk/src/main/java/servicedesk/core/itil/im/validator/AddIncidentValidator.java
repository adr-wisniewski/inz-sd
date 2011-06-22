/**
 * 
 */
package servicedesk.core.itil.im.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import servicedesk.core.itil.im.domain.Incident;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Component
public class AddIncidentValidator implements Validator {
	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#support(Class clazz)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Incident.class);
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#validate(Object target, Errors errors)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void validate(Object target, Errors errors) {
		Incident incident = (Incident)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
		
		if(incident.getSource() != null) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "employee.required");
		}
	}
}