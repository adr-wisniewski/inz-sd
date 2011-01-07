package sd.signal.dao;

import java.util.List;

import sd.signal.domain.SignalGenerator;

public interface SignalGeneratorDao {
	public List<SignalGenerator> getAll();

	public SignalGenerator get(Integer generatorId);

	public void save(SignalGenerator generator);
}
