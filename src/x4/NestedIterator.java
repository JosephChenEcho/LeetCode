/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;

import java.util.*;

/**
 *
 * @author Joseph
 */

//341. Flatten Nested List Iterator
public class NestedIterator implements Iterator<Integer> {
    public Stack<NestedInteger> nIntStack = new Stack();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--){
            nIntStack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return nIntStack.peek().isInteger() ? nIntStack.pop().getInteger() : null;
    }

    @Override
    public boolean hasNext() {
        while(!nIntStack.isEmpty()){
            NestedInteger cur = nIntStack.peek();
            if(cur.isInteger()){
                return true;
            }
            nIntStack.pop();
            for(int i = cur.getList().size() - 1; i >= 0; i--){
                nIntStack.push(cur.getList().get(i));
            }
        }
        return false;
    }
}


