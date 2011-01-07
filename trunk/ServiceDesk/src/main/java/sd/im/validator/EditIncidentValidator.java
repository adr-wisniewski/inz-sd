/**
 * 
 */
package sd.im.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import sd.im.domain.Incident;
import sd.im.domain.IncidentStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Component
public class EditIncidentValidator implements Validator {
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
		
		if(incident.getStatus().equals(IncidentStatus.RESOLVED)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resolution", "resolution.required");
		}
		else if(incident.getStatus().equals(IncidentStatus.CLOSED)) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "resolution", "resolution.required");
			if(incident.getImpact() == null) {
				errors.rejectValue("impact", "impact.required");
			}
			if(incident.getUrgency() == null) {
				errors.rejectValue("urgency", "urgency.required");
			}
			if(incident.getPriority() == null) {
				errors.rejectValue("priority", "priority.required");
			}
			if(incident.getCategory() == null) {
				errors.rejectValue("category", "category.required");
			}
		}
	}
}