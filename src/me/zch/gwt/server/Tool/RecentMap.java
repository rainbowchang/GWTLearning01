package me.zch.gwt.server.Tool;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecentMap<K, V> extends LinkedHashMap<K,V>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1429531548899369783L;

	private int count = 0;
	
	public RecentMap(int count){
		super(count);
		this.count = count;
		if(count <=0){
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public V put(K key, V value) {
		if(this.containsKey(key)){
			this.remove(key);
		}else{ // !this.containsKey(key)
			if(this.size() >= count){
				Iterator<K> ik = super.keySet().iterator();
				K k = null;
				if(ik.hasNext()){
					k = ik.next();
				}
				this.remove(k);
			}else{
				// do nothing
			} 
		}
		return super.put(key, value);
	}
	
	/**
	 * Do nothing in RecentMap.
	 */
	@Override
	@Deprecated
	public void putAll(Map<? extends K, ? extends V> m) {
		
	}
	
}
