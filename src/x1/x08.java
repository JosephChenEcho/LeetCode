/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;

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
        ListNode input5 = new ListNode(3);
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        input4.next = input5;
        System.out.println(input1.toString());
        ListNode output = deleteDuplicates2(input1);
        System.out.println(output.toString());
    }
    
    //81. Search in Rotated Sorted Array II
    public static boolean search(int[] nums, int target) {
        /*Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(nums[mid] == target) return true;
            if(target < nums[mid]) end = mid - 1;
            if(target > nums[mid]) start = mid + 1;
        }
        return false;
        */
 
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start]) end = mid;
                else start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start]) start = mid + 1;
                else end = mid;
            } else { // have no idea about the array, but we can exclude nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }
    
    //82. Remove Duplicates from Sorted List II
    public static ListNode deleteDuplicates2(ListNode head) {
        /*ListNode retlist = new ListNode(-1);
        retlist.next = head;
        ListNode current = retlist;
        
        while(current.next != null){
            boolean removeFlag = false;            
            while(current.next.next != null && current.next.next.val == current.next.val){
                current.next.next = current.next.next.next;
                removeFlag = true;
            }
            if(removeFlag){
                current.next = current.next.next;
            }
            if(current.next != null) current = current.next;            
        }        
        return retlist.next;*/
        if(head==null) return null;
        ListNode retlist = new ListNode(-1);
        retlist.next=head;
        ListNode pre=retlist;
        ListNode cur=retlist.next;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return retlist.next;
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
    
    //88. Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while(k >= 0){
            if(j < 0 || (i >= 0 && nums1[i] > nums2[j])){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }       
            k--;
        }
    }
    
    //89. Gray Code
    public static List<Integer> grayCode(int n) {
        /*List<Integer> retal = new ArrayList();
        if(n == 0){
            retal.add(0);
            return retal;
        }
        List<Integer> tmp = grayCode(n - 1);
        List<Integer> revtmp = new ArrayList();
        int add = (int)Math.pow(2, n - 1);
        for(int i = tmp.size() - 1; i >=0; i--){
            revtmp.add(add + tmp.get(i));
        }
        tmp.addAll(revtmp);
        return tmp;*/
        List<Integer> retlist = new ArrayList();
        retlist.add(0);
        for(int i = 0; i < n; i++){
            int add = (int)Math.pow(2, i);
            for(int j = retlist.size() - 1; j >=0; j--){
                retlist.add(add + retlist.get(j));
            }
        }
        return retlist;         
    }
    
    //90. Subsets II
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retlist = new ArrayList();
        Arrays.sort(nums);
        List<Integer> empty = new ArrayList();
        retlist.add(empty);
        int last = 0;
        for(int i = 0; i < nums.length; i++){
            int start = 0;
            if(i != 0 && nums[i] == nums[i-1]){
                start = retlist.size() - last;
            }
            List<List<Integer>> tmp = new ArrayList();      
            for(int j = start; j < retlist.size(); j++){
                List<Integer> tmpal = new ArrayList(retlist.get(j));
                tmpal.add(nums[i]);
                tmp.add(tmpal);
            }           
            last = tmp.size();
            retlist.addAll(tmp);
        }        
        return retlist;
    }
    
    //91. Decode Ways
    public static int numDecodings(String s) {
        int n = s.length();
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        if(s.charAt(0) - '0' == 0){
            dp[1] = 0;
        }
        for(int i = 2; i <= n; i++){
            int oneDigit = Integer.parseInt(s.substring(i-1,i));
            int twoDigit = Integer.parseInt(s.substring(i-2,i));
            if(oneDigit != 0){
                dp[i] += dp[i-1];
            }
            if(twoDigit >= 10 && twoDigit <=26){
                dp[i] += dp[i-2];
            }
        }        
        return dp[n];
    }
    
    //92. Reverse Linked List II
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        /*ListNode retlist = new ListNode(-1);
        retlist.next = head;
        ListNode current = retlist;        
        int i = 1;
        while(i < m){
            current = current.next;
            i++;
        }
        ListNode beforem = current;
        
        ListNode tmplist = new ListNode(-1);
        current = tmplist;
        int end = n;
        ListNode aftern = getNode(head,end + 1);
        while(n + 1 > m){
            current.next = getNode(head, n);
            current = current.next;
            n--;
        }
        current.next = aftern;
        beforem.next = tmplist.next;
        
        
        return retlist.next;*/
        if(head == null) return head;
        ListNode fake_head = new ListNode(0);
        fake_head.next = head;
        
        //move to the start point
        ListNode pre = fake_head;
        for(int i = 0; i < m - 1; i ++){
            pre = pre.next;
        }
        
        //do the reverse
        ListNode cur = pre.next;
        ListNode new_head = null;
        for(int i = 0; i <= n - m; i ++){
            ListNode next = cur.next;
            cur.next = new_head;
            new_head = cur;
            cur = next;
        }
        
        //reconnect
        pre.next.next = cur;
        pre.next = new_head;
        
        return fake_head.next;
    }
    
    public static ListNode getNode(ListNode head, int n){
        ListNode tmp = head;
        while(n > 1){
            tmp = tmp.next;
            n--;
        }
        return tmp;
    }
    
    //93. Restore IP Addresses
    public List<String> restoreIpAddresses(String s) {
        return null;
    }
}
