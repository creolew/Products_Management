package pck1;

import java.util.EmptyStackException;

public class LinkedQueue {
	Node head, tail;
	
	/**
	 * CONSTRUCTOR
	 */
	public LinkedQueue() {
		head=tail= null;
	}

	
	/**
	 * IS EMPTY
	 */

	public boolean isEmpty() {
		return(tail== null);
	}
	
	/**
	 * ADD A NODE TO THE END OF QUEUE LIST
	 */
	
	public void enqueue(Product x) {
		Node newNode= new Node(x);
		
		// If queue is empty, then new node is head and tail both
		if(isEmpty()) {
			this.head= this.tail= newNode;
			return;
		}
		
		//Add the new node at the end and change tail
		
		this.tail.next= newNode;
		this.tail= newNode;
		
	}

	/**
	 * REMOVE A NODE IN QUEUE LIST	
	 */
	
	public Product dequeue() {
		
		//check empty
		if(isEmpty()) {
			System.out.println("EMPTY !!!");
			return null;
		}else {
			Product x= this.head.info;
			this.head= head.next;
			if(this.head== null) {
				this.tail= null;
			}
			return x;
		}
				
	}
	
	/**
	 * PRINT THE QUEUE
	 */

	public void printQueue() {
		
		Node current= this.head;
		while(current != null) {
			System.out.println(current.info);
			current= current.next;
		}
	}

}


