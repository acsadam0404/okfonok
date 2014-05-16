package hu.okfonok.entities

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotNull


@Entity
class ValueSet extends BaseEntity {
	@NotNull
	private String name;

	@NotNull
	private String valuesString;

	public List<String> getValues() {
		StringTokenizer st = new StringTokenizer(valuesString, "|");
		List<String> values = new ArrayList<>();
		while (st.hasMoreTokens()) {
			values.add(st.nextToken());
		}
		return values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValuesString() {
		return valuesString;
	}

	public void setValuesString(String valuesString) {
		this.valuesString = valuesString;
	}
}
