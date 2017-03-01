/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;
import java.util.*;
/**
 *
 * @author jochen
 */
//362. Design Hit Counter
public class HitCounter {
    
    List<Integer> timeStamp;
    List<Integer> times;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        timeStamp = new ArrayList();
        times = new ArrayList();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(timeStamp.isEmpty() || timeStamp.get(timeStamp.size() - 1) != timestamp){
            int pre = times.isEmpty() ? 0 : times.get(times.size() - 1);
            timeStamp.add(timestamp);
            times.add(pre + 1);
        }else{
             times.set(times.size() - 1, times.get(times.size() - 1) + 1);
        }
        
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int start = timestamp - 300;
        int endamount = 0;
        int i = 0;
        for(; i < timeStamp.size(); i++){
            if(timeStamp.get(i) > timestamp){
                endamount = times.get(i - 1);
                break;
            }
        }
        if(!timeStamp.isEmpty() && i == timeStamp.size()){
            endamount = times.get(times.size() - 1);
        }
        if(start <= 0) return endamount;
        int startamount = 0;
        for(i = i - 1; i >= 0; i--){
            if(timeStamp.get(i) <= start){
                startamount = times.get(i);
                break;
            }
        }
        return endamount - startamount;
    }
}
