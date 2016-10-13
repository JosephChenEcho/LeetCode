/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;

/**
 *
 * @author Joseph
 */
public class x02 {
    public static void main(String[] args){
    
    }
    
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int i = 0;
        int j = prices.length;
        int min = prices[i];
        int max = prices[j];
        while(i < j){
            if(prices[i] < min){
                min = prices[i];
            }
        }
        
        return 0;
    }
}
