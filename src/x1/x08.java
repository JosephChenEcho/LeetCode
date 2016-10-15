/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;

/**
 * Unsolved Hard:
 * 84, 85, 87, 97, 99
 * @author jochen
 */
public class x08 {
    public static void main(String[] args){
        generateTrees(2);
        /*ListNode input1 = new ListNode(1);
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
        System.out.println(output.toString());*/
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
    public static List<String> restoreIpAddresses(String s) {
        /*List<String> retlist = new ArrayList();
        String[] strip = new String[4];
        parseIpAddresses(retlist, s, strip, 0);
        return retlist;*/
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 0; i < 3 && i + 3 < s.length(); i++) {
            String a = s.substring(0, i + 1);
            if(!valid(a)) continue;
            
            for(int j = i + 1; j < i + 4 && j < s.length(); j++) {
                String b = s.substring(i + 1, j + 1);
                if(!valid(b)) continue;
                
                for(int k = j + 1; k < j + 4 && k < s.length() && s.length() - k - 1 > 0; k++) {
                    String c = s.substring(j + 1, k + 1);
                    if(!valid(c)) continue;
                    
                    String d = s.substring(k + 1, s.length());
                    if(!valid(d)) continue;
                    
                    res.add(a + "." + b + "." + c + "." + d);
                }
            }
        }
        
        return res;
    }
    
    private static boolean valid(String s) {
        if(s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        
        if(s.length() > 3) {
            return false;
        }
        return Integer.parseInt(s) < 256;
    }
    
    public static void parseIpAddresses(List<String> retlist, String s, String[] strip, int idx){
        if(idx < 4 && s.length() == 0) return;
        if(idx == 4 && s.length() > 0) return;
        if(idx == 4 && s.length() == 0){
            String outstr = strip[0] + "." + strip[1] + "." + strip[2] + "." + strip[3];
            retlist.add(outstr);
        }        

        if(s.length() >= 1){
            int iip = Integer.parseInt(s.substring(0,1));
            String[] outstrip = strip.clone();
            if(iip >= 0 && iip <= 9){
                outstrip[idx] = String.valueOf(iip);
                parseIpAddresses(retlist, s.substring(1), outstrip, idx + 1);
            }
        }
        
        if(s.length() >= 2){
            int iip = Integer.parseInt(s.substring(0,2));
            String[] outstrip = strip.clone();
            if(iip >= 10 && iip <= 99){
                outstrip[idx] = String.valueOf(iip);
                parseIpAddresses(retlist, s.substring(2), outstrip, idx + 1);
            }
        }
        
        if(s.length() >= 3){
            int iip = Integer.parseInt(s.substring(0,3));
            String[] outstrip = strip.clone();
            if(iip >= 100 && iip <= 255){
                outstrip[idx] = String.valueOf(iip);
                parseIpAddresses(retlist, s.substring(3), outstrip, idx + 1);
            }
        }
    }
    
    //94. Binary Tree Inorder Traversal
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> retlist = new ArrayList();
        if(root == null) return retlist;
        retlist.addAll(inorderTraversal(root.left));
        retlist.add(root.val);
        retlist.addAll(inorderTraversal(root.right));      
        
        return retlist;
    }
    
    //95. Unique Binary Search Trees II
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode> retlist = new ArrayList();
        
        retlist.add(new TreeNode(1));        
        int i = 2;
        while(i <= n){
            List<TreeNode> tmp = new ArrayList();
                for(TreeNode t : retlist){
                    tmp.addAll(generateTrees(t, i));
                }
                retlist = tmp;                     
            i++;
        }        
        return retlist;
    }
    
    public static List<TreeNode> generateTrees(TreeNode tree, int i){
        List<TreeNode> retlist = new ArrayList();
        // Set i as top
        TreeNode addTree = new TreeNode(i);
        addTree.left = tree;
        retlist.add(addTree);
        // Insert i into left or right root
        addTree = tree;
        TreeNode current = addTree;
        while(current != null){
            TreeNode tmp = current.right;
            current.right = new TreeNode(i);
            current.right.left = tmp;
            TreeNode tmpaddTree = addTree;
            retlist.add(tmpaddTree);
            //roll back;
            current.right = tmp;
            current = current.right;
        }
        return retlist;
    }
    
    //96. Unique Binary Search Trees
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
        
        }        
        return dp[n];
    }
    
    //98
    
    //100
}
