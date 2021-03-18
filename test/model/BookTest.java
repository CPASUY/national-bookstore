package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {
	private Book<String,Integer> book;
	private String key;
	private Integer value;
	private String title;
	private String chapter;
	private String review;
	private String critique;
	private int cost;
	private int quantity;
	
	public void setupStage1(){
		key="4353";
		value=1;
		title="1 miles";
		chapter="Inside";
		review="Good";
		critique="5 stars";
		cost=40000;
		quantity=3;
		book=new Book<String,Integer>(key,value, chapter,review,critique,title,cost,quantity);
	}
	@Test
	void testBook() {
		setupStage1();
		
		assertEquals(key,book.getKey(),"The key is wrong");
		assertEquals(value,book.getValue(),"The value is wrong");
		assertEquals(title,book.getTitle(),"The title is wrong");
		assertEquals(chapter,book.getChapter(),"The chapter is wrong");
		assertEquals(review,book.getReview(),"The review is wrong");
		assertEquals(critique,book.getCritique(),"The critique is wrong");
		assertEquals(cost,book.getCost(),"The cost is wrong");
		assertEquals(quantity,book.getQuantity(),"The quantity is wrong");
	}

}
