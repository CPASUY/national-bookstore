package model;

public class Queue implements QueueInterface<Client> {
	private QueuesNode<Client> front;
	private QueuesNode<Client> last;
	
	public void setFront(QueuesNode<Client> front) {
		this.front = front;
	}
	public QueuesNode<Client> getLast() {
		return last;
	}
	public void setLast(QueuesNode<Client> last) {
		this.last = last;
	}
	@Override
	public void enqueue(Client c) {
		QueuesNode<Client> newClient=new QueuesNode<Client>();
		if(front==null) {
			front=newClient;
			last=newClient;
		}
		else {
			newClient.setNext(last);
			last=newClient;
		}	
	}

	@Override
	public Client dequeue() {
		QueuesNode<Client> e=last;
		Client eliminated=e.getType();
		last=last.getNext();
		return eliminated;
	}

	@Override
	public Client front() {
		Client f=front.getType();
		return f;
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
