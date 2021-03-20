package model;

public class Queue implements QueueInterface<Client> {
	private Client front;
	private Client last;
	
	public Queue() {
		
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
			c.setPrevClient(last);
			last = c;
		}
	}

	@Override
	public Client dequeue() {
		Client eliminated = front;
		if(front.getNextClient()!=null) {
			front = front.getNextClient();
		}
		else {
			front=null;
			last=null;
		}
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
