package hu.okfonok.services.data.impl

import java.util.List;

import hu.okfonok.services.data.DataService

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 *
 * @author Ács Ádám
 *
 * @param <T>
 */
@Transactional(propagation = Propagation.REQUIRED)
abstract class DataServiceImpl<T>  implements DataService<T>  {
	@PersistenceContext
	protected final EntityManager em;
}
