/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class TwoSum {
    HashMap<Integer,Integer> sumMap;
    /** Initialize your data structure here. */
    public TwoSum() {
        sumMap = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        sumMap.put(number, sumMap.containsKey(number) ? sumMap.get(number)+ 1 : 0);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> e : sumMap.entrySet()){
            int i = e.getKey();
            int j = value - i;
            if((i == j && e.getValue() > 0) ||(i != j && sumMap.containsKey(j))){
                return true;
            }
        }
        return false;        
    }
}
