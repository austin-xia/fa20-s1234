import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

	@Test
	public void Junit_checkEmpty (){
		LinkedLisDeque<Integer> A = new LinkedLisDeque<>();
		assertEquals(true,A.isEmpty());
		A.addFirst(66);
		assertEquals(false,A.isEmpty());
	}

	@Test
	public void Junit_check_addfirst_addlast_Size(){
		LinkedLisDeque<Integer> A = new LinkedLisDeque<>();
		A.addFirst (3);
		A.addFirst (2);
		A.addFirst (1);
		assertEquals(3, A.size);
		LinkedLisDeque<Integer> B = new LinkedLisDeque<>();
		B.addFirst (3);
		assertEquals(1, B.size);
		LinkedLisDeque<Integer> C = new LinkedLisDeque<>();
		assertEquals(0, C.size);
		LinkedLisDeque<String> D = new LinkedLisDeque<>();
		D.addFirst ("hello");
		assertEquals(1, D.size);
		LinkedLisDeque<Integer> E = new LinkedLisDeque<>();
		E.addLast (3);
		E.addFirst (2);
		E.addLast (1);
		assertEquals(3, E.size);
		LinkedLisDeque<String> F = new LinkedLisDeque<>();
		assertEquals(0, F.size);
		LinkedLisDeque<String> G = new LinkedLisDeque<>();
		G.addFirst ("hello");
		G.addLast ("world");
		G.addFirst ("Austin: ");
		assertEquals(3, G.size);
	}

	@Test
	public void Junit_print(){
		LinkedLisDeque<String> G = new LinkedLisDeque<>();
		G.addFirst ("hello");
		G.addLast ("world");
		G.addFirst ("Austin: ");
		assertEquals(3, G.size);
		/* list print **/
		G.printDeque();
	}

	@Test
	public void Junit_addremoveTest (){
		LinkedLisDeque<Integer> A = new LinkedLisDeque<>();
		A.addFirst (3);
		A.addFirst (2);
		A.addFirst (1);
		assertEquals(3, A.size);
		/* list print **/
		A.printDeque();
		/* remove test**/
		A.removeLast();
		assertEquals(2, A.size);
		A.removeFirst();
		assertEquals(1, A.size);
		/* String type list test **/
		LinkedLisDeque<String> G = new LinkedLisDeque<>();
		G.addFirst ("hello");
		G.addLast ("world");
		G.addFirst ("Austin: ");
		assertEquals(3, G.size);
		/* list print **/
		G.printDeque();
		/* remove test**/
		assertEquals("world", G.removeLast());
		assertEquals(2, G.size);
		G.removeFirst();
		assertEquals(1, G.size);
	}

	@Test
	public void Junit_TestGET () {
		LinkedLisDeque<Integer> A = new LinkedLisDeque<>();
		A.addFirst(3);
		A.addFirst(2);
		A.addFirst(1);
		assertEquals(1, (int) A.get(0));
		assertEquals(2, (int) A.get(1));
		assertEquals(3, (int) A.get(2));
		assertEquals(null, A.get(3));
		assertEquals(null, A.get(100));

		LinkedLisDeque<String> G = new LinkedLisDeque<>();
		G.addFirst("hello");
		G.addLast("world");
		G.addFirst("Austin: ");
		assertEquals("Austin: ", G.get(0));
		assertEquals("hello", G.get(1));
		assertEquals("world", G.get(2));
		assertEquals(null, G.get(3));
	}




	/* Utility method for printing out empty checks. */
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Utility method for printing out empty checks. */
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	public static void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		/*
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
		*/
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	public static void addRemoveTest() {

		System.out.println("Running add/remove test.");

		System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
		/*
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
		*/
	}

	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addIsEmptySizeTest();
		addRemoveTest();
	}

} 