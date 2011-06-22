/**
 * 
 */
package servicedesk.core.itil.im.editor;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.itil.im.dao.IncidentStatusDao;
import servicedesk.core.itil.im.domain.IncidentStatus;

/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class IncidentStatusEditor extends DictionaryPropertyEditor<IncidentStatus> {

	public IncidentStatusEditor(IncidentStatusDao incidentStatusDao) {
		super(incidentStatusDao);
	}
}