package hu.okfonok.types

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable

import java.text.DateFormat

@Immutable
@EqualsAndHashCode
class DateInterval {
	
	static final String FORMAT = "yyyy.MM.dd.HH:mm:ss"
	
	Date start
	
	Date end
	
	/**
	 * yyyy.MM.dd.HH:mm:ss-yyyy.MM.dd.HH:mm:ss formátumban adja vissza. Visszalakítás a parse(string) metódussal
	 */
	@Override 
	String toString() {
		start.toString(FORMAT) + "-" + end.toString(FORMAT)	
	}
	
	/**
	 * "yyyy.MM.dd.HH:mm:ss-yyyy.MM.dd.HH:mm:ss" formátumú stringből csinál egy DateInterval-t.
	 * @param str
	 * @return
	 */
	static DateInterval parse(String str) {
		String[] parts = str.split("-")
		Date start = Date.parse(FORMAT, parts[0])
		Date end = Date.parse(FORMAT, parts[1])
		new DateInterval(start, end)
	}
}
