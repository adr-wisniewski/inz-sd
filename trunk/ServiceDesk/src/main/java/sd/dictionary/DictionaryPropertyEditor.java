/**
 * 
 */
package sd.dictionary;

import java.beans.PropertyEditorSupport;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/** 
 * <!-- begin-UML-doc -->
 * Edytor atrybutu slownikowego. Wykoszystuje DictionaryPropertyDao do pobrania wszystkich mozliwych wartosci slownika. Na
 * podstawie kodu pobranego przy pomocy metody getCode() zwraca konkretny obiekt slownika.
 * <!-- end-UML-doc -->
 * @author User
 * @generated "UML to Java (com.ibm.xtools.transform.uml2.java5.internal.UML2JavaTransform)"
 */
public class DictionaryPropertyEditor<P extends DictionaryProperty> extends PropertyEditorSupport {
	Logger logger = Logger.getLogger(DictionaryPropertyEditor.class);
	
	/**
	 * Wszystkie mozliwe wartosci wlasciwosci
	 */
	private Map<String, P> values = new HashMap<String, P>();
	/**
	 * Obiekt zwracajacy liste wszystkich mozliwych wartosci
	 */
	private DictionaryPropertyDao<P> dictionaryPropertyDao;

	public DictionaryPropertyEditor(DictionaryPropertyDao<P> dictionaryPropertyDao) {
		this.dictionaryPropertyDao = dictionaryPropertyDao;
	}
	/*
	public DictionaryPropertyEditor() {
		//nothing
	}
	*/
	public void setDictionaryPropertyDao(DictionaryPropertyDao<P> dictionaryPropertyDao) {
		this.dictionaryPropertyDao = dictionaryPropertyDao;
	}

	/**
	 * @param text kod reprezentujacy konkretna wartosc wlasciwosci
	 * @return obiekt wlasciwosci o podanym kodzie
	 */
	public void setAsText(String text) {
		String textTrim = text.trim();
		
		if(!this.values.containsKey(textTrim)) {
			//refresh values:
			for(P p : dictionaryPropertyDao.fetchAll()) {
				this.values.put(p.getCode().trim(), p);
			}
		}
		
		setValue(this.values.get(textTrim));
	}
}