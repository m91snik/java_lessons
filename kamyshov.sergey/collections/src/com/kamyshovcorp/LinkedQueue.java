package com.kamyshovcorp;

import com.kamyshovcorp.exception.EmptyQueueException;

/**
 * @author kamyshov.sergey
 * @since 06.08.2015
 */
public class LinkedQueue<E> implements Queue<E> {

	private Entry<E> head, tail;
	private int size;

	@Override
	public boolean add(E element) {
		if (size == 0) {
			head = tail = new Entry<>(element);
		} else if (size == 1) {
			tail = new Entry<>(element);
			head.next = tail;
		} else {
			Entry<E> preLast = tail;
			tail = new Entry<>(element);
			preLast.next = tail;
		}
		size++;
		return true;
	}

	@Override
	public E pop() {
		if (size == 0) {
			throw new EmptyQueueException("The Queue is empty");
		}
		E element = head.element;
		head = head.next;
		size--;
		return element;
	}

	@Override
	public int size() {
		return size;
	}

	private static class Entry<E> {

		E element;
		Entry<E> next;

		public Entry(E element) {
			this.element = element;
		}

	}

}
