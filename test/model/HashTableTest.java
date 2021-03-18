package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class HashTableTest {
	private ArrayList<Book> b;
	private int s;
	private HashTable h ;
	private Book book1;
	private Book book2;
	private String key1,key2;
	private Integer value1,value2;
	private String title1,title2;
	private String chapter1,chapter2;
	private String review1,review2;
	private String critique1,critique2;
	private int cost1,cost2;
	private int quantity1,quantity2;
	
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
		book1=new Book(key1,value1, chapter1,review1,critique1,title1,cost1,quantity1);
		key2="5643";
		value2=3;
		title2="Levitating";
		chapter2="Oscar";
		review2="So so";
		critique2="3 stars";
		cost2=26000;
		quantity2=2;
		book2=new Book(key2,value2, chapter2,review2,critique2,title2,cost2,quantity2);
		h=new HashTable(s);
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
