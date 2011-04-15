/**
 * 
 */
package servicedesk.pm.validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import servicedesk.pm.domain.Problem;
import servicedesk.pm.domain.ProblemStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Component
public class EditProblemValidator implements Validator {
	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#support(Class clazz)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Problem.class);
	}

	/** 
	 * /* (non-Javadoc)
	 *  * @see Validator#validate(Object target, Errors errors)
	 * 
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public void validate(Object target, Errors errors) {
		Problem problem = (Problem)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
		
		if(problem.getStatus().equals(ProblemStatus.CLOSED)) {
			if(problem.getImpact() == null) {
				errors.rejectValue("impact", "impact.required");
			}
			if(problem.getUrgency() == null) {
				errors.rejectValue("urgency", "urgency.required");
			}
			if(problem.getPriority() == null) {
				errors.rejectValue("priority", "priority.required");
			}
			if(problem.getCategory() == null) {
				errors.rejectValue("category", "category.required");
			}
		}
		
		if(problem.isKnownError()) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "symptomsDetails", "symptomsDetails.required");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rootCause", "rootCause.required");
			if(problem.getWorkaround() == null) {
				errors.rejectValue("workaround", "workaround.required");
			}
		}
	}
}