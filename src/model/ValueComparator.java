package model;

import java.util.Comparator;

public class ValueComparator implements Comparator<Book> {

	public ValueComparator() {
		
	}
	
	@Override
	public int compare(Book o1, Book o2) {
		return o1.getValue().compareTo(o2.getValue());
	}

}
