package servicedesk.core.base.em.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import servicedesk.infrastructure.editor.DictionaryPropertyEditor;
import servicedesk.core.base.em.dao.EventSignificanceDao;
import servicedesk.core.base.em.domain.EventSignificance;

@Component
public class EventSignificanceEditor extends DictionaryPropertyEditor<EventSignificance>{

	@Autowired
	public EventSignificanceEditor(EventSignificanceDao dictionaryPropertyDao) {
		super(dictionaryPropertyDao);
	}
	
}
