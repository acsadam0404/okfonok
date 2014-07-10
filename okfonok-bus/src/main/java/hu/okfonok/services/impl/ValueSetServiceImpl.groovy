package hu.okfonok.services.impl

import hu.okfonok.dao.ValueSetDao
import hu.okfonok.entities.ValueSet
import hu.okfonok.entities.ValueSetEntry
import hu.okfonok.services.ValueSetService

import org.apache.log4j.Logger
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * TODO közös kód
 * @author Ács Ádám
 *
 */
@Service("valueSetService")
@Transactional
class ValueSetServiceImpl extends BaseServiceImpl<ValueSet> implements ValueSetService {
	private static final Logger logger = Logger.getLogger(ValueSetServiceImpl.class);
	
	@Autowired
	private transient ValueSetDao repo;

	@Autowired
	ValueSetServiceImpl(ValueSetDao crudRepo) {
		super(crudRepo);
	}
	
	
	@Override
	public List<ValueSetEntry> findByName(String name) {
		try {
			ValueSet vs = repo.findByName(name).get(0);
			return vs.getEntries();
		} catch (IndexOutOfBoundsException ioobex) {
			logger.error("Nem található valueset: " + name, ioobex);
			throw new RuntimeException(ioobex);
		}
	}

	@Override
	public Set<ValueSetEntry> findByNameUnique(String name) {
		try {
			ValueSet vs = repo.findByName(name).get(0);
			return new HashSet<>(vs.getEntries());
		} catch (IndexOutOfBoundsException ioobex) {
			logger.error("Nem található valueset: " + name, ioobex);
			throw new RuntimeException(ioobex);
		}
	}
}
