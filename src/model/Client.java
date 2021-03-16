package model;

public class Client {
	
	String identification;
	private Stack<String,Integer> buyBooks;
	private Client nextClient;
	
	public Client (String identification) {
		this.identification = identification;
		buyBooks = new Stack<String,Integer>();
	}

	public Client getNextClient() {
		return nextClient;
	}

	public void setNextClient(Client next) {
		nextClient = next;
	}
	
	public String getIdentification() {
		return identification;
	}
	
	public Stack<String,Integer> getBuyBooks() {
		return buyBooks;
	}
}
