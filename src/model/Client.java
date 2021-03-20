package model;

import java.util.ArrayList;

import exceptions.NoIdentificationException;

public class Client {
	
	String identification;
	int quantityOfBooks;
	private Stack stackBooks;
	private Book[] buyBooks;
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
			stackBooks = new Stack();
			searchBooks = new ArrayList<Book>();
			buyBooks = new Book[0];
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
	
	public Stack getStackBooks() {
		return stackBooks;
	}
	
	public ArrayList<Book> getSearchBooks(){
		return searchBooks;
	}
	
	public void fillBuyBooks() {
		
		for(int i=0; i<searchBooks.size();i++) {
			stackBooks.push(searchBooks.get(i));
		}
		
		buyBooks = new Book[stackBooks.getSize()];
		quantityOfBooks = buyBooks.length;
		
		//for(int j=0;j<buyBooks.length;j++) {
		//	buyBooks[j] = stackBooks.pop();
		//}
		
		
	}
	
	public Book[] getBuyBooks() {
		return buyBooks;
	}
}
