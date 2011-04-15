package servicedesk.em.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import servicedesk.dictionary.DictionaryPropertyEditor;
import servicedesk.em.dao.EventSignificanceDao;
import servicedesk.em.domain.EventSignificance;

@Component
public class EventSignificanceEditor extends DictionaryPropertyEditor<EventSignificance>{

	@Autowired
	public EventSignificanceEditor(EventSignificanceDao dictionaryPropertyDao) {
		super(dictionaryPropertyDao);
	}
	
}
