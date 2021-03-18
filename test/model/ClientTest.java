package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exceptions.NoIdentificationException;

class ClientTest {
	private Client client;
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

}
