/**
 * 
 */
package sd.em.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sd.dictionary.DictionaryPropertyEditor;
import sd.em.dao.EventCategoryDao;
import sd.em.domain.EventCategory;


/** 
 * <!-- begin-UML-doc -->
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
@Component
public class EventCategoryEditor extends DictionaryPropertyEditor<EventCategory> {

	@Autowired
	public EventCategoryEditor(EventCategoryDao categoryDao) {
		super(categoryDao);
	}

}