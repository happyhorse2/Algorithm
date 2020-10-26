package RememberTest;

import java.util.HashMap;
import java.util.Map;

class LRU{
	int capcity;
    Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    ListNode head;
    ListNode tail;    
    
    public LRU(int capcity) {
    	this.capcity = capcity;
    }
        
    public void put(int key, int value) {
    	ListNode listNode = map.get(key);
    	if (listNode==null) {
    		if(map.size()==capcity) {
    			remove();
    		}
    		listNode = new ListNode(key, value);
        	addToHead(listNode);
        	map.put(key, listNode);
    	}
    	else {
    		listNode.value = value;
        	moveToHead(listNode);
    	}
    }
    
    public void remove() {
    	map.remove(tail.key);
    	ListNode listNode = tail.pre;
    	if (listNode!=null) {
    		listNode.next = tail.next;
        	tail = listNode;
    	}else {
    		head = null;
    		tail = null;
    	}
    }
    public int get(int key) {
    	ListNode listNode = map.get(key);
    	if (listNode== null) {
    		return -1;
    	}
    	moveToHead(listNode);
    	return listNode.value;
    	
    }
    
    public void addToHead(ListNode listNode) {
    	if(map.isEmpty()) {
    		head = listNode;
    		tail = listNode;
    	}
    	else {
    		listNode.next = head;
    		listNode.pre = head.pre;
    		head.pre = listNode;
    		head = listNode;
    	}
    }
    //我需要知道把那个节点moveToHead，所以需要map
    public void moveToHead(ListNode listNode) {
    	if(listNode==head) {
    		return;
    	}else if(listNode == tail) {
    		listNode.pre.next = listNode.next;
    		tail = listNode.pre;
    	}else {
			listNode.pre.next = listNode.next;
			listNode.next.pre = listNode.pre;
		}
    	listNode.next = head;
		listNode.pre = head.pre;
		head.pre = listNode;
		head = listNode;
    }
}

class ListNode{
	int key;
	int value;
	ListNode pre;
	ListNode next;
	
	public ListNode(int key, int value) {
		this.key = key;
		this.value = value;
	}

}

public class ProblemTwo {

}
