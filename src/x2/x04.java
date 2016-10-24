/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;
import java.util.*;

/**Unsolved Hard:
 * 145, 146, 149, 154, 158, 159 
 *
 * @author jochen
 */
public class x04 {
    public static void main(String args[]){
        ListNode input1 = new ListNode(1);
        ListNode input2 = new ListNode(2);
        ListNode input3 = new ListNode(3);
        ListNode input4 = new ListNode(4);
        ListNode input5 = new ListNode(5);
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        input4.next = input5;
        input5.next = input2;
        hasCycle(input1);
    }
    
    //141. Linked List Cycle
    public static boolean hasCycle(ListNode head) {
        if(head==null)return false;
        while(head.next!=null && head.next!=head){
            ListNode tmp=head.next;
            head.next=head.next.next;
            head=tmp;
        }
        return head.next!=null;
    }
}
