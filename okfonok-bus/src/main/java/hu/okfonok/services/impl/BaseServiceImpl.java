package hu.okfonok.services.impl;

import hu.okfonok.services.BaseService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * TODO közös projekt
 * @author Ács Ádám
 *
 * @param <T>
 */
@Transactional(propagation = Propagation.REQUIRED)
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	private transient JpaRepository<T, Long> crudRepo;

	public BaseServiceImpl(JpaRepository<T, Long> crudRepo) {
		this.crudRepo = crudRepo;
	}
	
	@Override
	public void save(T t) {
		crudRepo.save(t);
	}
	
	@Override
	public void delete(T t) {
		crudRepo.delete(t);
	}
	
	@Override
	public List<T> findAll() {
		return crudRepo.findAll();
	}
	
	@Override
	public T find(long id) {
		return crudRepo.findOne(id);
	}

}
