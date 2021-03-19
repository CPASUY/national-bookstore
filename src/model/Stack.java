package model;

public class Stack<K extends Comparable<K>,V> implements StackInterface<Book> {
	
	private Book top;

	
	public Stack() {
		
	}
	
	@Override
	public Book pop() {
		Book n = top;
		top.getPrevBook().setNextBook(null);
		top = top.getPrevBook();
		return n;
	}

	@Override
	public void push(Book s) {
		if(top==null) {
			top=s;
		}
		else {
			top.setNextBook(s);
			s.setPrevBook(top);
			top = s;
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
}
