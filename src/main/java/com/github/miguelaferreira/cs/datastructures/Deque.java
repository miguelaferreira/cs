package com.github.miguelaferreira.cs.datastructures;

public interface Deque<T> {

	void insert(T element);

	void append(T element);

	T getFirst();

	T getLast();

	boolean isEmpty();

	int size();
}
