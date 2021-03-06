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
        
        reorderList(input1);
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
    
    //143. Reorder List
    //L0→Ln→L1→Ln-1→L2→Ln-2→…
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        // now slow is the mid, reverse from slow->next to end

        ListNode prev = null;
        ListNode curt = slow.next;
        // break the connection
        slow.next = null;
        
        while (curt != null) {
            ListNode temp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = temp;
        }
        
        // Ln starts from prev, L0 starts from head
        curt = new ListNode(-1);
        ListNode temp = head;
        
        while(prev != null) {
            curt.next = temp;
            temp = temp.next;
            curt = curt.next;
            curt.next = prev;
            prev = prev.next;
            curt = curt.next;
        }
        
        if (temp != null) {
            curt.next = temp;
        }

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
    
    //148
    
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
    
    //152. Maximum Product Subarray
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] numMax = new int[nums.length];
        int[] numMin = new int[nums.length];
        numMax[0] = nums[0];
        numMin[0] = nums[0];
        int maxValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == 0){
                numMax[i] = 1;
                numMin[i] = 1;
                maxValue = maxValue < 0? 0 : maxValue;
            }else
            {
                numMax[i] = numMax[i-1] * nums[i] > numMin[i-1] * nums[i] ? (numMax[i-1] * nums[i] > nums[i] ? numMax[i-1] * nums[i] : nums[i]):(numMin[i-1] * nums[i] > nums[i] ? numMin[i-1] * nums[i]: nums[i]);
                numMin[i] = numMax[i-1] * nums[i] < numMin[i-1] * nums[i] ? (numMax[i-1] * nums[i] < nums[i] ? numMax[i-1] * nums[i] : nums[i]):(numMin[i-1] * nums[i] < nums[i] ? numMin[i-1] * nums[i]: nums[i]);
                maxValue = maxValue > numMax[i] ? maxValue : numMax[i];
            }
        }                    
        return maxValue;
    }
    
    //153. Find Minimum in Rotated Sorted Array
    public int findMin(int[] nums) {
        return binarySearch(0, nums.length-1, nums);
    }

    private int binarySearch(int start, int end, int[] nums){
        if(start == end) return nums[start];   
        if(nums[start] < nums[end]) return nums[start]; // the subarray is sorted
        int mid = start + ((end-start)/2);
        if(nums[start] < nums[mid] || mid == start){
           return binarySearch(mid +1, end, nums);
        }
        return binarySearch(start, mid, nums);
    } 
    
    //155. Min Stack
    
    //156. Binary Tree Upside Down
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
        return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
    
    //160. Intersection of Two Linked Lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;    
        ListNode a = headA;
        ListNode b = headB;    
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;    
        }    
        return a;
    }
}
