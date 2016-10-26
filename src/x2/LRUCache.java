/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;
import java.util.*;

//146. LRU Cache
/**
 *
 * @author jochen
 */
public class LRUCache {
    int cap;
    HashMap<Integer, Integer> cacheMap = new HashMap();
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cacheMap = new HashMap();
    }
    
    public int get(int key) {
        return 0;
    }
    
    public void set(int key, int value) {
        this.cacheMap.put(key, value);
    }
}
