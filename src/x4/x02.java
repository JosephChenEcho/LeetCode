/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;
import java.util.*;
/**
 *
 * @author jochen
 */
public class x02 {
    public static void main(String[] args){
        //System.out.print(Integer.MAX_VALUE);
        ListNode input1 = new ListNode(1);
        ListNode input2 = new ListNode(2);
        ListNode input3 = new ListNode(3);
        ListNode input4 = new ListNode(4);
        //ListNode input5 = new ListNode(5);
        input1.next = input2;
        input2.next = input3;
        input3.next = input4;
        //input4.next = input5;
        
        System.out.println(input1.toString());
        System.out.println(oddEvenList(input1).toString());
    
    }
    //322. Coin Change
    public static int coinChange(int[] coins, int amount) {     
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 1;
    
	while(sum<=amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;
                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
            sum++;
	}
	return dp[amount];
        /*
        Arrays.sort(coins);
        int retval = coinChange(coins, amount, coins.length - 1);
        return retval;
        */
    }
    
    public static int coinChange(int[] coins, int amount, int idx){
        if(idx < 0) return -1;
        int count = 0;
        while(coins[idx] <= amount){
            count++;
            amount -= coins[idx];
        }
        if(amount == 0) return count;
        int nextcount = coinChange(coins, amount, idx - 1);
        while(nextcount == -1){
            count--;
            amount += coins[idx];
            if(count < 0) return -1;
            nextcount = coinChange(coins, amount, idx - 1);
        }
        return count + nextcount;
    }
    
    //324. Wiggle Sort II
    public void wiggleSort(int[] nums) {
        
    }
    
    //326. Power of Three
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        while( n % 3 == 0){
            n /= 3;
        }
        if(n == 1) return true;
        return false;
    }
    
    //328. Odd Even Linked List
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        odd.next = head;
        ListNode even = new ListNode(-1);
        ListNode point = even;
        while(head.next != null){
            point.next = head.next;
            point = point.next;
            head.next = head.next.next;
            if(head.next != null) head = head.next;
        }
        if(point != null) point.next = null;
        head.next = even.next;
        return odd.next;
    }
    
    //331. Verify Preorder Serialization of a Binary Tree
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
}
