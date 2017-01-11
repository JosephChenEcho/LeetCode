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
    public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
            return -1;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    return -1;
	}

	@Override
	public boolean hasNext() {
            return false;
        }	    
}
