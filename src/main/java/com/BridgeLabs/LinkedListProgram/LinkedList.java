package com.BridgeLabs.LinkedListProgram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList<K> {
	private static final Logger logger = LogManager.getLogger(LinkedList.class);

	public INode<K> head;
	public INode<K> tail;
	private int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public void add(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			INode<K> temp = this.head;
			this.head = newNode;
			this.head.setNext(temp);
		}
		this.size++;
	}

	public void append(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
		} else {
			this.tail.setNext(newNode);
			this.tail = this.tail.getNext();
		}
		this.size++;
	}

	public void insertAfter(INode<K> node, INode<K> newNode) {
		INode<K> temp = node.getNext();
		node.setNext(newNode);
		node.getNext().setNext(temp);
		this.size++;
	}

	public INode<K> pop() {
		INode<K> temp = this.head;
		this.head = this.head.getNext();
		size--;
		return temp;
	}
	
	public INode<K> popLast(){
		INode<K> secondLastNode=this.head;
		if(secondLastNode==null) {
			return null;
		}else if(secondLastNode==this.tail) {
			this.head=null;
			this.tail=null;
			return secondLastNode;
		}else {
			while(secondLastNode.getNext()!=this.tail) {
				secondLastNode=secondLastNode.getNext();
			}
		}
		INode<K> temp=this.tail;
		this.tail=secondLastNode;
		this.tail.setNext(null);
		size--;
		return temp;
	}

	public void printList() {
		INode<K> node = this.head;
		if (node != null) {
			logger.debug("List: " + node.getKey());
			while ((node = node.getNext()) != null) {
				logger.debug("->" + node.getKey());
			}
		}
		logger.debug(" Size: " + size);
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		list.append(node1);
		list.append(node3);
		list.insertAfter(node1, node2);
		logger.debug("List before popping last:\n");
		list.printList();
		logger.debug("\nPopped element: " + list.popLast().getKey());
		logger.debug("\nList after popping last:\n");
		list.printList();
	}
}

interface INode<K> {
	K getKey();

	void setKey(K key);

	INode<K> getNext();

	void setNext(INode<K> next);
}

class MyNode<K> implements INode<K> {
	private K key;
	private MyNode<K> next;

	public MyNode(K key) {
		super();
		this.key = key;
		this.next = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public MyNode<K> getNext() {
		return next;
	}

	public void setNext(INode<K> next) {
		this.next = (MyNode<K>) next;
	}

}