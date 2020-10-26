package com.special;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.node.LruNode;

import java.util.Collections;


public class LFU {
	public int capcity;
	public Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public Map<Integer, HitMapRate> hitMap = new HashMap<Integer, LFU.HitMapRate>();
	
	public int get(int key) {
		Integer integer = map.get(key);
		if(integer==null) {
			return -1;
		}
		addCount(key);
		return integer.intValue();
	}
	public void addCount(int key) {
		HitMapRate hitMapRate = hitMap.get(key);
		if (hitMapRate == null){
			hitMapRate = new HitMapRate(1, key, System.currentTimeMillis());
			hitMap.put(key, hitMapRate);
		}else {
			hitMapRate.hitcount = hitMapRate.hitcount+1;
			hitMapRate.time = System.currentTimeMillis();
			hitMap.put(key, hitMapRate);
		}
	}
	
	public void put(int key, int value) {
		Integer integer = map.get(key);
		if(integer==null) {
			if(map.size()==capcity) {
				remove();
			}	
		}
		addCount(key);
		map.put(key, value);
	}
	
	public void remove() {
		HitMapRate hr = Collections.min(hitMap.values());
		hitMap.remove(hr.key);
		map.remove(hr.key);
	}
	
	class HitMapRate implements Comparable<HitMapRate>{
		private int hitcount;
		private int key;
		private long time; 
		public HitMapRate(int hitcount, int key, long time) {
			this.hitcount = hitcount;
			this.key = key;
			this.time = time;
		}
		@Override
		public int compareTo(HitMapRate o) {
			int compare = Integer.compare(this.hitcount, o.hitcount);
			return compare == 0 ? Long.compare(this.time, o.time): compare;
		}
	}
	

	public static void main(String[] args) {
		LFU cache = new LFU();
		cache.capcity = 3;
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 3);
        for(Map.Entry<Integer, Integer> entry: cache.map.entrySet()) {
        	System.out.println(entry.getKey()+", "+entry.getValue());
        }
       
	}
	
}
