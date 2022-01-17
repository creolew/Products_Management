package pck1;

public class Node {
	Product info;
	Node next;
	
	/**CONSTRUCTOR
	 */
	
	public Node(Product info, Node next) {		
		this.info = info;
		this.next = next;
	}
	
	public Node(Product x) {
		this(x, null);
	}
	
	/**
	 * GETTER, SETTER
	 *
	 */
	
	public Product getInfo() {
		return info;
	}

	public void setInfo(Product info) {
		this.info = info;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node a) {
		this.next = a;
	}
	
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		
		return info.toString();
	}

}
