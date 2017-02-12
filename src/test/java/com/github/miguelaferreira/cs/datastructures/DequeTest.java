package com.github.miguelaferreira.cs.datastructures;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public abstract class DequeTest {

	protected Deque<Integer> deque;

	@Test
	public void insert() throws Exception {
		deque.insert(1);
		deque.insert(2);
		deque.insert(3);

		assertThat(deque.getLast(), is(1));
		assertThat(deque.getLast(), is(2));
		assertThat(deque.getLast(), is(3));

		assertThat(deque.isEmpty(), is(true));
	}

	@Test
	public void append() throws Exception {
		deque.append(1);
		deque.append(2);
		deque.append(3);

		assertThat(deque.getFirst(), is(1));
		assertThat(deque.getFirst(), is(2));
		assertThat(deque.getFirst(), is(3));

		assertThat(deque.isEmpty(), is(true));
	}

	@Test
	public void getFirst() throws Exception {
		deque.insert(1);
		deque.insert(2);
		deque.insert(3);

		assertThat(deque.getFirst(), is(3));
		assertThat(deque.getLast(), is(1));
		assertThat(deque.getFirst(), is(2));

		assertThat(deque.isEmpty(), is(true));
	}

	@Test
	public void getLast() throws Exception {
		deque.insert(1);
		deque.insert(2);
		deque.insert(3);

		assertThat(deque.getLast(), is(1));
		assertThat(deque.getFirst(), is(3));
		assertThat(deque.getLast(), is(2));

		assertThat(deque.isEmpty(), is(true));
	}

	@Test
	public void size() throws Exception {
		assertThat(deque.size(), is(0));
		deque.insert(1);
		assertThat(deque.size(), is(1));
		deque.insert(2);
		assertThat(deque.size(), is(2));
		deque.insert(3);
		assertThat(deque.size(), is(3));
		deque.append(1);
		assertThat(deque.size(), is(4));
		deque.append(2);
		assertThat(deque.size(), is(5));
	}

	@Test
	public void palindromeChecker() {
		String palindrome = "radar";
		palindrome.chars().forEach(deque::insert);

		while(deque.size() > 1) {
			assertThat(deque.getFirst(), is(deque.getLast()));
		}
	}

}