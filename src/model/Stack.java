package model;

public class Stack implements StackInterface<Book> {
	
	private Book top;
	private int size;
	
	public Stack() {
		top = null;
		size =0;
	}
	
	@Override
	public Book pop() {
		Book n = top;
		top.getPrevBook().setNextBook(null);
		top = top.getPrevBook();
		size--;
		return n;
	}
	
	public Book[] stackToArray() {
		Book[] books = new Book[size];
		int i = 0;
		while(getSize() != 0) {
			books[i] = pop();
			i++;
		}
		return books;
	}

	@Override
	public void push(Book newBook) {

		if (top == null) {
			top = newBook;
			size++;
		}
		else{
			top.setNextBook(newBook);
			newBook.setPrevBook(top);
			top = newBook;
			size++;
		}
	}

	@Override
	public Book top() {
		return top;
	}

	@Override
	public boolean empty() {
		if(top != null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public int getSize() {
		return size;
	}
}
