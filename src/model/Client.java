package model;

import java.util.ArrayList;

import exceptions.NoIdentificationException;

public class Client implements Comparable<Client> {
	
	String identification;
	int quantityB;
	private Stack stackBooks;
	private Book[] buyBooks;
	private ArrayList<Book> searchBooks;
	private Client nextClient;
	private Client prevClient;
	private Integer time;
	private Integer price;
	private String books;
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getBooks() {
		return books;
	}

	public void setBooks(String books) {
		this.books = books;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Client getPrevClient() {
		return prevClient;
	}

	public void setPrevClient(Client prevClient) {
		this.prevClient = prevClient;
	}
	public int getQuantityB() {
		return quantityB;
	}
	public void setQuantityB(int quantityB) {
		this.quantityB = quantityB;
	}

	public Client (String identification) throws NoIdentificationException {
		if(identification.isEmpty() == false) {
			this.identification = identification;
			stackBooks = new Stack();
			searchBooks = new ArrayList<Book>();
<<<<<<< HEAD
			buyBooks = new Book[5];
			quantityB = 0;
=======
			buyBooks = new Book[0];
			quantityOfBooks = 0;
>>>>>>> 6993dcffb0641a033e4508bfadc47d6db9eae1b2
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
<<<<<<< HEAD
		
		buyBooks = new Book[stackBooks.getSize()];
		
		for(int i=0;i<buyBooks.length;i++) {
			buyBooks[i] = stackBooks.pop();
		}
		quantityB = buyBooks.length;
	}
	public void priceBooks() {
		int p=0;
		for(int s=0;s<searchBooks.size();s++) {
			p+=searchBooks.get(s).getCost();
		}
		price=p;
	}
	public void lisOfISBN() {
		String b="";
		for(Book myBooks:buyBooks) {
			b += myBooks.getKey()+"\n";
		}
		books=b;
=======
		buyBooks = stackBooks.stackToArray();
		quantityOfBooks = buyBooks.length;
>>>>>>> 6993dcffb0641a033e4508bfadc47d6db9eae1b2
	}
	public Book[] getBuyBooks() {
		return buyBooks;
	}

	@Override
	public int compareTo(Client c) {
		return time.compareTo(c.getTime());
	}
}
