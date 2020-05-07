package ds.students;

import ds.interfaces.Stack;

/**
 * @author simont
 *
 */
public class DSStack extends Stack {
	
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
	
	// DSStack constructor that accepts 
	// no parameter.
	public DSStack() {
		
		// point the class Stack variable mylist
		// to a new DS list object.
		this.list = new DSList();
		
	}
	
	// to create a deep copy of the pass-in stack
	// we use the DSlist deep copy method to get
	// list resides within the DSstack.
	public DSStack(DSStack other) {
		
		// call the deep copy method of the DSlist.
		this.list = new DSList(other.list);
		
	}
	
	// adding the pass-in object at the 
	// end of the stack, and return the object
	// parameters.
	public Token push(Token obj) {
		
		// we can achieve this by calling 
		// DSlist add function.
		this.list.add(obj);
	
		return obj;
	}
	
	// return the object at the top of the stack.
	// In other words, returns the tail node from the 
	// doubly link list.
	public Token peek() {
		
		// calling the doubly link list get(size() - 1)
		// getting the last element in the doubly link list.
		return this.list.get(this.size() - 1);
	}
	
	// Returns and removes the object at the top of the Stack.
	// In other words, remove the tail node of the doubly link 
	// list.
	public Token pop() {
		
		return this.list.remove(this.list.size() - 1);
	}
	
	// to check whether the stack contains
	// no node or some nodes by calling the
	// DSlist isEmpty() method.
	public boolean isEmpty() {
		
		return this.list.isEmpty();
	}
	
	// return the size of the stack by calling the 
	// doubly link list .size() function.
	public int size() {
		
		return this.list.size();
	}
	
	@Override
	public String toString() {
		return null;
	}
	
}
