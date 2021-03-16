package model;

public class Book<K extends Comparable<K>, V> {

	private K key;
	private V value;
	private String title;
	private String chapter;
	private String review;
	private int cost;
	private int quantity;
	private String critique;
	private Book<K,V> nextBook;
	private Book<K,V> prevBook;
	
	public Book(K key, V value,String chapter,String review,String critique,String title,int cost,int quantity) {
		this.key = key;
		this.value = value;
		this.title=title;
		this.chapter=chapter;
		this.review=review;
		this.critique=critique;
		this.cost=cost;
		this.quantity=quantity;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getCritique() {
		return critique;
	}
	public void setCritique(String critique) {
		this.critique = critique;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public void setValue(V value) {
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
