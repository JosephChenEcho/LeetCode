/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x6;
import java.util.*;
/**
 *
 * @author jochen
 */
public class x00 {
    public static void main(String[] args){
    
    }
    
    //515. Find Largest Value in Each Tree Row
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        List<Integer> retList = new ArrayList<>();
        while(!bfs.isEmpty()){
            int max = Integer.MIN_VALUE;
            int size = bfs.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = bfs.poll();
                max = Math.max(max, tmp.val);
                if(tmp.left != null) bfs.add(tmp.left);
                if(tmp.right != null) bfs.add(tmp.right);
            }
            retList.add(max);
        }
        
        
        return retList;
    }
    
    //516. Longest Palindromic Subsequence
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
        }
        
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = 1;
            for(int j = i - 1; j > 0; j--){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j + 1]);
                }                
            }
        }
        
        return dp[s.length() - 1][0];
        
        
    }
}
