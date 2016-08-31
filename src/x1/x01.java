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
        System.out.println(convert("PAYPALISHIRINGfsafasfdasfasfdsafasfsdfasf", 5));
        //convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
        
        
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
    public int lengthOfLongestSubstring(String s) {    
        return 0;
    }
    
    //4. Median of Two Sorted Arrays
    
    //5. Longest Palindromic Substring
    
    //6. ZigZag Conversion
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int x = numRows;
        int y = s.length()*2 / (2*numRows - 2) + 1;
        int[][] map = new int[y][x];
        Boolean reverse = false;
        
        for(int i = 0, index = 0; i < chars.length; index++){
            if(reverse){
                for(int j = numRows - 2; j > 0; j--){
                    map[index][j] = i + 1;
                    i++;
                }            
            }
            else{
                for(int j = 0; j < numRows; j++){
                    map[index][j] = i + 1;
                    i++;
                }
            }
            reverse = !reverse;
            
        }
        
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }
        
        return null;
    }
}
