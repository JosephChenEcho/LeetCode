/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class x02 {
    
    public static void main(String[] args){
        int[] input = {1,2,4,3};
        nextPermutation(input);
    }
    
    //21 Merge Two Sorted Lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode retlist = null;
        ListNode curl1 = l1;
        ListNode curl2 = l2;
        ListNode current = null;
        
        while(curl1 == null && curl2 == null){
            ListNode temp = null;
            if(curl1.val > curl2.val){
                temp.val = curl1.val;
                curl1 = curl1.next;
            }
            else{
                temp.val = curl2.val;
                curl2 = curl2.next;
            }
            
            if(retlist == null){
                retlist = temp;
                current = retlist;
            }
            else{
                current.next = temp;
                current = current.next;
            }
        }
        
        if(curl1 == null) current.next = curl2;
        if(curl2 == null) current.next = curl1;
        
        return retlist;        
    }
    
    //22. Generate Parentheses 
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public static void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            System.out.println(str);
            return;
        }
        
        if(open < max){
            backtrack(list, str+"(", open+1, close, max);
            
        }            
        if(close < open){
            backtrack(list, str+")", open, close+1, max);
            
        }
    }
    
    //24 Swap nodes in pairs
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node1 = head;
        ListNode node2;
        ListNode temp;
        ListNode pre = null;
        while(node1 != null){
            node2 = node1.next;
            if(node2 == null) return head;
            temp = node2.next;
            node2.next = node1;
            node1.next = temp;
            if(pre != null){
                pre.next = node2;
            }else{
                head = node2;
            }
            pre = node1;
            node1 = pre.next;
        }
        return head;
    }
    
    //26. Remove Duplicates from Sorted Array    
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        int j = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[j] = nums[i];
                j++;
            }
        }
        
        return j;
    }
    
    //27. Remove Element
    public static int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }        
        return j;
    }
    
    //28. Implement strStr()
    public static int strStr(String haystack, String needle) {
        //if(haystack.length() == 0) return -1;
        if(needle.length() == 0) return 0;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++){
            int j = 0;
            int k = i;
            while(j < needle.length() && haystack.charAt(k) == needle.charAt(j)){
                k++;
                j++;
            }
            if(j == needle.length()) return i;
        }
        
        return -1;
    }
    
    //29 Divide Two Integers
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;
        
        long result = 0;
        while(ldividend >= ldivisor){
            long subSum = ldivisor;
            long count = 1;
            while(subSum + subSum <= ldividend){
                subSum += subSum;
                count += count;
            }
            ldividend -= subSum;
            result += count;
        }
        
        return (int)result * sign;
    }
    
    //31. Next Permutation
    public static void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int i = nums.length - 1;

        for(; i > 0; i--){
            if(nums[i] > nums[i - 1]) break;
        }

        int right = nums.length - 1;
        int left = i;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
        if (i != 0) {
            int j = i;
            while (nums[i - 1] >= nums[j]) {
                ++j;
            }
            swap(nums, i - 1, j);
        }
    }
    
    public static void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    //34. Search for a Range
    public int[] searchRange(int[] nums, int target) {
        int lt = 0;
        int gt = nums.length - 1;
        while(lt <= gt) {
            int mid = (lt+gt)/2;
            if (target < nums[mid]) gt = mid - 1;
            else if (nums[mid] < target) lt = mid + 1;
            else {
                lt = gt = mid;
                while(lt > 0 && nums[lt-1] == nums[mid]) lt--;
                while(gt < nums.length - 1 && nums[gt + 1] == nums[mid]) gt++;
                return new int[]{lt, gt};
            }
        }
        return new int[]{-1, -1};
    }
    
    //36 Valid Sudoku
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> nums = new HashSet<Character>();
        for(int i=0;i<9;i++){
            nums.clear();
            for(int j=0;j<9;j++){
                if (board[i][j]!='.'){           
                    if (!nums.add(board[i][j])) return false;
                }
            }
        }
        
        for(int i=0;i<9;i++){
            nums.clear();
            for(int j=0;j<9;j++){
                if (board[j][i]!='.'){           
                    if (!nums.add(board[j][i])) return false;
                }
            }
        }
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                nums.clear();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        if (board[3*i+k][3*j+l]!='.'){           
                            if (!nums.add(board[3*i+k][3*j+l])) return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
