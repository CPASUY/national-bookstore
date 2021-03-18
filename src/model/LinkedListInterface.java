package model;

public interface LinkedListInterface<T,B,C> {
	
	public boolean add(T isbn,C value,String chapter,String review,String critique,String title,int cost,int quantity);
	public boolean remove(T isbn);
	public B search(T isbn); 
	
}
