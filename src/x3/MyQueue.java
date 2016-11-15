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
//232. Implement Queue using Stacks
public class MyQueue {
    Stack sque;
    public MyQueue(){
        sque = new Stack<Integer>();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
        sque.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        Stack tmp = new Stack<Integer>();
        while(!sque.isEmpty()){
            tmp.push(sque.pop());
        }
        tmp.pop();
        while(!tmp.isEmpty()){
            sque.push(tmp.pop());
        }
    }

    // Get the front element.
    public int peek() {
        Stack tmp = new Stack<Integer>();
        while(!sque.isEmpty()){
            tmp.push(sque.pop());
        }
        int retint = (int)tmp.peek();
        while(!tmp.isEmpty()){
            sque.push(tmp.pop());
        }
        return retint;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return sque.isEmpty();
    }
}
