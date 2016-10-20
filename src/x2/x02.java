/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;

/**Unsolved Hard: 123, 124, 126, 128, 132, 135, 138, 140
 * 
 *
 * @author Joseph
 */
public class x02 {
    public static void main(String[] args){
    
    }
    
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length <= 1) return max;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min) min = prices[i];
            if(prices[i] - min > max) max = prices[i] - min;
        }        
        return max;
    }
    
    //122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {
        int max = 0;
        boolean buy = false;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length - 1; i++){
            if(!buy && prices[i] < prices[i + 1]){
                //buy stock
                buyPrice = prices[i];
                buy = true;
                continue;
            }
            if(buy && prices[i] > prices[i + 1]){
                max += prices[i] - buyPrice;
                buy = false;
            }
        } 
        if(buy && prices[prices.length - 1] > buyPrice){
            max += prices[prices.length - 1] - buyPrice;
        }
        return max;
    }
    
    //125. Valid Palindrome
    public boolean isPalindrome(String s) {
        char[] carr = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            while(i <= j && !isalphanumeric(carr[i])) i++;
            while(i <= j && !isalphanumeric(carr[j])) j--;
            if(carr[i] != carr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isalphanumeric(char c){
        return (c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')||(c >= '0' && c <= '9');
    }
}
