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
public class x06 {
    
    public static void main(String args[]){
        
    }
    
    //373. Find K Pairs with Smallest Sums
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
    
    //377. Combination Sum IV
    public static int combinationSum4(int[] nums, int target) {
        if(nums.length == 0 || target == 0) return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0; i < dp.length; i++){
            for(int ii : nums){
                if(i + ii < dp.length){
                    dp[i + ii] += dp[i];
                }
            }
        }        
        return dp[target];
    }
    
    //380. Insert Delete GetRandom O(1)
}
