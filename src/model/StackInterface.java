package model;

public interface StackInterface<T> {
	
	public T pop();
	
	public void push(T s);
	
	public T top();
	
	public boolean empty();
	
	public Book[] stackToArray();
	
}