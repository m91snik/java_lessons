package com.kamyshovcorp.app;

import com.kamyshovcorp.LinkedQueue;
import com.kamyshovcorp.Queue;

/**
 * @author kamyshov.sergey
 * @since 06.08.2015
 */
public class LinkedQueueTest {

	public static void main(String[] args) {
		Queue<String> queue = new LinkedQueue<>();
		System.out.println(String.format("The start queue size: %d", queue.size()));

		// Expected EmptyQueueException, 'cause Queue is empty
//		queue.pop();

		System.out.println();
		System.out.println(String.format("Was first element added to queue? %b", queue.add("One")));
		System.out.println(String.format("The queue size after adding first element: %d", queue.size()));
		System.out.println(String.format("Was second element added to queue? %b", queue.add("One")));
		System.out.println(String.format("The queue size after adding second element: %d", queue.size()));
		System.out.println(String.format("Was third element added to queue? %b", queue.add("One")));
		System.out.println(String.format("The queue size after adding third element: %d", queue.size()));

		System.out.println();
		System.out.println(String.format("The element after first pop(): '%s'", queue.pop()));
		System.out.println(String.format("The queue size after first pop(): %s", queue.size()));
		System.out.println(String.format("The element after second pop(): '%s'", queue.pop()));
		System.out.println(String.format("The queue size after second pop(): %s", queue.size()));
		System.out.println(String.format("The element after third pop(): '%s'", queue.pop()));
		System.out.println(String.format("The queue size after third pop(): %s", queue.size()));
	}

}
