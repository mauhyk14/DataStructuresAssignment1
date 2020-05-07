package ds.students;

import ds.interfaces.Queue;

/**
 * @author simont
 *
 */
public class DSQueue extends Queue {
	
	public DSQueue(Queue s) {
		
		this.list = new DSList(s.list);
		
	}

	public DSQueue() {
		
		this.list = new DSList();
	}

	@Override
	// Insert a new Node in Queue means adding a new Node to the
	// end. We can achieve this by calling the doubly link list
	// add(Token) method.
	public boolean offer(Token t) {
		
		return this.list.add(t);
	}

	@Override
	public Token poll() {
		return this.list.remove(0);
	}

	@Override
	// Retrieves, but does not remove, the head of this Queue.
	// In other words, retrieve the head token.
	public Token peek() {
		
		return this.list.head.getToken();
	}

	@Override
	public String toString() {
		return null;
	}

	@Override
	// to get the size of a queue by
	// calling the DSlist size method.
	public int size() {
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

}
