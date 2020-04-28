package ds.students;

import ds.interfaces.List;

/**
 * @author simont
 *
 */
public class DSList implements List {

	public Node head;
	private Node tail;

	/* a blank constructor takes no parameters */
	public DSList() {

		this.head = null;
		this.tail = null;
	}

	/* accepting a node and set the head to this given node */
	public DSList(Node head_) {

		this.head = head_;
	}

	public DSList(DSList other) { // Copy constructor.

						 										
		  Node temp = other.head;
		  
		  
		  while(temp != null) {
		  
		   
		  // the add method will create the new Node object
		 //  for the copy doubly-link list. 	  
		  this.add(temp.getToken());
		  		  
		  temp = temp.next;
		  		  
		  }
		 		
	}

	/* remove a token object from a pass in index */
	public Token remove(int index) {

		// condition 1: remove the Node at the beginning
		// of the doubly link list.
		if (index == 0) {

			Token returnToken = this.head.getToken();

			this.head = this.head.next;

			return returnToken;
		}

		// condition 2: remove the Node at the end of the doubly
		// link list.
		else if (index == this.size() - 1)

		{
			Token endReturntoken = this.tail.getToken();

			this.tail.prev.next = null;

			// update the this tail variable.
			this.tail = this.tail.prev;

			return endReturntoken;

		}

		// condition 3: remove the Node in the middle of
		// the doubly link list.
		Node temp = this.getNode(index);

		Node preTemp = temp.prev;

		Node postTemp = temp.next;

		preTemp.next = postTemp;

		postTemp.prev = preTemp;

		return temp.getToken();

	}

	/* get the index position of the the pass-in Token object */
	public int indexOf(Token obj) {

		// Initialize the position counter as 0
		int counter = 0;

		// point the temp as the current head
		Node temp = this.head;

		// loop through the doubly link list and
		// compare the token.
		for (int i = 0; i < this.size(); i++) {

			if (temp.getToken().equals(obj)) {

				return counter;
			}

			// update the temp variable, point to
			// the next object.
			temp = temp.next;

			// increase the counter number
			counter++;
		}

		// if no equal token found, returns the -1.
		return -1;
	}

	// get the Node object of the pass-in index
	public Node getNode(int index) {

		// if the index bigger than the size of the
		// doubly-link list or the index is < 0,
		// it returns null.
		if (index > this.size() || index < 0) {

			return null;
		}

		// else makes the temp as the head
		// loop through the Node.
		// find the Token object and
		// return that token object.
		Node temp = this.head;

		for (int i = 0; i < index; i++) {

			temp = temp.next;

		}

		return temp;
	}

	// call the Node getNode method (above),
	// then get the token.
	public Token get(int index) {

		Node returnNode = this.getNode(index);

		// if the getNode() method returns null,
		// return a null result.
		if (returnNode == null) {

			return null;
		}

		// else returns the token of that position.
		return returnNode.getToken();
	}

	// check the size of the doubly link-list.
	// if the size() returns 0, we know the list is
	// empty.
	public boolean isEmpty() {

		if (this.size() == 0) {

			return true;

		}

		return false;

	}

	// count the number of Node in the list.
	public int size() {

		// point the tempt to the current head
		Node temp = this.head;

		// Initialize the counter
		int counter = 0;

		while (temp != null) {

			counter++;

			temp = temp.next;
		}

		return counter;
	}

	@Override
	public String toString() {

		// point the temp to the head Node
		Node temp = this.head;

		// declare an empty string
		String resultString = "";

		while (temp != null) {

			resultString = resultString + temp.getToken() + " ";

			temp = temp.next;

		}

		// trim and return the result.
		return resultString.trim();

	}

	// add a token to the end of the doubly-link list.
	public boolean add(Token obj) {

		if (obj == null) {

			return false;
		}

		// create the node object
		Node newTailingnode = new Node(null, null, obj);

		// Condition 1: this is the first node adding to the list.
		// if the head is null, it means this is the first node,
		// the doubly link list points the head and tail to this
		// node.
		if (this.head == null) {

			this.head = newTailingnode;
			this.tail = newTailingnode;

			return true;
		}

		// Condition 2: Adding a Node to the end of the
		// pre-existing doubly link-list.

		this.tail.next = newTailingnode;

		newTailingnode.prev = this.tail;

		this.tail = newTailingnode;

		return true;
	}

	// add a token object to a specific position of the
	// doubly-link list.
	public boolean add(int index, Token obj) {

		// condition 1: if the index exceeds the size of the
		// doubly-link list or the index is less than 0,
		// it returns false.
		if (index > this.size() || index < 0 || obj == null) {

			return false;
		}

		// create a Node object.
		Node newNode = new Node(null, null, obj);

		if (this.size() == 0) {

			this.head = newNode;
			this.tail = newNode;

		}
		

		// condition 2: the new Node to be inserted is the
		// first node of the doubly-link list.
		if (index == 0) {

			newNode.next = this.head;

			this.head.prev = newNode;

			this.head = newNode;

			return true;

		}
		

		// condition 3: add to the end of the list
		else if (index == this.size()) {
			
			return this.add(obj);

		}
		

		// condition 4: the new Node to be inserted is at
		// middle of the doubly-link list.

		// get the node position where you want to insert into it.
		Node temp = this.getNode(index);

		// create 2 variables pointing to the previous and next nodes.
		Node tempPrevious = temp.prev;

		// update the pointer of these 3 Nodes.
		tempPrevious.next = newNode;

		newNode.prev = tempPrevious;

		newNode.next = temp;
		
		temp.prev = newNode;

		return true;
	}

	// test whether a given object is contained in the list.
	public boolean contains(Token obj) {

		// point the temp as the first Node in the list.
		Node temp = this.head;

		// loop through the Nodes
		while (temp != null) {

			// if it finds an equal object, returns true.
			// True-this token object exist.
			if (temp.getToken().equals(obj)) {

				return true;
			}

			// update the temp pointer
			temp = temp.next;
		}

		// if no object to be found, returns false.
		return false;
	}

	public boolean remove(Token obj) {

		boolean containResutl = this.contains(obj);

		if (containResutl == false) {

			return containResutl;
		}

		// find the position of the token object in the list
		int indexPosition = this.indexOf(obj);
		
		// remove from the list and return true.
		this.remove(indexPosition);

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
