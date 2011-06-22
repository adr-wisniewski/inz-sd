package dictionary;
import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.Map;


public class DictionaryPropertyEditor<P extends DictionaryProperty> extends PropertyEditorSupport {
	/**
	 * Wszystkie mozliwe wartosci wlasciwosci
	 */
	private Map<String, P> values;
	/**
	 * Obiekt zwracajacy liste wszystkich mozliwych wartosci
	 */
	private DictionaryPropertyDao<P> dictionaryPropertyDao;

	public DictionaryPropertyEditor(DictionaryPropertyDao<P> dictionaryPropertyDao) {
		this.dictionaryPropertyDao = dictionaryPropertyDao;
		
		this.values = new HashMap<String, P>();
	}

	/**
	 * @param text kod reprezentujacy konkretna wartosc wlasciwosci
	 * @return obiekt wlasciwosci o podanym kodzie
	 */
	public void setAsText(String text) {
		if(!this.values.containsKey(text)) {
			//refresh values:
			for(P p : dictionaryPropertyDao.fetchAll()) {
				this.values.put(p.getCode(), p);
			}
		}

		setValue(this.values.get(text));
	}
}
