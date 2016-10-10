/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

/**
 * Unsolved Hard:
 * 84, 85, 97, 99
 * @author jochen
 */
public class x08 {
    public static void main(String[] args){
        ListNode input1 = new ListNode(1);
        ListNode input2 = new ListNode(1);
        ListNode input3 = new ListNode(2);
        ListNode input4 = new ListNode(2);
        ListNode input5 = new ListNode(2);
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        input4.next = input5;
        System.out.println(input1.toString());
        System.out.println(deleteDuplicates(input1).toString());
    }
    
    //81. Search in Rotated Sorted Array II
    public boolean search(int[] nums, int target) {
        return false;
    }
    
    //82. Remove Duplicates from Sorted List II
    public ListNode deleteDuplicates2(ListNode head) {
        return null;
    }
    
    //83. Remove Duplicates from Sorted List
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode current = head;
        while(current != null && current.next != null){
            while(current.next != null && current.val == current.next.val){
                current.next = current.next.next;
            }        
            current = current.next;
        }        
        return head;
    }
}
