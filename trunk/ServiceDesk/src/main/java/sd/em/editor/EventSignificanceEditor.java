package sd.em.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sd.dictionary.DictionaryPropertyEditor;
import sd.em.dao.EventSignificanceDao;
import sd.em.domain.EventSignificance;

@Component
public class EventSignificanceEditor extends DictionaryPropertyEditor<EventSignificance>{

	@Autowired
	public EventSignificanceEditor(EventSignificanceDao dictionaryPropertyDao) {
		super(dictionaryPropertyDao);
	}
	
}
