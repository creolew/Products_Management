package pck1;

import java.util.ArrayList;

public class MyList {
	Node head, tail;
	
	/**
	 * CONSTRUCTOR
	 */
		public MyList() {
			head= tail= null;
		}
	/**
	 * METHOD
	 */
		public void clear() {
			head= tail= null;
		}

		public boolean isEmpty() {
			return (head == null);
		}
		
	
		public void insertAtTail (Product x) {

			Node newNode= new Node(x);
			if(this.head == null) {
				this.head= newNode;
			}
			
			if(this.tail != null){
				this.tail.setNext(newNode);
			}
			
			this.tail= newNode;
		}
		
		@Override
		public String toString() {
			Node curr= this.head;
			String result= "";
			
			// Traverse through the LinkedList
			while(curr != null) {
				result += curr.toString();
				
				// Go to next node
				curr= curr.getNext();
			}
			return result;
		}

}
