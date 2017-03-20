/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;
import java.util.*;
/**
 *
 * @author jochen
 */
//251. Flatten 2D Vector
public class Vector2D implements Iterator<Integer> {
    public Queue<List<Integer>> lq = new LinkedList();
    public Queue<Integer> cur = new LinkedList();
    public Vector2D(List<List<Integer>> vec2d) {
        for(List<Integer> l : vec2d){
            lq.offer(l);
        }
        for(Integer i : lq.poll()){
            cur.offer(i);
        }
    }

    @Override
    public Integer next() {
        return cur.poll();
    }

    @Override
    public boolean hasNext() {
        if(!cur.isEmpty()){
            return true;
        }
        while(cur.isEmpty()){
            if(lq.isEmpty()) return false;
            for(Integer i : lq.poll()){
            cur.offer(i);
            }
        }
        return true;
    }
}
