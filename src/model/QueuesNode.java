package model;

public class QueuesNode <T> {
	private T type;

	private QueuesNode<T> next;
	
	public QueuesNode () {
	}

	public QueuesNode<T> getNext() {
		return next;
	}

	public void setNext(QueuesNode<T> next) {
		this.next = next;
	}
	public T getType() {
		return type;
	}
}
