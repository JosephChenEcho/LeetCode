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
        ListNode input2 = new ListNode(4);
        ListNode input3 = new ListNode(3);
        ListNode input4 = new ListNode(2);
        ListNode input5 = new ListNode(5);
        ListNode input6 = new ListNode(2);
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        input4.next = input5;
        input5.next = input6;
        System.out.println(input1.toString());
        System.out.println(partition(input1,3));
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
    
    //86. Partition List
    public static ListNode partition(ListNode head, int x) {         
        ListNode current = head;
        ListNode before = new ListNode(-1);
        ListNode befcur = before;
        ListNode after = new ListNode(-1);
        ListNode aftcur = after;
        while(current != null){
            if(current.val < x){
                befcur.next = current;
                befcur =befcur.next;
            }else{
                aftcur.next = current;
                aftcur = aftcur.next;
            }            
            current = current.next;
        }
        aftcur.next = null;
        befcur.next = after.next;
        
        return before.next;
    }       
}
