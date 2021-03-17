package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {
	private Client client;
	private String id;
	public void setupStage1() {
		id="1193033579";
		client = new Client (id);
	}
	@Test
	void testClient() {
		setupStage1();
		
		assertNotNull(client.getIdentification());
		assertEquals(client.getIdentification(),"1193033579","The identification of the client is wrong");
	}

}
