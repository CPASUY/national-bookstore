package model;

public class Stack<K extends Comparable<K>,V> implements StackInterface<Book<String,Integer>> {
	
	private Book<String,Integer> top;

	
	public Stack() {
		
	}
	
	@Override
	public Book<String,Integer> pop() {
		Book<String,Integer> n = top;
		top = top.getPrevBook();
		return n;
	}

	@Override
	public void push(Book<String,Integer> s) {
		top.setNextBook(s);
		s.setPrevBook(top);
		top = s;
	}

	@Override
	public Book<String,Integer> top() {
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
