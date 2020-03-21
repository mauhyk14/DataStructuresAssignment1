package ds.students;

import ds.interfaces.List;


/**
 * @author simont
 *
 */
public class DSList implements List {
	
	public Node head;
	private Node tail;
			
	// when initializing an empty doubly link list,
	// both the head and tail nodes are empty.
	public DSList() 
	{		
		this.head = null;
		this.tail = null;		
	}
	
	// pointing the current head to the passed in 
	// Node, set the head to the given Node.
	// according to the instructions.
	public DSList(Node head_) 
	{		
		this.head = head_;
	}
	
	public DSList(DSList other) { // Copy constructor. 
		
	}

	public Token remove(int index) {
		
		return null;
	}
	
	public int indexOf(Token obj) {
		return 0;
	}

	public Node getNode(int index) 
	{		
		// when the index comes in, if it is less than 0 or
		// bigger than the size of the doubly linklist,
		// the function returns nothing.
		if(index > this.size() 
		   && index < 0) 
		{			
			return null;
		}
				
		// using temp to point to the double linklist
		// head (the head Node).
		Node temp = this.head;
		
		// start from the beginning of the doubly link list
		// (the head node), loop through the nodes until 
		// it reach the index position.
		for(int i = 0; i < index; i++) 
		{						
			temp = temp.next;						
		}
		
		return temp;								
	}
	
	
	public Token get(int index) 
	{
		// using the Node getNode method to get the node
		// in the doubly linklist. Then, access the token
		// property.
		Token returnToken = this.getNode(index).getToken();
		
		return returnToken;
	}

	public boolean isEmpty() {
		return true;
	}

	
	public int size() 
	{		
		int countSize = 0;
		
		// using a temp variable to point
		// to the doubly link list head.
		Node temp = this.head;
		
		// as long as the temp is not null,
		// we increase the count size and update
		// the temp.
		while(temp != null) 
		{			
			countSize++;
			
			temp = temp.next;
		}
						
		return countSize;
	}
	
	
	
	@Override
	public String toString() {
		Node temp = this.head;
		String result = "";
		while(temp != null) {
			
			result = result + temp.toString() + " ";
			temp = temp.next;
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

		
	public boolean add(Token obj) {
		
		// check the content the token. if it is null,
		// we return false.
		if(obj == null) {
			
			return false;
		}
		
		Node addTotheEndnode = new Node(null, null, obj);
		
		if(this.head == null) {
			
			this.head = addTotheEndnode;
			this.tail = addTotheEndnode;
			return true;
		}
			
		// create a node object
		
				
		// add a node to the end of tail;
		this.tail.next = addTotheEndnode;
		
		// make the new node's previous equals to the tail.
		addTotheEndnode.prev = this.tail;
				
		// update tail to the newly added tail node
		this.tail = addTotheEndnode;
		
		return true;
	}

	public boolean add(int index, Token obj) {
		
		// if the index outside the list bound and 
		// token is null, returns false.
		if(obj == null && 
		   index > this.size()) 
		{
			
			return false;
		}
		
		
		// create a new node object
		Node newNode = new Node (null, null, obj);
		
		
		// if index not equals to 0
		// this newly added node is place between 2 nodes.
		if(index != 0) {
		
			Node temp = this.getNode(index);
				
			temp.prev.next = newNode;
		
		
			newNode.prev = temp.prev;
		
				
			newNode.next = temp;
		
		
			temp.prev = newNode;
					
		}
		
		else {
			
											
			this.head.prev = newNode;
			
			
			newNode.next = this.head;
								
		}
		
				
		return true;
	}

	public boolean contains(Token obj) {
		return false;
	}

	public boolean remove(Token obj) {
		return true;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
}
