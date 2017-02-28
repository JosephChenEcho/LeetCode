/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;

import java.util.*;

/**
 *
 * @author Joseph
 */
public class x06 {
    public static void main(String[] args){
        validTree(4,new int[][]{{0,1},{2,3},{1,2}});
        /*4
[[0,1],[2,3],[1,2]]*/
    }
    
    //261. Graph Valid Tree
    public static boolean validTree(int n, int[][] edges) {
        if(n == 1 && edges.length == 0) return true;
        if(n == 1 || edges.length == 0) return false;
        if(n - 1 != edges.length) return false;
        List<int[]> edgeList = new ArrayList();
        for(int[] ia : edges) edgeList.add(ia);
        boolean[] visited = new boolean[n];
        int start = edgeList.get(0)[0];
        int end = edgeList.get(0)[1];
        visited[start] = true;
        visited[end] = true;
        edgeList.remove(0);
        int i = 0;
        
        while(!edgeList.isEmpty()){
            start = edgeList.get(i)[0];
            end = edgeList.get(i)[1];
            if(visited[start] && visited[end]) return false;
            if(visited[start] || visited[end]){
                visited[start] = true;
                visited[end] = true;
                edgeList.remove(i);
            }else{
                i++;
                
            }
            if(i == edgeList.size()) i = 0;
        }
        
        return true;
    }
    
    boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;        
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i);            
            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }        
        return false;
    }

    
    //263. Ugly Number
    public boolean isUgly(int num) {
        while(num%2==0&&num!=0){
            num /=2;
        }
        while(num%3==0&&num!=0){
            num /=3;
        }
        while(num%5==0&&num!=0){
            num /=5;
        }
        if(num == 1) return true; 
        return false;
    }
    
    //264. Ugly Number II
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
    
    //266. Palindrome Permutation
    public boolean canPermutePalindrome(String s) {
        Set<Character>set = new HashSet<Character>();
	for (char c : s.toCharArray())  
		if (set.contains(c)) set.remove(c);// If char already exists in set, then remove it from set
		else set.add(c);// If char doesn't exists in set, then add it to set
	return set.size() <= 1;
        
    }
    
    //268. Missing Number
    public int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;
            
        return (nums.length * (nums.length + 1) )/ 2 - sum;
    }
    
    //274. H-Index
    public int hIndex(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }        
        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;

        for (int i = length; i >= 0; i--) {
            t += array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
    
    //275. H-Index II
    public int hIndex2(int[] citations) {
        int left=0;
        int len = citations.length;
        int right= len-1;
        int mid;
        while(left<=right)
        {
            mid=left+ (right-left)/2;
            if(citations[mid] >= (len-mid)) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;
    }
    
    //278. First Bad Version
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while(left < right){
            int mid = (left + right)/2;
            if(true){
                right = mid;
            }else{
                left = mid;
            }                    
        }
        return -1;
    }
    
    //279. Perfect Squares
    public int numSquares(int n) {
        /*if(n == 0) return 0;
        if(n == 1) return 1;
        int res = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i++){
            int ans = numSquares(n - i*i) + 1;
            if(res > ans) res = ans;
        }
        return res;*/
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                min = Math.min(1 + dp[i - j * j],min);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
