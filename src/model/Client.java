package model;

import java.util.ArrayList;

import exceptions.NoIdentificationException;

public class Client {
	
	String identification;
	int quantityOfBooks;
	private Stack<String,Integer> buyBooks;
	private ArrayList<Book> searchBooks;
	private Client nextClient;
	private Client prevClient;
	
	
	public Client getPrevClient() {
		return prevClient;
	}

	public void setPrevClient(Client prevClient) {
		this.prevClient = prevClient;
	}

	public Client (String identification) throws NoIdentificationException {
		if(identification.isEmpty() == false) {
			this.identification = identification;
			buyBooks = new Stack<String,Integer>();
			searchBooks = new ArrayList<Book>();
			quantityOfBooks = 0;
		}
		else {
			throw new NoIdentificationException();
		}
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
	
	public ArrayList<Book> getSearchBooks(){
		return searchBooks;
	}
}
