package hu.jobly.entities;

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass
 
/** 
 * 
 * @author Ács Ádám
 *
 */
@MappedSuperclass
abstract class BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true)
	protected long id
	
	public long getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj && obj instanceof BaseEntity && obj.getClass() == getClass() && obj.id == id) {
			return true
		}
		return false
	}
}
