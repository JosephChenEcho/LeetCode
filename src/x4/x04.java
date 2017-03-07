/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;

/**
 *
 * @author Joseph
 */
public class x04 {
    
    public static void main(String[] args){
    
    }
    //341. Flatten Nested List Iterator

    //343. Integer Break
    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++){
            int maxp = 0;
            int j = 1;
            while(j <= i - j){
                maxp = Math.max(maxp, dp[j] * dp[i - j]);                
                j++;
            }
            dp[i] = maxp;
        }
        return dp[n];
    }
    
}

