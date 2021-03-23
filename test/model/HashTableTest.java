package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HashTableTest {
	int s;
	private HashTable h1 ;
	private Book[] b1;
	private Book book;
	private boolean r;
	private String key1,key2,key3,key4;
	private Integer value1,value2,value3,value4;
	private String title1,title2,title3,title4;
	private String chapter1,chapter2,chapter3,chapter4;
	private String review1,review2,review3,review4;
	private String critique1,critique2,critique3,critique4;
	private int cost1,cost2,cost3,cost4;
	private int quantity1,quantity2,quantity3,quantity4;
	
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


		h1=new HashTable();
		b1=h1.getBooks();
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
		h1=new HashTable();
		b1=h1.getBooks();

	}
	@Test
	void testHashTable() {
		setupStage1();
		
		
		assertNull(b1[0]);
		assertNull(b1[1]);
	}
	@Test
	void testPut() {
		setupStage1();
		
		h1.put(key1, value1, chapter1, review1, critique1, title1, cost1, quantity1);
		h1.put(key2, value2, chapter2, review2, critique2, title2, cost2, quantity2);
		
		assertEquals(key1,h1.getBooks()[8].getKey(),"The array is wrong");
		assertEquals(key2,h1.getBooks()[0].getNextBook().getKey(),"The array is wrong");
		assertEquals(key1,h1.getBooks()[8].getNextBook().getPrevBook().getKey(),"The array is wrong");
	}
	@Test
	void testSearch() {
		setupStage1();
		
		h1.put(key1, value1, chapter1, review1, critique1, title1, cost1, quantity1);
		h1.put(key2, value2, chapter2, review2, critique2, title2, cost2, quantity2);
		book=h1.search("5643");
	
		assertEquals(key2,book.getKey(),"The book searched is wrong");
		
		book=h1.search("4353");
		
		assertEquals(key1,book.getKey(),"The book searched is wrong");
	}
	@Test
	void testRemove1() {
		setupStage2();
		
		h1.put(key1, value1, chapter1, review1, critique1, title1, cost1, quantity1);
		r=h1.remove("4353");
		
		assertTrue(r);
		assertEquals("4353",h1.getBooks()[8].getKey(),"The book elimianated is wrong");
	}
	@Test
	void testRemove2() {
		setupStage2();
		
		h1.put(key1, value1, chapter1, review1, critique1, title1, cost1, quantity1);
		h1.put(key2, value2, chapter2, review2, critique2, title2, cost2, quantity2);
		r=h1.remove("4353");
		
		assertTrue(r);
		assertEquals(key1,h1.getBooks()[8].getKey(),"The book elimianated is wrong");
	}
	@Test
	void testRemove3() {
		setupStage2();
		
		h1.put(key1, value1, chapter1, review1, critique1, title1, cost1, quantity1);
		h1.put(key2, value2, chapter2, review2, critique2, title2, cost2, quantity2);
		r=h1.remove("4353");
		
		assertTrue(r);
		assertEquals(key1,h1.getBooks()[8].getNextBook().getKey(),"The book elimianated is wrong");
	}
	@Test
	void testRemove4() {
		setupStage2();
		
		h1.put(key1, value1, chapter1, review1, critique1, title1, cost1, quantity1);
		h1.put(key2, value2, chapter2, review2, critique2, title2, cost2, quantity2);
		h1.put(key3, value3, chapter3, review3, critique3, title3, cost3, quantity3);
		h1.put(key4, value4, chapter4, review4, critique4, title4, cost4, quantity4);
		r=h1.remove("5645");
		
		assertTrue(r);
		assertEquals(key3,h1.getBooks()[0].getNextBook().getKey(),"The book elimianated is wrong");
	}
	@Test
	void testBooksList() {
		setupStage1();
		h1.put(key1, value1, chapter1, review1, critique1, title1, cost1, quantity1);
		h1.put(key2, value2, chapter2, review2, critique2, title2, cost2, quantity2);
		h1.booksList();
		
		assertEquals(h1.getList().get(0),h1.getBooks()[0],"The book elimianated is wrong");
	}

	void testHashFuntion() {
		setupStage1();
		int m=Integer.parseInt(key1);
		h1.hashFuntion(m);
		assertEquals(8,m,"The hash funtion is wrong");
	}
}
