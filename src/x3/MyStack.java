/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;
import java.util.*;
/**
 *
 * @author Joseph
 */
//225. Implement Stack using Queues
public class MyStack {
    // Push element x onto stack.
    Queue qstk ;
    public MyStack(){
        qstk = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        qstk.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i = 0; i < qstk.size() - 1; i++){
            qstk.add(qstk.poll());
        }
        qstk.poll();
    }

    // Get the top element.
    public int top() {
        for(int i = 0; i < qstk.size() - 1; i++){
            qstk.add(qstk.poll());
        }
        int ret = (int)qstk.poll();
        qstk.add(ret);
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return qstk.isEmpty();
    }
}
