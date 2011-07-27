/**
 * 
 */
package servicedesk.core.itil.im.editor;

import servicedesk.infrastructure.interfaces.dao.DictionaryDao;
import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.itil.im.domain.IncidentPriority;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class IncidentPriorityEditor extends DictionaryPropertyEditor<IncidentPriority> {

	public IncidentPriorityEditor(DictionaryDao<IncidentPriority, String> dictionaryPropertyDao) {
		super(dictionaryPropertyDao);
	}
}