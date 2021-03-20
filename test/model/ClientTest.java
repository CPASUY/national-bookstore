package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.NoIdentificationException;

class ClientTest {
	private Client client;
	private Client clone;
	private String id;
	public void setupStage1() {
		id="1193033579";
		try {
			client = new Client (id);
		} catch (NoIdentificationException e) {
			e.printStackTrace();
		}
	}
	@Test
	void testClient() {
		setupStage1();
		
		assertNotNull(client.getIdentification());
		assertEquals(client.getIdentification(),"1193033579","The identification of the client is wrong");
	}
	@Test
	void testClone() {
		setupStage1();
		
		clone= client.clone();
		assertNotNull(clone.getIdentification());
		assertEquals(client.getIdentification(),clone.getIdentification(),"The identification of the client is wrong");
	}
	@Test
	void testPriceBooks() {
		setupStage1();
		client.priceBooks();
		assertEquals(0,client.getPrice(),"The price of the client is wrong");
	}
	@Test
	void testlisOfISBN() {
		setupStage1();
		
		client.lisOfISBN();
		assertEquals(client.getBooks(),"","The list of isnb codes of the client is wrong");
	}

}
