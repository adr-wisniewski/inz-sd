package dictionary;
import java.util.List;

public interface DictionaryPropertyDao<P extends DictionaryProperty> {
	public List<P> fetchAll();
}
