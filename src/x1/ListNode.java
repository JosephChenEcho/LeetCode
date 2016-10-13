/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

/**
 *      ListNode input1 = new ListNode(1);
        ListNode input2 = new ListNode(2);
        ListNode input3 = new ListNode(3);
        ListNode input4 = new ListNode(4);
        ListNode input5 = new ListNode(5);
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        input4.next = input5;
 * @author jochen
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
    
    public String toString(){
        String retstr = "";
        ListNode current = this;
        while(current != null){
            retstr += current.val + "\t";
            current = current.next;
        }
        return retstr;
    }
}
