package hu.okfonok.entities.user;

import groovy.transform.EqualsAndHashCode;
import hu.okfonok.entities.BaseEntity;

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "Point")
@EqualsAndHashCode
class Point extends BaseEntity {
	Date datum

	int sum

	@Override
	String toString() {
		datum.format("yyyy.MM.dd") + " " + sum
	}
}
