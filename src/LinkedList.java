class ListNode {
	// Constructors
	ListNode(Object theElement) {
		this(theElement, null);
	}

	ListNode(Object theElement, ListNode n) {
		data = theElement;
		nextNode = n;
	}

	// Friendly data; accessible by other package routines
	Object data;
	ListNode nextNode;
}

public class LinkedList {
	ListNode header;

	public LinkedList() {
		header = new ListNode(null);
	}

	public boolean isEmpty() {
		return header.nextNode == null;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = null;
	}

	public void insert(Object value, Iterator p) throws Exception {
		if (p == null || !(p instanceof MyListIterator))
			throw new Exception();
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();
		ListNode n = new ListNode(value, p2.currentNode.nextNode);
		p2.currentNode.nextNode = n;
	}

	public int find(Object value) throws Exception {
		Iterator itr = new MyListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			Object v = itr.next();
			index++;
			if (v.equals(value))
				return index; // return the position of value.
		}
		return -1;
	}

	public Iterator findPrevious(Object value) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		if (!itr2.hasNext())
			return null;
		Object currentData = itr2.next();
		while (!currentData.equals(value) && itr2.hasNext()) {
			currentData = itr2.next();
			itr1.next();
		}
		if (currentData.equals(value))
			return itr1;
		return null;

	}
	
	public void remove(Iterator p) {
		if (p == null || !(p instanceof MyListIterator))
			return;
		MyListIterator p2 = (MyListIterator) p;
		if (p2.currentNode == null || p2.currentNode.nextNode == null)
			return;
		p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
	}

	public void remove(Object value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	private Iterator findPrevious(Iterator i) throws Exception {
		Iterator itr1 = new MyListIterator(header);
		Iterator itr2 = new MyListIterator(header);
		itr2.next();
		while ( ((MyListIterator) i).currentNode != ((MyListIterator) itr2).currentNode) {
			itr2.next();
			itr1.next();
		}
		return itr1;

	}
	// contentSwap
	
	public void contentSwap(Iterator i1, Iterator i2) {
		Object temp = ((MyListIterator) i1).currentNode.data;
		i1.set(((MyListIterator) i2).currentNode.data);
		i2.set(temp);
	}
	
	// nodeSwap 
	
	public void nodeSwap(Iterator i1, Iterator i2) throws Exception {
		if(this.isEmpty()) return;
		MyListIterator l1 = (MyListIterator)i1;
		MyListIterator l2 = (MyListIterator)i2;
		ListNode temp = l2.hasNext()?l2.currentNode.nextNode:null;
		l2.currentNode.nextNode = l1.currentNode.nextNode;
		l1.currentNode.nextNode = temp;
		temp = ((MyListIterator) this.findPrevious(i2)).currentNode;
		((MyListIterator) this.findPrevious(i1)).currentNode.nextNode = l2.currentNode;
		temp.nextNode = l1.currentNode;
	}
	
	// nodeSwap Different List
	
	public void nodeSwap(Iterator i1, LinkedList l2, Iterator i2) throws Exception {
		MyListIterator l1 = (MyListIterator)i1;
		MyListIterator p2 = (MyListIterator)i2;
		ListNode temp = p2.hasNext()?p2.currentNode.nextNode:null;
		p2.currentNode.nextNode = l1.currentNode.nextNode;
		l1.currentNode.nextNode = temp;
		temp = ((MyListIterator) this.findPrevious(i2)).currentNode;
		((MyListIterator) this.findPrevious(i1)).currentNode.nextNode = p2.currentNode;
		temp.nextNode = l1.currentNode;
	}
	
	// crossOver
	
	public void crossOver(Iterator i1, Iterator i2) throws Exception {

	}
	

}