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
public class x06 {
    public static void main(String[] args){
        int[][] input = {{0,1}};
        uniquePathsWithObstacles(input);
        //System.out.println(uniquePaths(23,12));
    }
    
    //61. Rotate List
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        ListNode last = head;
        while(last.next != null){
            last = last.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode previous = new ListNode(0);
        previous.next = head;
        ListNode target = head;
        for(int i = 0; i < len - k; i++){
            previous = previous.next;
            target = target.next;
        }
        previous.next = null;
        last.next = head;
               
        return target;
    }
    
    //62. Unique Paths
    public static int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];        
        return uniquePaths(m - 1,n - 1, map);
    }
    
    public static int uniquePaths(int m, int n, int[][] map) {
        if (m == 0 || n == 0) return 1;
        if (map[m][n] == 0) map[m][n] = uniquePaths(m - 1, n, map) + uniquePaths(m, n - 1, map);
        return map[m][n];
    }
    
    //63. Unique Paths II
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0][0]==1) return 0;
        final int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        int init = 1;
        for(int i=n-1; i>=0; i--){
            if(obstacleGrid[i][m-1]==1)
                init = 0;
            dp[i][m-1] = init;
        }
        init = 1;
        for(int j=m-1; j>=0; j--){
            if(obstacleGrid[n-1][j]==1)
                init = 0;
            dp[n-1][j] = init;
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                if(obstacleGrid[i][j]==0)
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    
    //66. Plus One
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1;i>=0;i--){
            digits[i] += carry;
            if(digits[i] > 9){
                carry = digits[i]/10;
                digits[i] %= 10;
            }
            else{
                return digits;
            }
        }
        int[] retarr = new int[digits.length+1];
        int[] cararr = new int[1];
        cararr[0] = carry;
        System.arraycopy(cararr, 0, retarr, 0, 1);
        System.arraycopy(digits, 0, retarr, 1, digits.length);
        
        return retarr;
    }
    //73. Set Matrix Zeroes
    public void setZeroes(int[][] matrix){
        if(matrix == null) return;
        HashSet<Integer> col = new HashSet();
        HashSet<Integer> row = new HashSet();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    col.add(i);
                    row.add(j);
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(col.contains(i) || row.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
