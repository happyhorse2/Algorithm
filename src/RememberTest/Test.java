package RememberTest;
//是一个容器

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



class LFU{
	public int capcity;
	public Map<Integer, Integer> containMap = new HashMap<Integer, Integer>();
	public Map<Integer, HitRate> hitMap = new HashMap<Integer, HitRate>();

	public void put(int key, int value){
		Integer integer = containMap.get(key);
		if (integer==null) {
			if (containMap.size()==capcity) {
				remove();
			}
		}
		addCount(key);
		containMap.put(key, value);
		
	}
	
	public void remove() {
		//重点，为什么新造个对象，为了关联key.
		HitRate hitRate = Collections.min(hitMap.values());
		containMap.remove(hitRate.key);
		hitMap.remove(hitRate.key);
		
	}
	public void addCount(int key) {
		HitRate hitRate = hitMap.get(key);
		if(hitRate==null) {
			hitMap.put(key, new HitRate(key, 1, System.currentTimeMillis()));
		}
		else {
			hitRate.hitCount++;
			hitRate.times = System.currentTimeMillis();
		}
	}
	public int get(int key) {
		Integer value = containMap.get(key);
		if(value==null) {
			return -1;
		}
		addCount(key);
		return value.intValue();
	}
	
	class HitRate implements Comparable<HitRate>{
		public int key;
		public int hitCount;
		public long times;
		
		public HitRate(int key, int hitCount, long times) {
			// TODO Auto-generated constructor stub
			this.key = key;
			this.hitCount = hitCount;
			this.times = times;
		}
		@Override
		public int compareTo(HitRate o) {
			// TODO Auto-generated method stub
			int result = Integer.compare(this.hitCount, o.hitCount);
		    return result==0?Long.compare(this.times, o.times):result;
		}
		
	}
}


public class Test {
	public static void main(String[] args) {
		LFU cache = new LFU();
		cache.capcity = 3;
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.get(1);
        cache.put(4, 3);
        System.out.println("gggg");
        for(Map.Entry<Integer, Integer> entry: cache.containMap.entrySet()) {
        	System.out.println(entry.getKey()+", "+entry.getValue());
        }
	}
	
}
