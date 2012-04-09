/**
 *  Apr 8, 2012
 */
package ravid.java.programs.basic;

/**
 * Find the Nth from last element.
 *
 * @author Ravi
 */
public class LinkedListOperations {
	
	private int length;
	private Node head;
    
	public LinkedListOperations() {
		head = new Node();
	}
	
	public String[] traverse() {
		String[] array = new String[length];
		Node temp = head;
		int i = 0;
		while (temp != null) {
			array[i] = temp.getValue();
			temp = temp.getNext();
			i++;
		}
		return array;
	}
	
	public int size() {
		return length;
	}
	
	public String getN(int n) {
		if (n > length || length == 0 || n == 0) {
			return null;
		}
		if (n == length) {
			return traverseToEnd().getValue();
		}
		
		int i = 0;
		Node temp = head;
		while (i < n - 1) {
			temp = temp.getNext();
			i++;
		}
		return temp.getValue();
	}
	
	public String getNFromLast(int n) {
		if (n > length || 
				length == 0 || n == 0) {
			return null;
		}
		Node current = head;
		Node temp = head;
		int i = 0;
		while (current != null) {
			if (i > n) {
				temp = temp.getNext();
			}
			i++;
			current = current.getNext();
		}
		return temp.getValue();
	}
	
	public Node traverseToEnd() {
		Node temp = head;
		while(temp != null && temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp;
	}
	
	public void push(String value) {
		if (length == 0) {
			head.setValue(value);
			head.setNext(null);
		} else {
			Node newNode = new Node();
			newNode.setValue(value);
			newNode.setNext(null);
			Node temp = traverseToEnd();
			temp.setNext(newNode);
		}
		length++;
	}
	
	public String pop() {
		String temp;
		if (length == 0) {
			temp = null;
		} else {
			temp  = head.getValue();
			head = head.getNext();
			length--;
		}
		return temp;
	}

	public Node getHead() {
		return head;
	}
}

class Node {
	private Node next;
	private String value;
	
	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getNext() {
		return next;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node value is : " + value;
	}
}
