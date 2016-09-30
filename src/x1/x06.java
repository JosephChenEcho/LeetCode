/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

/**
 *
 * @author jochen
 */
public class x06 {
    public static void main(String[] args){
        ListNode input1 = new ListNode(1);
        ListNode input2 = new ListNode(2);
        ListNode input3 = new ListNode(3);
        ListNode input4 = new ListNode(4);
        ListNode input5 = new ListNode(5);
        
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        input4.next = input5;
        
        ListNode output = rotateRight(input1,5);
        System.out.println(output.toString());
        
    
    }
    
    //61. Rotate List
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        if(k == 0) return head;
        ListNode p = head;
        ListNode target = head;
        for(int i = 0; i < k - 1; i++){
            p = p.next;
            if(p == null) p = head;
        }
        ListNode previous = new ListNode(0);
        previous.next = head;
        
        if(p.next == null) return head;
        while(p.next != null){
            p = p.next;
            target = target.next;
            previous = previous.next;
        }
        previous.next = null;
        p.next = head;
        /*while(p.next != target){
            p = p.next;
        }
        p.next = null;
        p = target;
        if(p == null) return head;
        while(p.next != null){
            p = p.next;
        }
        p.next = head;*/
        
        return target;
    }
}
