package model;

public class Book<K extends Comparable<K>, V> {

	private K key;
	private V value;
	private Book<K,V> nextBook;
	private Book<K,V> prevBook;

	
	public Book(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	public Book<K,V> getNextBook() {
		return nextBook;
	}
	public void setNextBook(Book<K,V> nextBook) {
		this.nextBook = nextBook;
	}
	public Book<K,V> getPrevBook() {
		return prevBook;
	}
	public void setPrevBook(Book<K,V> prevBook) {
		this.prevBook = prevBook;
	}
}
