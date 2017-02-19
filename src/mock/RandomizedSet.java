/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class RandomizedSet {

    /** Initialize your data structure here. */
   private HashMap<Integer, Integer> randmap = new HashMap(); // key = random number, value = idx
   private List<Integer> randlist = new ArrayList();
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(randmap.containsKey(val)) return false;
        int idx = randlist.size();
        randlist.add(val);
        randmap.put(val,idx);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!randmap.containsKey(val)) return false;
        int idx = randmap.get(val);
        int lastidx = randlist.size() - 1;
        int lastval = randlist.get(lastidx);
        
        if(lastidx == idx){
            randlist.remove(idx);
            randmap.remove(val);
        }
        
//remove from List
        randlist.set(idx,lastval);
        randlist.remove(lastidx);
//remove from map
	randmap.put(lastval,idx);
              randmap.remove(val);

        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        java.util.Random rand = new java.util.Random();
         int randidx = rand.nextInt(randlist.size());
         return randlist.get(randidx);
    }
}
