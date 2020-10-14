package com.BridgeLabs.LinkedListProgram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortededLinkedList<K extends Comparable<K>> {
	private static final Logger logger = LogManager.getLogger(SortededLinkedList.class);

	public INode<K> head;
	public INode<K> tail;
	private int size;

	public SortededLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return size;
	}

	public void add(INode<K> newNode) {
		if (this.head == null) {
			this.head = newNode;
		}
		if (this.tail == null) {
			this.tail = newNode;
			size++;
		}else if(this.head==this.tail) {
			if(newNode.getKey().compareTo(this.head.getKey())>0) {
				append(newNode);
			}else {
				INode<K> temp = this.head;
				this.head = newNode;
				this.head.setNext(temp);
				size++;
			}
		}else if(newNode.getKey().compareTo(this.head.getKey())<0) {
			INode<K> temp = this.head;
			this.head = newNode;
			this.head.setNext(temp);
			size++;
		}else {
			INode<K> node = this.head;
			while(node!=this.tail && newNode.getKey().compareTo(node.getNext().getKey())>0) {
				node=node.getNext();
			}
			insertAfter(node, newNode);
		}
	}

	private void append(INode<K> newNode) {
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

	private void insertAfter(INode<K> node, INode<K> newNode) {
		if(node==this.tail) {
			append(newNode);
		} else {
			INode<K> temp = node.getNext();
			node.setNext(newNode);
			node.getNext().setNext(temp);
			this.size++;
		}
	}

	public INode<K> pop() {
		INode<K> temp = this.head;
		this.head = this.head.getNext();
		size--;
		return temp;
	}

	public INode<K> popLast() {
		INode<K> secondLastNode = this.head;
		if (secondLastNode == null) {
			return null;
		} else if (secondLastNode == this.tail) {
			this.head = null;
			this.tail = null;
			return secondLastNode;
		} else {
			while (secondLastNode.getNext() != this.tail) {
				secondLastNode = secondLastNode.getNext();
			}
		}
		INode<K> temp = this.tail;
		this.tail = secondLastNode;
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
		logger.debug(" Size: " + size + "\n");
	}

	public boolean search(K searchValue) {
		INode<K> node = this.head;
		while (node != null) {
			if (node.getKey().equals(searchValue)) {
				return true;
			}
			node = node.getNext();
		}
		return false;
	}

	private void insertAfter(K value, INode<K> newNode) {
		INode<K> node = this.head;
		while (node != null) {
			if (node.getKey().equals(value)) {
				break;
			}
			node = node.getNext();
		}
		if (node != null) {
			insertAfter(node, newNode);
		}
	}

	public void remove(K value) {
		INode<K> node = this.head;
		if (node == this.tail && node != null) {
			if (node.getKey().equals(value)) {
				this.head = null;
				this.tail = null;
				size--;
			}
		} else if (node != null) {
			while (node != this.tail && !(node.getNext().getKey().equals(value))) {
				node = node.getNext();
			}
			if (node != this.tail) {
				INode<K> nodeRemoved = node.getNext();
				node.setNext(nodeRemoved.getNext());
				nodeRemoved.setNext(null);
				if (nodeRemoved == this.tail) {
					this.tail = node;
				}
				size--;
			}
		}
	}

	public static void main(String[] args) {
		SortededLinkedList<Integer> list = new SortededLinkedList<Integer>();
		MyNode<Integer> node1 = new MyNode<Integer>(56);
		MyNode<Integer> node2 = new MyNode<Integer>(30);
		MyNode<Integer> node3 = new MyNode<Integer>(70);
		MyNode<Integer> node4 = new MyNode<Integer>(40);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.printList();
	}

}

interface INode<K extends Comparable<K>> {
	K getKey();

	void setKey(K key);

	INode<K> getNext();

	void setNext(INode<K> next);
}

class MyNode<K extends Comparable<K>> implements INode<K> {
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