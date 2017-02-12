package com.github.miguelaferreira.cs.datastructures;

import java.lang.reflect.Array;

public class ArrayDeque<T> implements Deque<T> {

	private final T[] buffer;
	private final static int START = 0;
	private int end = 0;

	public ArrayDeque(Class<T> clazz, int size) {
		this.buffer = (T[]) Array.newInstance(clazz, size);
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			buffer[START] = element;
			end++;
		} else if (!isFull()) {
			shiftAllElementsRight();
			buffer[START] = element;
		} else {
			throw new IndexOutOfBoundsException("Deque is full");
		}
	}

	private void shiftAllElementsRight() {
		System.arraycopy(buffer, START, buffer, 1, end);
		end++;
	}

	@Override
	public void append(T element) {
		if (!isFull()) {
			buffer[end++] = element;
		} else {
			throw new IndexOutOfBoundsException("Deque is full");
		}
	}

	private boolean isFull() {
		return end == buffer.length;
	}

	@Override
	public T getFirst() {
		if (!isEmpty()) {
			T element = buffer[START];
			shiftAllElementsLeft();
			return element;
		} else {
			throw new IndexOutOfBoundsException("Deque is empty");
		}
	}

	private void shiftAllElementsLeft() {
		System.arraycopy(buffer, 1, buffer, START, end - 1);
		end--;
	}

	@Override
	public T getLast() {
		if (!isEmpty()) {
			T element = buffer[end - 1];
			end--;
			return element;
		} else {
			throw new IndexOutOfBoundsException("Deque is empty");
		}
	}

	@Override
	public boolean isEmpty() {
		return START == end;
	}

	@Override
	public int size() {
		return end;
	}

}
