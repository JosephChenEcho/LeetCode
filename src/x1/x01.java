/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;
import java.util.*;
/**
 *
 * @author jochen
 */
public class x01 {
    public static void main(String[] args){
        int[] input = {4,5,6,8,9};
        System.out.println(lengthOfLongestSubstring("aaaabcdaaa"));
        
        
    }
    
    //1.Two Sum
    public static int[] twoSum(int[] nums, int target){
        int[] ret = new int[2];
        /*for(int i = 0; i < nums.length; i++){
            int next = target - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == next){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        */
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i){
                ret[0] = map.get(nums[i]);
                ret[1] = i;
                return ret;
            }
            map.put(target - nums[i], i);
        }
        
        return ret;
    }
    
    //2.Add Two Numbers
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode retnode = l1;
        ListNode prev = null;
        while(l1 != null || l2 != null){
            if(l1 == null){
                l1 = new ListNode(0);
                prev.next = l1;
            }
            if(l2 == null){
                l2 = new ListNode(0);
            }
            l1.val += l2.val;
            if(l1.val > 9){
                l1.val -= 10;
                if(l1.next == null){
                    l1.next = new ListNode(1);
                }
                else{
                    l1.next.val += 1;
                }
            }
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        return retnode;       
    }
    
    //3. Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {    
        int ret = 0;
        char[] chararray = s.toCharArray();
        int start = -1;
        HashMap<Character,Integer> check = new HashMap<Character,Integer>();
        for(int i=0;i<chararray.length;i++){
            char current = chararray[i];
            if(check.containsKey(current)){
                start = Math.max(start, check.get(current));
            }
            ret = Math.max(i-start, ret);
            check.put(current, i);
        }
        return ret;
    }
    
    //4. Median of Two Sorted Arrays Unsolved
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null && nums2 == null) return 0;
        
        double res = 0.00;
        int m = nums1.length;
        int n = nums2.length;
        int i = 0,j = 0;
        int count = 0;
        if((m + n) % 2 == 1){
            while(count == (m + n) % 2){
                if(nums1[i] < nums2[j]){
                    i++;
                    count++;
                }
                else{
                    j++;
                    count++;
                }
            }                    
        }
        
        return res;    
    }
    
    //5. Longest Palindromic Substring
    
    //6. ZigZag Conversion
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int offset = 2 * numRows - 2;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j*offset + i < s.length(); j ++) {
                result.append(s.charAt(j*offset + i));
                if (i != 0 && i != numRows - 1 && (j+1)*offset - i < s.length()) result.append(s.charAt((j+1)*offset - i));
            }
        }
        return result.toString();
    }
}
