package model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest {
	private int s;
	private String key1,key2,key3,key4;
	private Integer value1,value2,value3,value4;
	private String title1,title2,title3,title4;
	private String chapter1,chapter2,chapter3,chapter4;
	private String review1,review2,review3,review4;
	private String critique1,critique2,critique3,critique4;
	private int cost1,cost2,cost3,cost4;
	private int quantity1,quantity2,quantity3,quantity4;
	private Book b1;
	private Book b2;
	private Book b3;
	private Book b4;
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
		stack=new Stack();
	}
	public void setupStage2(){
		s=4;
		key1="4353";
		value1=1;
		title1="1 miles";
		chapter1="Inside";
		review1="Good";
		critique1="5 stars";
		cost1=40000;
		quantity1=3;
		key2="5645";
		value2=3;
		title2="Levitating";
		chapter2="Oscar";
		review2="So so";
		critique2="3 stars";
		cost2=26000;
		quantity2=2;
		key3="3465";
		value3=2;
		title3="Burning";
		chapter3="Sancho";
		review3="Good";
		critique3="4 stars";
		cost3=39000;
		quantity3=2;
		key4="4243";
		value4=1;
		title4="My journy";
		chapter4="Day 1";
		review4="Nice";
		critique4="4 stars";
		cost4=32400;
		quantity4=2;
		b1=new Book(key1,value1,chapter1,review1,critique1,title1,cost1,quantity1);
		b2=new Book(key2,value2,chapter2,review2,critique2,title2,cost2,quantity2);
		b3=new Book(key3,value3,chapter3,review3,critique3,title3,cost3,quantity3);
		b4=new Book(key4,value4,chapter4,review4,critique4,title4,cost4,quantity4);
		stack=new Stack();

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
		setupStage2();
		
		stack.push(b1);
		stack.push(b2);
		stack.push(b3);
		stack.push(b4);
		stack.pop();
		
		assertEquals(b3,stack.top(),"The top is wrong");
		assertEquals(null,stack.top().getNextBook(),"The conexions are wrong");
		Book v=stack.pop();
		assertEquals(b3,v,"The top is wrong");
		stack.pop();
		assertEquals(b1,stack.top(),"The top is wrong");
		stack.pop();
		assertEquals(null,stack.top(),"The top is wrong");
	}
	@Test
	void testTop() {
		setupStage1();
		
		stack.push(b1);
		stack.push(b2);
		
		assertEquals(b2,stack.top(),"The top is wrong");
	}
}
