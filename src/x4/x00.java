package x4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;

/**
 *
 * @author Joseph
 */
public class x00 {
    public static void main(String[] args){
        //countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41});
        int[][] input = new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
        shortestDistance(input);
        
    }
    
    //305. Number of Islands II
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if(m <= 0 || n <= 0) return result;

        int count = 0;                      // number of islands
        int[] roots = new int[m * n];       // one island = one tree
        Arrays.fill(roots, -1);            

        for(int[] p : positions) {
            int root = n * p[0] + p[1];     // assume new point is isolated island
            roots[root] = root;             // add new island
            count++;

            for(int[] dir : dirs) {
                int x = p[0] + dir[0]; 
                int y = p[1] + dir[1];
                int nb = n * x + y;
                if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;

                int rootNb = findIsland(roots, nb);
                if(root != rootNb) {        // if neighbor is in another island
                    roots[root] = rootNb;   // union two islands 
                    root = rootNb;          // current tree root = joined tree root
                    count--;               
                }
            }

            result.add(count);
        }
        return result;
    }

    public int findIsland(int[] roots, int id) {
        while(id != roots[id]) id = roots[id];
        return id;
    }
    
    //306. Additive Number
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) return false;
        int n = num.length();
        for (int i = 1; i < n; i++) {
            if (i > 1 && num.charAt(0) == '0') break;
            for (int j = i+1; j < n; j++) {
                int first = 0, second = i, third = j;
                if (num.charAt(second) == '0' && third > second+1) break;
                while (third < n) {
                    Long result = (Long.parseLong(num.substring(first, second)) + 
                                   Long.parseLong(num.substring(second, third)) );
                    if (num.substring(third).startsWith(result.toString())) {
                        first = second; second = third; third += result.toString().length();
                    }
                    else {
                        break;
                    }
                }
                if (third == n) return true;
            }
        }
        return false;
    }
    
    //309. Best Time to Buy and Sell Stock with Cooldown
    public int maxProfit(int[] prices) {
        /*vector<int> s0(prices.size(), 0);
		vector<int> s1(prices.size(), 0);
		vector<int> s2(prices.size(), 0);
		s1[0] = -prices[0];
		s0[0] = 0;
		s2[0] = INT_MIN;
		for (int i = 1; i < prices.size(); i++) {
			s0[i] = max(s0[i - 1], s2[i - 1]);
			s1[i] = max(s1[i - 1], s0[i - 1] - prices[i]);
			s2[i] = s1[i - 1] + prices[i];
		}
		return max(s0[prices.size() - 1], s2[prices.size() - 1]);*/
        if(prices.length == 0) return 0;
        int[] s1 = new int[prices.length];
        int[] s0 = new int[prices.length];
        int[] s2 = new int[prices.length];
        s1[0] = -prices[0];
        s0[0] = 0;
        s2[0] = Integer.MIN_VALUE;
        for(int i = 1; i < prices.length; i++){
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[1] = s1[i - 1] + prices[i];            
        }
        return Math.max(s0[prices.length - 1], s2[prices.length - 1]);
        /*
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;*/
    }
    
    //310. Minimum Height Trees
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> retList = new ArrayList();
        if(n == 1) return retList;
        List<Set<Integer>> adj = new ArrayList();
        for(int i = 0; i < n; i++){
            adj.add(new HashSet());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int i = 0; i < n; i++){
            if(adj.get(i).size() == 1){
                retList.add(i);
                // get leaves
            }
        }
        while(n > 2){
            
            //remove leaves
            List<Integer> newList = new ArrayList();
            for(int i : retList){
                //leaves should be only link to one node
                int j = adj.get(i).iterator().next();
                //remove leaves on map
                adj.get(i).remove(j);
                adj.get(j).remove(i);
                //assign that node as new leaves
                if(adj.get(j).size() == 1) newList.add(j);
            }
            n -= retList.size();
            retList = newList;
        }
        return retList;
           
        /*
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;*/
    }
    
    //312. Burst Balloons
    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;
        
        int[][] dp = new int[n][n];
        for (int k = 2; k < n; k++)
            for (int left = 0; left < n - k; left++) {
                int right = left + k;
                for (int i = left + 1; i < right; i++)
                    dp[left][right] = Math.max(dp[left][right], nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }      
        return dp[0][n - 1];
    }
    
    //315. Count of Smaller Numbers After Self
    public static List<Integer> countSmaller(int[] nums) {
        /*
        26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41        
        */
        List<Integer> retList = new ArrayList();
        SumNode root = null;
        if(nums.length > 0){
            root = new SumNode();
            root.val = nums[nums.length - 1];
            retList.add(0);
        }
        for(int i = nums.length - 2; i >= 0; i--){
            retList.add(0,insert(root, nums[i]));
        }
        
        return retList;
        //26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41
        //[10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
        //[18,46,18,17,12,41,47,8,19,2,12,2,9,6,21,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
    }
    
    public static int insert(SumNode root, int val){
        int count = 0;
        SumNode point = root;
        //it's mean visit end
        while(true){
            //dup case
            if(point.val == val){
                point.dup += 1;
                count += point.count;
                break;
            }
            else if(val < point.val){
                point.count += 1;
                if(point.smaller == null) break;
                point = point.smaller;
            }else{
                count += point.count + point.dup;
                if(point.larger == null) break;
                point = point.larger;
            }
        }
        if(val < point.val){
            point.smaller = new SumNode();
            point.smaller.val = val;
        }
        if(val > point.val){
            point.larger = new SumNode();
            point.larger.val = val;
        }
        return count;
    }
    
    //317. Shortest Distance from All Buildings
  
    public static int shortestDistance(int[][] grid) {
        int wid = grid.length;
        int len = grid[0].length;
        int[][] distance = new int[wid][len];
        int retdis = 0;
        for(int i = 0; i < wid; i++){
            for(int j = 0; j < len; j++){
                if(grid[i][j] == 1){
                    Queue<int[]> pq = new LinkedList();
                    pq.add(new int[]{i,j});
                    boolean[][] visited = new boolean[wid][len];
                    retdis = bfsshortdis(grid, distance, pq, visited);
                }
            }
        }               
        return retdis;
    }
    
    public static int bfsshortdis(int[][] grid, int[][] distance, Queue<int[]> pq, boolean[][] visited){
        int mindix = Integer.MAX_VALUE;
        int len = grid.length;
        int wid = grid[0].length;
        while(!pq.isEmpty()){
            int[] pre = pq.poll();
            int i = pre[0];
            int j = pre[1];
            int predis = distance[i][j];
            int a = bfshelper(grid, distance, pq, visited, i + 1, j, predis + 1);
            int b = bfshelper(grid, distance, pq, visited, i - 1, j, predis + 1);
            int c = bfshelper(grid, distance, pq, visited, i, j + 1, predis + 1);
            int d = bfshelper(grid, distance, pq, visited, i, j - 1, predis + 1);
            int minval = Math.min(Math.min(a, b), Math.min(c, d));
            mindix = Math.min(minval, mindix);
        }        
        return mindix;
    }
    
    public static int bfshelper(int[][] grid, int[][] distance, Queue<int[]> pq, boolean[][] visited, int i, int j, int dis){
        int len = grid.length;
        int wid = grid[0].length;
        if(i < 0 || i == len || j < 0 || j == wid) return Integer.MAX_VALUE;
        if(grid[i][j] != 0) return Integer.MAX_VALUE;
        if(visited[i][j]) return Integer.MAX_VALUE;
        
        distance[i][j] += dis;
        visited[i][j] = true;
        pq.add(new int[]{i,j});
        
        return distance[i][j];
    }
    
    

    
    //318. Maximum Product of Word Lengths
    public int maxProduct(String[] words) {
        int[] checker = new int[words.length];
        int max = 0;
        // populating the checker array with their respective numbers
        for (int i = 0; i < checker.length; i++) {
            int num = 0;
            for (int j = 0; j < words[i].length(); j++) {
                num |= 1 << (words[i].charAt(j) - 'a');
            }
            checker[i] = num;
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((checker[i] & checker[j]) == 0) //checking if the two strings have common character
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
        /*
        int max = 0;
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                if(isnotShare(words[i],words[j])){
                    max = Math.max(words[i].length() * words[j].length(),max);
                }
            }
        }
        
        return max;
        */
    }
    
    public boolean isnotShare(String a, String b){
        for(char c : a.toCharArray()){
            if(b.indexOf(c)>=0) return false;
        }
        return true;
    }
    
    //319. Bulb Switcher
    public static int bulbSwitch(int n) {
        /*boolean[] light = new boolean[n];
        int i = 1;
        while(i <= n){
            int ii = i;
            while(ii <= n){
                light[ii - 1] = !light[ii - 1];
                ii += i;
            }
            i++;
        } 
        int count = 0;
        for(boolean b : light){
            if(b) count++;
        }
        return count;*/
        return (int)Math.sqrt(n);
    }
}
