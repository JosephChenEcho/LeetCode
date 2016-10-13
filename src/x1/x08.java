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
        List<List<Integer>> output = subsetsWithDup(new int[]{1,2,2});
        for(List<Integer> al : output){
            for(int i : al){
                System.out.print(i + ",");
            }
            System.out.println();
        }
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
}
