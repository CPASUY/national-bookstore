package model;

public class Queue implements QueueInterface<Client> {
	private Client front;
	private Client last;
	
	public void setFront(Client front) {
		this.front = front;
	}
	public Client getLast() {
		return last;
	}
	public void setLast(Client last) {
		this.last = last;
	}
	@Override
	public void enqueue(Client c) {
		if(front == null) {
			front = c;
			last =c;
		}
		else {
			last.setNextClient(c);
			last = c;
		}
	}

	@Override
	public Client dequeue() {
		Client eliminated = front;
		front = front.getNextClient();
		return eliminated;
	}

	@Override
	public Client front() {
		
		return front;
	}

	@Override
	public boolean empty() {
		if(front==null) {
			return true;
		}
		else {
			return false;
		}
	}

}
