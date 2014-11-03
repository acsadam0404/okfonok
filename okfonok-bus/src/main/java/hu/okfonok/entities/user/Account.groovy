package hu.okfonok.entities.user

import java.nio.MappedByteBuffer;

import groovy.transform.EqualsAndHashCode
import hu.okfonok.entities.BaseEntity;

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.OneToMany
import javax.persistence.OneToOne;
import javax.persistence.Table

@Entity
@Table(name = "account")
@EqualsAndHashCode
class Account extends BaseEntity{
	@OneToMany(orphanRemoval=true ,cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "account_transactions", joinColumns = [ @JoinColumn(name = "account_id", referencedColumnName="id") ], inverseJoinColumns = [ @JoinColumn(name = "transaction_id", referencedColumnName="id") ])
	Set<Transaction> transactions = [] as Set
	
	@OneToOne(mappedBy = 'account')
	User user
	
	int getCurrentBalance() {
		int sum = transactions.sum(0, { t ->
			t.net
		})
		return sum
	}
	
	int getSumServicePrice() {
		int sum = transactions.sum(0, { t ->
			t.servicePrice
		})
		return sum
	}
}
