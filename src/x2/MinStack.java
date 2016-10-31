/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;
import java.util.*;
//155. Min Stack
/**
 *
 * @author jochen
 */
public class MinStack {
    /** initialize your data structure here. */
    Node head;    
    public MinStack(){}
    
    public void push(int x) {
        if(head == null){
            head = new Node(x);
        }else{
            Node tmp = new Node(x);
            tmp.min = Math.min(head.min, x);
            tmp.next = head;
            head = tmp;
        }
    }
    
    public void pop() {
        if(head != null){            
            head = head.next;
        }
    }
    
    public int top() {
        if(head == null) return Integer.MIN_VALUE;
        return head.value;
    }
    
    public int getMin() {
        if(head == null) return Integer.MIN_VALUE;
        return head.min;
    }
}
class Node{
    int value;
    int min;
    Node next;
    Node(int x){
        value=x;
        next=null;
        min=x;
    }
}