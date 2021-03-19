package model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest {
	private int s;
	private String key1,key2;
	private Integer value1,value2;
	private String title1,title2;
	private String chapter1,chapter2;
	private String review1,review2;
	private String critique1,critique2;
	private int cost1,cost2;
	private int quantity1,quantity2;
	private Book b1;
	private Book b2;
	private Stack stack;
	
	public void setupStage1(){
		s=2;
		key1="4353";
		value1=1;
		title1="1 miles";
		chapter1="Inside";
		review1="Good";
		critique1="5 stars";
		cost1=40000;
		quantity1=3;
		key2="5643";
		value2=3;
		title2="Levitating";
		chapter2="Oscar";
		review2="So so";
		critique2="3 stars";
		cost2=26000;
		quantity2=2;
		b1=new Book(key1,value1,chapter1,review1,critique1,title1,cost1,quantity1);
		b2=new Book(key2,value2,chapter2,review2,critique2,title2,cost2,quantity2);
		stack=new Stack<String, Integer>();
	}
	@Test
	void testPush() {
		setupStage1();
		
		stack.push(b1);
		stack.push(b2);
		
		assertEquals(b2,stack.top(),"The top is wrong");
		assertEquals(b1,stack.top().getPrevBook(),"The conexions are wrong");
	}
	@Test
	void testPop() {
		setupStage1();
		
		stack.push(b1);
		stack.push(b2);
		stack.pop();
		
		assertEquals(b1,stack.top(),"The top is wrong");
		assertEquals(null,stack.top().getNextBook(),"The conexions are wrong");
	}
	@Test
	void testTop() {
		setupStage1();
		
		stack.push(b1);
		stack.push(b2);
		
		assertEquals(b2,stack.top(),"The top is wrong");
	}
}
