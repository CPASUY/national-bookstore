package model;

public class Book{

	private String key;
	private Integer value;
	private String title;
	private String chapter;
	private String review;
	private int cost;
	private int quantity;
	private String critique;
	private Book nextBook;
	private Book prevBook;

	public Book(String key, Integer value,String chapter,String review,String critique,String title,int cost,int quantity) {
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
	public void setKey(String key) {
		this.key = key;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String  getKey() {
		return key;
	}
	public Integer getValue() {
		return value;
	}
	public Book getNextBook() {
		return nextBook;
	}
	public void setNextBook(Book nextBook) {
		this.nextBook = nextBook;
	}
	public Book getPrevBook() {
		return prevBook;
	}
	public void setPrevBook(Book prevBook) {
		this.prevBook = prevBook;
	}
}
