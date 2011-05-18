/**
 * 
 */
package servicedesk.core.itil.pm.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.itil.pm.dao.ProblemCategoryDao;
import servicedesk.core.itil.pm.domain.ProblemCategory;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class ProblemCategoryEditor extends DictionaryPropertyEditor<ProblemCategory> {

	public ProblemCategoryEditor(ProblemCategoryDao problemCategoryDao) {
		super(problemCategoryDao);
	}
}