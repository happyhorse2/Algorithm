package com.special;
import java.util.HashMap;
import java.util.Map;

import com.node.LruNode;

public class LRU {
	private int capacity;
    //保存链表的头节点和尾节点
    private LruNode head;
    private LruNode tail;
    //作为容器使用
    private Map<Integer, LruNode> map;
    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, LruNode>(capacity);
    }
    
    private void moveToHead(LruNode node) {
    	if (node == head) {
    		return;
    	}else if(node == tail) {
    		tail.prevLruNode.nextLruNode = tail.nextLruNode;
    		tail = tail.prevLruNode;
    	}else {
			node.prevLruNode.nextLruNode =  node.nextLruNode;
			node.nextLruNode.prevLruNode = node.prevLruNode;
		}
    	//替换头节点
    	node.nextLruNode = head;
    	node.prevLruNode = head.prevLruNode;
    	head.prevLruNode = node;
    	head = node;
    }
    
    public void put(int key, int value) {
        LruNode node = map.get(key);
        
        if (node == null) {
            node = new LruNode();
            node.key = key;
            node.value = value;
            if(map.size() == capacity) {
                removeLast();
            }
            addToHead(node);
            map.put(key, node);
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
        
    private void removeLast() {
        map.remove(tail.key);
        LruNode prevLruNode = tail.prevLruNode;
        if (prevLruNode != null) {
        	prevLruNode.nextLruNode = null;
            tail = prevLruNode;
        }
    }
    
    private void addToHead(LruNode node) {
    	 if (map.isEmpty()) {
             head = node;
             tail = node;
         } else {
        	 node.nextLruNode = head;
         	 node.prevLruNode =  head.prevLruNode;
         	 head.prevLruNode = node;
         	 head = node;
         }
    }
       
    public int get(int key) {
        LruNode node = map.get(key);
        //为空返回-1
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    
	public static void main(String[] args) {
		LRU cache = new LRU(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 3);
        LruNode lruNode = cache.head;
        while(lruNode!=null) {
        	System.out.println(""+lruNode.key+", "+lruNode.value);
        	lruNode = lruNode.nextLruNode;
        }
	}
}
