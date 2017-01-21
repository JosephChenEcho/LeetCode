/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.*;
/**
 *
 * @author jochen
 */
public class LeetCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int[][] input = new int[][]{{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        //isRectangleCover(input);
        //int[][] input = new int[][]{{1,-3,3},{0,-2,0},{-3,-3,-3}};
        //calculateMinimumHP(input);
        int[] input = new int[]{1,11,5,5};
        System.out.println(dividedBy2(input));
        //System.out.println(maxProfit2(input));
        //System.out.println(maxProfit(3,input));
        
    }
    
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    for(int x = 0; x < matrix.length; x++){
                        if(matrix[x][j] != 0) matrix[x][j] = Integer.MIN_VALUE;
                    }
                    for(int x = 0; x < matrix[0].length; x++){
                        if(matrix[i][x] != 0) matrix[i][x] = Integer.MIN_VALUE;
                    }
                }
            }
        }      
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == Integer.MIN_VALUE){
                    matrix[i][j] = 0;
                }
            }
        } 
        
    }
    
    public static List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    public static void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; ++j)
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
                    remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') // finished left to right
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        else // finished right to left
            ans.add(reversed);
    }
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map=new HashMap<Character,Character>();
        if(s.length()!=t.length()){return false;}
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                if(!map.get(s.charAt(i)).equals(t.charAt(i)))return false;
            }
            else{
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
    
    public static boolean isRectangleCover(int[][] rectangles) {
        int imax = 0;
        int imin = Integer.MAX_VALUE;
        int jmax = 0;
        int jmin = Integer.MAX_VALUE;
        int mapsize = 0;
        HashMap<Integer,HashSet<Integer>> map = new HashMap();
        for(int[] rec : rectangles){
            for(int i = rec[0]; i < rec[2];i++){
                imax = Math.max(imax, i);
                imin = Math.min(imin, i);
                for(int j = rec[1]; j < rec[3]; j++){
                    jmax = Math.max(jmax, j);
                    jmin = Math.min(jmin, j);
                    if(map.containsKey(i)){
                        if(!map.get(i).add(j)) return false;
                    }else{
                        map.put(i, new HashSet());
                        map.get(i).add(j);
                    }
                    mapsize++;
                }
            }
        }
        if(mapsize != (jmax - jmin + 1)*(imax - imin + 1)) return false;
        return true;
    }
    
    //Burst Balloons
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;
        
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }      
        return dp[0][n - 1];
    }
    
    public static int bestShot(List<Integer> nums){
        int score = 0;
        int ballon = 0;
        if(nums.size() == 1){
            score = nums.get(0);
            nums.clear();
            return score;
        }               
        for(int i = 0; i < nums.size(); i++){
            int tmpScore = 0;
            if(i == 0){
                tmpScore = nums.get(0) * nums.get(1);
            }else if(i == nums.size() - 1){
                tmpScore = nums.get(i-1) * nums.get(i);
            }else{
                tmpScore = nums.get(i-1) * nums.get(i) * nums.get(i+1);
            }
            if(tmpScore > score){
                score = tmpScore;
                ballon = i;
            }else if(tmpScore == score && nums.get(i) < nums.get(ballon)){
                ballon = i;
            }
        }
        nums.remove(ballon);
        
        return score;
    }
    //Dungeon Game
    public static int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length ==0) return 0;    
        int row=dungeon.length;
        int col=dungeon[0].length;    
        for(int i=row-1; i>=0; i--) {        
            for(int j=col-1; j>=0; j--) {            
                if(i==row-1 && j==col-1) dungeon[i][j]=Math.max(1, 1-dungeon[i][j]);
                else if(i==row-1) dungeon[i][j]=Math.max(1, dungeon[i][j+1]-dungeon[i][j]);
                else if(j==col-1) dungeon[i][j]=Math.max(1, dungeon[i+1][j]-dungeon[i][j]);
                else dungeon[i][j]=Math.max(1, Math.min(dungeon[i+1][j], dungeon[i][j+1])-dungeon[i][j]);
            }
        }        
        return dungeon[0][0];
    }   
    
    public static int maxProfit2(int[] prices) {
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
    
    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n <= 1) return 0;
        
        
        /*int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                    localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
                    System.out.print(localMax+"\t");
            }
            System.out.println();
        }
        //{10,12,21,4,6,78,9,91,34,45,27};
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[i].length; j++){
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[k][n-1];*/
        if (k >=  n/2) {
		int maxPro = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i-1])
				maxPro += prices[i] - prices[i-1];
		}
		return maxPro;
	}
        int[] dp = new int[n];
        int trans =  0;
        while(trans < k){
            int localMax = -prices[0];
            for(int i = 1; i < n; i++){
                int tmp = Math.max(localMax, dp[i] - prices[i]);
                dp[i] = Math.max(dp[i - 1], prices[i] + localMax);
                localMax = tmp;
            }    
            
            trans++;
        }
        return dp[n - 1];
    }
    
    public static boolean dividedBy2(int[] input){
        int sum = 0;
        for(int i : input){
            sum += i;
        }
        if(sum % 2 == 1) return false;
        int target = sum/2;
        
        return isSubsetSum (input, 0, target);
    }
    
    public static boolean isSubsetSum (int[] nums, int n, int sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == nums.length - 1 && sum != 0)
            return false;
 
        // If next element is greater than sum, then ignore it
        if (nums[n+1] > sum)
            return isSubsetSum (nums, n+1, sum);
 

        return isSubsetSum (nums, n+1, sum) ||
               isSubsetSum (nums, n+1, sum-nums[n+1]);
    }
}


