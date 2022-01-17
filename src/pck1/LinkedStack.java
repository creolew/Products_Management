package pck1;

import java.util.EmptyStackException;

public class LinkedStack {

	Node head;
	
	/**
	 * CONSTRUCTOR
	 */
	public LinkedStack() {
		head= null;
	}
	
	public boolean isEmpty() {
		return(head== null);
	}
	
	/**
	 * PUSH NODE INTO STACK
	 * @param x
	 */
	public void push(Product x) {
		Node newNode= new Node(x);
		
		newNode.setNext(this.head);
		this.head= newNode;
	}
	
	/**
	 * GET TOP NODE
	 */
	public Product top() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException();
		
		return (this.head.info);
	}
	
	/**
	 * POP A NODE
	 * @return
	 * @throws EmptyStackException
	 */
	public Product pop() throws EmptyStackException{
		if(isEmpty()) throw new EmptyStackException();
		
		Product x= this.head.info;
		
		this.head= head.next;
		
		return x;
		
	}
	
	/**
	 * PRINT 
	 */
	
	public void print() {
		Node current= this.head;
		
		while(current != null) {
			System.out.println(current.info);
			current= current.next;
		}
		
	}

}
