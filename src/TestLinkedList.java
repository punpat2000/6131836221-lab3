import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinkedList {


	@Test
	public void testContentSwap() throws Exception {

		LinkedList list = new LinkedList();

		Contact ann = new Contact();
		ann.name = "Ann";
		ann.email = "ann@gmail.com";
		ann.phone = "0812345678";

		Contact kate = new Contact();
		kate.name = "Kate";
		kate.email = "kato@gmail.com";
		kate.phone = "0856723232";

		Contact jane = new Contact();
		jane.name = "Jane";
		jane.email = "jane@gmail.com";
		jane.phone = "0802340078";

		Contact jojo = new Contact();
		jojo.name = "Jojo";
		jojo.email = "jojo@gmail.com";
		jojo.phone = "0836527732";

		Contact james = new Contact();
		james.name = "James";
		james.email = "james@gmail.com";
		james.phone = "0818374721";
		
		list.insert(james, new MyListIterator(list.header));
		list.insert(jojo, new MyListIterator(list.header));
		list.insert(jane, new MyListIterator(list.header));
		list.insert(ann, new MyListIterator(list.header));
		list.insert(kate, new MyListIterator(list.header));

		Iterator itr1 = new MyListIterator(list.header);
		Iterator itr2 = new MyListIterator(list.header);
		itr1.next();
		itr1.next();
		itr2.next();
		itr2.next();
		itr2.next();
		itr2.next();
		
		list.contentSwap(itr1,itr2);
		assertEquals("Jojo", ((Contact) ((MyListIterator) itr1).currentNode.data).name);
		assertEquals("Jane", ((Contact) ((MyListIterator) itr1).currentNode.nextNode.data).name);
		assertEquals("Ann", ((Contact) ((MyListIterator) itr2).currentNode.data).name);
		assertEquals("James", ((Contact) ((MyListIterator) itr2).currentNode.nextNode.data).name);
		

	}

	@Test
	public void testNodeSwap() throws Exception {

		LinkedList list = new LinkedList();

		Contact ann = new Contact();
		ann.name = "Ann";
		ann.email = "ann@gmail.com";
		ann.phone = "0812345678";

		Contact kate = new Contact();
		kate.name = "Kate";
		kate.email = "kato@gmail.com";
		kate.phone = "0856723232";

		Contact jane = new Contact();
		jane.name = "Jane";
		jane.email = "jane@gmail.com";
		jane.phone = "0802340078";

		Contact jojo = new Contact();
		jojo.name = "Jojo";
		jojo.email = "jojo@gmail.com";
		jojo.phone = "0836527732";

		Contact james = new Contact();
		james.name = "James";
		james.email = "james@gmail.com";
		james.phone = "0818374721";
		
		list.insert(james, new MyListIterator(list.header));
		list.insert(jojo, new MyListIterator(list.header));
		list.insert(jane, new MyListIterator(list.header));
		list.insert(ann, new MyListIterator(list.header));
		list.insert(kate, new MyListIterator(list.header));

		Iterator itr1 = new MyListIterator(list.header);
		Iterator itr2 = new MyListIterator(list.header);
		itr1.next();
		itr1.next();
		itr2.next();
		itr2.next();
		itr2.next();
		itr2.next();
		
		list.nodeSwap(itr1,itr2);
		assertEquals("Ann", ((Contact) ((MyListIterator) itr1).currentNode.data).name);
		assertEquals("James", ((Contact) ((MyListIterator) itr1).currentNode.nextNode.data).name);
		assertEquals("Jojo", ((Contact) ((MyListIterator) itr2).currentNode.data).name);
		assertEquals("Jane", ((Contact) ((MyListIterator) itr2).currentNode.nextNode.data).name);
		
		Iterator itr3 = new MyListIterator(list.header);
		itr3.next();
		itr3.next();
		assertEquals("Jojo", ((Contact) ((MyListIterator) itr2).currentNode.data).name);
		

	}
	
	@Test
	public void testNodeSwapOtherList() throws Exception {

		LinkedList list = new LinkedList();

		Contact ann = new Contact();
		ann.name = "Ann";
		ann.email = "ann@gmail.com";
		ann.phone = "0812345678";

		Contact kate = new Contact();
		kate.name = "Kate";
		kate.email = "kato@gmail.com";
		kate.phone = "0856723232";

		Contact jane = new Contact();
		jane.name = "Jane";
		jane.email = "jane@gmail.com";
		jane.phone = "0802340078";

		Contact jojo = new Contact();
		jojo.name = "Jojo";
		jojo.email = "jojo@gmail.com";
		jojo.phone = "0836527732";

		Contact james = new Contact();
		james.name = "James";
		james.email = "james@gmail.com";
		james.phone = "0818374721";
		
		list.insert(james, new MyListIterator(list.header));
		list.insert(jojo, new MyListIterator(list.header));
		list.insert(jane, new MyListIterator(list.header));
		list.insert(ann, new MyListIterator(list.header));
		list.insert(kate, new MyListIterator(list.header));

		LinkedList list2 = new LinkedList();

		Contact ann2 = new Contact();
		ann2.name = "Ann2";
		ann2.email = "ann@gmail.com";
		ann2.phone = "0812345678";

		Contact kate2 = new Contact();
		kate2.name = "Kate2";
		kate2.email = "kato@gmail.com";
		kate2.phone = "0856723232";

		Contact jane2 = new Contact();
		jane2.name = "Jane2";
		jane2.email = "jane@gmail.com";
		jane2.phone = "0802340078";

		Contact jojo2 = new Contact();
		jojo2.name = "Jojo2";
		jojo2.email = "jojo@gmail.com";
		jojo2.phone = "0836527732";

		Contact james2 = new Contact();
		james2.name = "James2";
		james2.email = "james@gmail.com";
		james2.phone = "0818374721";
		
		list2.insert(james2, new MyListIterator(list2.header));
		list2.insert(jojo2, new MyListIterator(list2.header));
		list2.insert(jane2, new MyListIterator(list2.header));
		list2.insert(ann2, new MyListIterator(list2.header));
		list2.insert(kate2, new MyListIterator(list2.header));
		Iterator itr1 = new MyListIterator(list.header);
		Iterator itr2 = new MyListIterator(list2.header);
		itr1.next();
		itr1.next();
		itr1.next();
		itr2.next();
		itr2.next();
		itr2.next();
		itr2.next();
		
		list.nodeSwap(itr1,list2,itr2);
		assertEquals("Jane", ((Contact) ((MyListIterator) itr1).currentNode.data).name);
		assertEquals("James2", ((Contact) ((MyListIterator) itr1).currentNode.nextNode.data).name);
		assertEquals("Jojo2", ((Contact) ((MyListIterator) itr2).currentNode.data).name);
		assertEquals("Jojo", ((Contact) ((MyListIterator) itr2).currentNode.nextNode.data).name);
		
		Iterator itr3 = new MyListIterator(list.header);
		itr3.next();
		itr3.next();
		itr3.next();
		assertEquals("Jojo2", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		

	}
	
	@Test
	public void testCrossOver() throws Exception {

		LinkedList list = new LinkedList();

		Contact ann = new Contact();
		ann.name = "Ann";
		ann.email = "ann@gmail.com";
		ann.phone = "0812345678";

		Contact kate = new Contact();
		kate.name = "Kate";
		kate.email = "kato@gmail.com";
		kate.phone = "0856723232";

		Contact jane = new Contact();
		jane.name = "Jane";
		jane.email = "jane@gmail.com";
		jane.phone = "0802340078";

		Contact jojo = new Contact();
		jojo.name = "Jojo";
		jojo.email = "jojo@gmail.com";
		jojo.phone = "0836527732";

		Contact james = new Contact();
		james.name = "James";
		james.email = "james@gmail.com";
		james.phone = "0818374721";
		
		list.insert(james, new MyListIterator(list.header));
		list.insert(jojo, new MyListIterator(list.header));
		list.insert(jane, new MyListIterator(list.header));
		list.insert(ann, new MyListIterator(list.header));
		list.insert(kate, new MyListIterator(list.header));

		LinkedList list2 = new LinkedList();

		Contact ann2 = new Contact();
		ann2.name = "Ann2";
		ann2.email = "ann@gmail.com";
		ann2.phone = "0812345678";

		Contact kate2 = new Contact();
		kate2.name = "Kate2";
		kate2.email = "kato@gmail.com";
		kate2.phone = "0856723232";

		Contact jane2 = new Contact();
		jane2.name = "Jane2";
		jane2.email = "jane@gmail.com";
		jane2.phone = "0802340078";

		Contact jojo2 = new Contact();
		jojo2.name = "Jojo2";
		jojo2.email = "jojo@gmail.com";
		jojo2.phone = "0836527732";

		Contact james2 = new Contact();
		james2.name = "James2";
		james2.email = "james@gmail.com";
		james2.phone = "0818374721";
		
		list2.insert(james2, new MyListIterator(list2.header));
		list2.insert(jojo2, new MyListIterator(list2.header));
		list2.insert(jane2, new MyListIterator(list2.header));
		list2.insert(ann2, new MyListIterator(list2.header));
		list2.insert(kate2, new MyListIterator(list2.header));
		
		Iterator itr1 = new MyListIterator(list.header);
		Iterator itr2 = new MyListIterator(list2.header);
		itr1.next();
		itr1.next();
		itr1.next();
		itr2.next();
		itr2.next();
		itr2.next();
		itr2.next();
		
		list.crossOver(itr1,itr2);		
		Iterator itr3 = new MyListIterator(list.header);
		itr3.next();
		assertEquals("Kate", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("Ann", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("Jane", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("James2", ((Contact) ((MyListIterator) itr3).currentNode.data).name);

		itr3 = new MyListIterator(list2.header);
		itr3.next();
		assertEquals("Kate2", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("Ann2", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("Jane2", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("Jojo2", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("Jojo", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		itr3.next();
		assertEquals("James", ((Contact) ((MyListIterator) itr3).currentNode.data).name);
		

	}
}
