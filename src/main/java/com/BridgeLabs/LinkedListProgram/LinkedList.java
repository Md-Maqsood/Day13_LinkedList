package com.BridgeLabs.LinkedListProgram;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LinkedList {
	private static final Logger logger=LogManager.getLogger(LinkedList.class);
	public static void main(String[] args) {
		logger.debug("Creating a simple linked list: \n");
		MyNode<Integer> node1=new MyNode<Integer>(56);
		MyNode<Integer> node2=new MyNode<Integer>(30);
		MyNode<Integer> node3=new MyNode<Integer>(70);
		node1.setNext(node2);
		node2.setNext(node3);
		MyNode<Integer> node=node1;
		logger.debug("List: "+node.getKey());
		while((node=node.getNext())!=null) {
			logger.debug("->"+node.getKey());
		}
	}
}

interface INode<K>{
	K getKey();
	void setKey(K key);
	INode<K> getNext();
	void setNext(INode<K> next);
}

class MyNode<K> implements INode<K>{
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