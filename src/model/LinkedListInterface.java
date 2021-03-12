package model;

public interface LinkedListInterface<T,B> {
	
	public boolean add(T isbn);
	public boolean remove(T isbn);
	public B search(T isbn); 
	
}
