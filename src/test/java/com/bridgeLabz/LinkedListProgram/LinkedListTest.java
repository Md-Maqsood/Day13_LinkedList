package com.bridgeLabz.LinkedListProgram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import com.bridgeLabz.LinkedListProgram.MyNode;
import com.bridgeLabz.LinkedListProgram.SortededLinkedList;

public class LinkedListTest {
	private static final Logger logger = LogManager.getLogger(LinkedListTest.class);

	@Test
	public void givenSearchValueWhenInListShouldReturnTrue() {
		SortededLinkedList<Integer> list = new SortededLinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.printList();
		boolean result = list.search(30);
		Assert.assertTrue(result);
	}

	@Test
	public void givenSearchValueWhenNotInListShouldReturnFalse() {
		SortededLinkedList<Integer> list = new SortededLinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.printList();
		boolean result = list.search(40);
		Assert.assertFalse(result);
	}


	@Test
	public void onDeletingGivenValueWhenSearchedShouldReturnFalse_AndListSizeReducedByOne() {
		SortededLinkedList<Integer> list = new SortededLinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		MyNode<Integer> node4 = new MyNode<Integer>(40);
		list.add(node1);
		list.add(node2);
		list.add(node4);
		list.add(node3);
		logger.debug("Before deletion: ");
		list.printList();
		int sizeBeforeDeletion=list.size();
		list.remove(40);
		int sizeAfterDeletion=list.size();
		logger.debug("After deletion: ");
		list.printList();
		boolean result = (list.search(40)==false) || sizeAfterDeletion==sizeBeforeDeletion-1;
		Assert.assertTrue(result);
	}
	
	@Test
	public void onDeletingFromListWithSingleElementGivenValueWhenSearchedShouldReturnFalseAndListSizeReducedByOneWith() {
		SortededLinkedList<Integer> list = new SortededLinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		list.add(node1);
		logger.debug("Before deletion: ");
		list.printList();
		int sizeBeforeDeletion=list.size();
		list.remove(56);
		int sizeAfterDeletion=list.size();
		logger.debug("After deletion: ");
		list.printList();
		boolean result = (list.search(56)==false) || sizeAfterDeletion==sizeBeforeDeletion-1;
		Assert.assertTrue(result);
	}
	
	@Test
	public void onDeletingGivenValueNotInListListSizeShouldRemainSame() {
		SortededLinkedList<Integer> list = new SortededLinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		MyNode<Integer> node4 = new MyNode<Integer>(40);
		list.add(node1);
		list.add(node2);
		list.add(node4);
		list.add(node3);
		
		logger.debug("Before deletion: ");
		list.printList();
		int sizeBeforeDeletion=list.size();
		list.remove(50);
		int sizeAfterDeletion=list.size();
		logger.debug("After deletion: ");
		list.printList();
		boolean result = sizeAfterDeletion==sizeBeforeDeletion;
		Assert.assertTrue(result);
	}
	
	@Test
	public void onAddingUnorderedValuesWhenMatchedShouldMatchSortedOrder() {
		SortededLinkedList<Integer> list = new SortededLinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		MyNode<Integer> node4 = new MyNode<Integer>(40);
		list.add(node1);
		list.add(node2);
		list.add(node4);
		list.add(node3);
		list.printList();
		MyNode<Integer> node=(MyNode<Integer>) list.head;
		boolean result= node==node2;
		node=node.getNext();
		result=result && node==node4;
		node=node.getNext();
		result=result && node==node1;
		node=node.getNext();
		result=result && node==node3;
		Assert.assertTrue(result);
		
	}
}
