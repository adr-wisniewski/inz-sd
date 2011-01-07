package sd.signal.dao;

import java.util.List;

import sd.signal.domain.SignalGenerator;

public interface SignalGeneratorDao {
	public List<SignalGenerator> fetchAll();

	public SignalGenerator findById(Integer generatorId);

	public void save(SignalGenerator generator);
}
