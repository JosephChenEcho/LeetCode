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
        //[2,4,3] [5,6,4]
        ListNode a = new ListNode(2);
        ListNode b2 = a.next;
        ListNode a1 = new ListNode(4);
        a.next = a1;
        a1.next = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode b1 = new ListNode(6);
        b.next = b1;
        b1.next = new ListNode(4);
        
        a = new ListNode(1);
        a.next = new ListNode(8);
        b = new ListNode(0);
        
        addTwoNumbers(b,a);
        
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
}
