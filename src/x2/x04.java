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
        reverseWords("This is a red apple");
        /*ListNode input1 = new ListNode(5);
        ListNode input2 = new ListNode(4);
        ListNode input3 = new ListNode(2);
        ListNode input4 = new ListNode(3);
        ListNode input5 = new ListNode(1);
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        input4.next = input5;
        
        System.out.println(insertionSortList(input1).toString());*/
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
    
    //142. Linked List Cycle II
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;   // no circle
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {  // circle detected
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        //return null; // no circle
        //System.out.println("Here");
        return null;
    }
    
    //144. Binary Tree Preorder Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList();
        if(root == null) return retlist;
        
        retlist.add(root.val);
        retlist.addAll(preorderTraversal(root.left));
        retlist.addAll(preorderTraversal(root.right));
        return retlist;
    }
    
    //147. Insertion Sort List
    public static ListNode insertionSortList(ListNode head) {
        if(head == null) return null;
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode point = prehead.next;
        while(point.next != null){
            if(point.val > point.next.val){
                //Insert Sort
                ListNode pre = prehead;
                while(pre.next.val < point.next.val){
                    pre = pre.next;
                }
                ListNode post = pre.next;
                ListNode tail = point.next.next;
                //insert point.next into pre and post
                pre.next = point.next;
                pre.next.next = post;                
                //add tail after point
                point.next = tail;
            }else{
                point = point.next;
            }
        }
        
        return prehead.next;
    }
    
    //150. Evaluate Reverse Polish Notation
    /*  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6*/    
    public int evalRPN(String[] tokens) {
        Stack<Integer> istack = new Stack();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int sec = istack.pop();
                int fir = istack.pop();
                int tmp = fir + sec;
                istack.push(tmp);
            
            }else if(tokens[i].equals("-")){
                int sec = istack.pop();
                int fir = istack.pop();
                int tmp = fir - sec;
                istack.push(tmp);
            }else if(tokens[i].equals("*")){
                int sec = istack.pop();
                int fir = istack.pop();
                int tmp = fir * sec;
                istack.push(tmp);
            }else if(tokens[i].equals("/")){
                int sec = istack.pop();
                int fir = istack.pop();
                int tmp = fir / sec;
                istack.push(tmp);
            }else{
                int tmp = Integer.parseInt(tokens[i]);
                istack.push(tmp);
            }
        }        
        return istack.pop();
    }
    
    //151. Reverse Words in a String
    public static String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        int end = words.length - 1;
        for(int i = 0; i<= end; i++){
            if(!words[i].isEmpty()) {
                sb.insert(0, words[i]);
                if(i < end) sb.insert(0, " ");
            }
        }
        return sb.toString();
    }
}
