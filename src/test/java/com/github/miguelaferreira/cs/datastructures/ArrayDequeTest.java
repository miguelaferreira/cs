package com.github.miguelaferreira.cs.datastructures;

import org.junit.Before;
import org.junit.Test;

public class ArrayDequeTest extends DequeTest {

	public static final int SIZE = 5;

	@Before
	public void setUp() throws Exception {
		this.deque = new ArrayDeque<>(Integer.class, SIZE);
	}


	@Test(expected = IndexOutOfBoundsException.class)
	public void insertOverflow() throws Exception {
		deque.insert(1);
		deque.insert(2);
		deque.insert(3);
		deque.insert(4);
		deque.insert(5);
		deque.insert(6);
	}

	@Test
	public void insertToMaxSizeAndRemoveAllElements() throws Exception {
		deque.insert(1);
		deque.insert(2);
		deque.insert(3);
		deque.insert(4);
		deque.insert(5);

		for(int i = 0; i < 5; i ++) {
			deque.getFirst();
		}
	}
}