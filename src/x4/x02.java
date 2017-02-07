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
        int[] input = {1,3,7,5,4};
        Arrays.sort(input);
        for(int i : input){
            System.out.println(i);
        }
    
    }
    //322. Coin Change
    public int coinChange(int[] coins, int amount) {     
        Arrays.sort(coins);
        
        return -1;
    }
    
    public int coinChange(int[] coins, int amount, int idx){
        if(coins[0] > amount) return -1;
        if(coins[idx] == amount) return 1;
        return 0;
    }
}
