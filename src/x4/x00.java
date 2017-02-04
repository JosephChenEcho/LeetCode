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
        //10
        int[][] input = new int[][]{{0,1},{0,2},{0,3},{2,4},{0,5},{5,6},{6,7},{2,8},{7,9}};
        findMinHeightTrees(10,input);
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
        if(prices.length <= 1) return 0;
        int[] dp = new int[prices.length + 1];
        
        
        return -1;
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
}
