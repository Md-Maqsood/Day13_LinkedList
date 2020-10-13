package com.BridgeLabs.LinkedListProgram;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

	@Test
	public void givenSearchValue_WhenInList_ShouldReturnTrue() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		list.append(node1);
		list.append(node2);
		list.append(node3);
		list.printList();
		boolean result = list.search(30);
		Assert.assertTrue(result);
	}

	@Test
	public void givenSearchValue_WhenNotInList_ShouldReturnFalse() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		list.append(node1);
		list.append(node2);
		list.append(node3);
		list.printList();
		boolean result = list.search(40);
		Assert.assertFalse(result);
	}

	@Test
	public void onInsertingAfterGivenValue_WhenSearched_ShouldReturnTrue() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		list.append(node1);
		list.append(node2);
		list.append(node3);
		MyNode<Integer> node4 = new MyNode<Integer>(40);
		list.insertAfter(30, node4);
		list.printList();
		boolean result = list.search(40) && node4.getNext() == node3;
		Assert.assertTrue(result);
	}

	@Test
	public void onInsertingAfterGivenValueNotInList_WhenSearched_ShouldReturnFalse() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		list.append(node1);
		list.append(node2);
		list.append(node3);
		MyNode<Integer> node4 = new MyNode<Integer>(40);
		list.insertAfter(50, node4);
		list.printList();
		boolean result = list.search(40) || node4.getNext() == node3;
		Assert.assertFalse(result);
	}

}
