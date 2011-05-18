/**
 * 
 */
package servicedesk.core.itil.pm.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.itil.pm.dao.ProblemStatusDao;
import servicedesk.core.itil.pm.domain.ProblemStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ProblemStatusEditor extends DictionaryPropertyEditor<ProblemStatus> {

	public ProblemStatusEditor(ProblemStatusDao problemStatusDao) {
		super(problemStatusDao);
	}
	
}