/**
 * 
 */
package servicedesk.core.itil.im.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.itil.im.dao.IncidentCategoryDao;
import servicedesk.core.itil.im.domain.IncidentCategory;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class IncidentCategoryEditor extends DictionaryPropertyEditor<IncidentCategory> {

	public IncidentCategoryEditor(IncidentCategoryDao incidentCategoryDao) {
		super(incidentCategoryDao);
	}

}