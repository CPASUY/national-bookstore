package model;

public class LinkedList implements LinkedListInterface<String,Book<String,Integer>,Integer> {
	
	private Book<String,Integer> firstBook;
	
	public LinkedList() {
		
	}
	
	@Override
	public boolean add(String isbn, Integer value) {
		Book<String,Integer> n = new Book<String,Integer>(isbn,value);
		if(firstBook == null) {
			firstBook = n;
		}
		else {
			Book<String,Integer> temp = firstBook;
			while(temp.getNextBook() != null) {
				temp = temp.getNextBook();
			}
			temp.setNextBook(n);
			n.setPrevBook(temp);
		}
		return true;
	}

	@Override
	public boolean remove(String isbn) {
		Book<String,Integer> s = search(isbn);
		if(s == firstBook && firstBook !=null) {
			firstBook = s.getNextBook();
		}
		else if(s.getNextBook() !=null) {
			s.getPrevBook().setNextBook(s.getNextBook());
			s.getNextBook().setPrevBook(s.getPrevBook());
		}
		else {
			s.getPrevBook().setNextBook(null);
		}
		return true;
	}

	@Override
	public Book<String,Integer> search(String isbn) {
		Book<String,Integer> s = null;
		Book<String,Integer> temporal = firstBook;
		if(firstBook.getKey().equals(isbn)) {
			s = firstBook;;
		}
		else {
		while(temporal != null) {
			if(isbn.equals(temporal.getKey())) {
				s = temporal;
			}
			temporal = temporal.getNextBook();	
		}
		}
		return s;
	}
	
	public Book<String,Integer> getFirstBook(){
		return firstBook;
	}
}
