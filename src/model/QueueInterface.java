package model;

public interface QueueInterface <T> {
	
	public void enqueue(T c);
	public T dequeue();
	public T front();
	public boolean empty();
}
