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
//284. Peeking Iterator
public class PeekingIterator implements Iterator<Integer>{
    
    private Iterator<Integer> iter = null;
    private Integer next = null;
    
    public PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        if(iter.hasNext()){
            next = iter.next();
        }            
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
            Integer retnext = next;
            next = iter.hasNext() ? iter.next() : null;
	    return retnext;
	}

	@Override
	public boolean hasNext() {
            return next != null;
        }	    
}
