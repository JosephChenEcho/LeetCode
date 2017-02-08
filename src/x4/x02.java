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
        int[] input = {2,3,4};
        System.out.println(coinChange(input,1));
    
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
}
