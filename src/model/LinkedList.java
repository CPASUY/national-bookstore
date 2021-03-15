package model;

public class LinkedList<K extends Comparable<K>,V> implements LinkedListInterface<String,Book<K,V>> {

	@Override
	public boolean add(String isbn) {
		
		return false;
	}

	@Override
	public boolean remove(String isbn) {
		
		return false;
	}

	@Override
	public Book<K,V> search(String isbn) {
		
		return null;
	}

}
