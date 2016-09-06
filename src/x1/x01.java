/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;
import java.util.*;
import java.math.*;
/**
 *
 * @author jochen
 */
public class x01 {
    public static void main(String[] args){
        System.out.println(reverse(Integer.MIN_VALUE));
        
        
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
            int leftMedian = (nums1.length+nums2.length+1)/2;
            int rightMedian = (nums1.length+nums2.length+2)/2;
            return (helper(nums1,0,nums2,0,leftMedian)+helper(nums1,0,nums2,0,rightMedian))/2.0;
        }
        
        public static double helper(int[] nums1, int start1, int[]nums2, int start2, int topK){
            if(start1 > nums1.length-1) return nums2[start2+topK-1];
            if(start2 > nums2.length-1) return nums1[start1+topK-1];
            if(topK == 1) return Math.min(nums1[start1],nums2[start2]);
         
            if(start2+topK/2-1 > nums2.length-1) return helper(nums1,start1+topK/2,nums2,start2,topK-topK/2);
            if(start1+topK/2-1 > nums1.length-1) return helper(nums1,start1,nums2,start2+topK/2,topK-topK/2);
    
            if(nums1[start1+topK/2-1] < nums2[start2+topK/2-1]) return helper(nums1,start1+topK/2,nums2,start2,topK-topK/2);
            else return helper(nums1,start1,nums2,start2+topK/2,topK-topK/2);  
        }
    
    //5. Longest Palindromic Substring
        public static String longestPalindrome(String s){
            int start=0, end=0;
            int maxLen = 1;
            for(int i = 0; i < s.length(); i++){
                int left = i;
                int right = i;
                while(left>-1 && right<s.length() && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                if(maxLen<right-left+1){
                    maxLen = right - left + 1;
                    start = left+1;
                    end = right-1;
                }
                left = i;
                right = i+1;
                while(left>-1 && right<s.length() && s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                if(maxLen<right-left+1){
                    maxLen = right - left + 1;
                    start = left+1;
                    end = right-1;
                }              
            }
            return s.substring(start,end+1);
        }
    
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
    
    //7. Reverse Integer
    public static int reverse(int x){
        boolean isPos = x>0;
    	if(!isPos)
    		x = x* -1;
    	int ans = 0, tmp = 0;
    	while(x>0){
    	    if( (ans) > (Integer.MAX_VALUE/10)) return 0;// overflows
    	    ans = ans* 10 + x % 10;
            x /=10;
    	}
    	return isPos? ans: -1*ans;
    }
    //8. String to Integer(atoi)
    
    //9. Palindrome Number
    
    //10. Regular Expression Matching
}
