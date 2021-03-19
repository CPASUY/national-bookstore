package model;

public class Stack implements StackInterface<Book> {
	
	private Book top;
	private int size;
	
	public Stack() {
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

	@Override
	public void push(Book s) {

		if(top == null) {
			top = s;
			size++;
		}
		else {
			s.setPrevBook(top);
			top.setNextBook(s);
			top = s;
			size++;

		if(top==null) {
			top=s;
		}
		else {
			top.setNextBook(s);
			s.setPrevBook(top);
			top = s;
		}
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
