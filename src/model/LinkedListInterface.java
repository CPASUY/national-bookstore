package model;

public interface LinkedListInterface<T,B,C> {
	
	public boolean add(T isbn,C value);
	public boolean remove(T isbn);
	public B search(T isbn); 
	
}
