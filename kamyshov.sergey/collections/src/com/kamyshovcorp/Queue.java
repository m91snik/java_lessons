package com.kamyshovcorp;

/**
 * @author kamyshov.sergey
 * @since 06.08.2015
 */
public interface Queue<E> {

	boolean add(E element);

	E pop();

	int size();

}
