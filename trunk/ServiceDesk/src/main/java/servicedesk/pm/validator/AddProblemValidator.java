/**
 * 
 */
package servicedesk.pm.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import servicedesk.pm.domain.Problem;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Component
public class AddProblemValidator implements Validator {
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
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "subject.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.required");
	}
}