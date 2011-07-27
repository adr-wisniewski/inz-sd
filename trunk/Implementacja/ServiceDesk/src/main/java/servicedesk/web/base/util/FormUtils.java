/**
 * 
 */
package servicedesk.web.base.util;

import org.springframework.ui.ModelMap;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class FormUtils {
	public static final String SUCCESS_MESSAGE = "succesmessage";

	/** 
	 * <!-- begin-UML-doc -->
	 * <!-- end-UML-doc -->
	 * @param message
	 * @param map
	 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
	 */
	public static void setSuccessMessage(String message, ModelMap map) {
		map.addAttribute(SUCCESS_MESSAGE, message);
	}
}