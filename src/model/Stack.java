package model;

public class Stack<K extends Comparable<K>,V> implements StackInterface<Book<K,V>> {
	
	private Book<K,V> top;

	
	public Stack() {
		
	}
	
	@Override
	public Book<K,V> pop() {
		Book<K,V> n = top;
		top = top.getPrevBook();
		return n;
	}

	@Override
	public void push(Book<K,V> s) {
		top.setNextBook(s);
		s.setPrevBook(top);
		top = s;
	}

	@Override
	public Book<K,V> top() {
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
