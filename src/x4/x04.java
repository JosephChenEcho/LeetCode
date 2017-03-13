/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;
import java.util.*;
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
    
    //347. Top K Frequent Elements
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        List<Integer> retList = new ArrayList();
        HashMap<Integer, Integer> iMap = new HashMap<Integer,Integer>();
        for(int i : nums){
            if(iMap.containsKey(i)){
                iMap.put(i, iMap.get(i) + 1);
            }else{
                iMap.put(i, 1);
            }
        }
        int[][] sortarr = new int[iMap.size()][];
        int i = 0;
        for(Map.Entry<Integer,Integer> e : iMap.entrySet()){
            sortarr[i++] = new int[]{e.getKey(), e.getValue()};
        }
        Comparator<int[]> c = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        };
        Arrays.sort(sortarr,c);
        int start = sortarr.length - k;
        if(start < 0) start = 0;
        for(; start < sortarr.length; start++){
            retList.add(sortarr[start][0]);
        }        
        return retList;*/
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        // corner case: if there is only one number in nums, we need the bucket has index 1.
        List<Integer>[] bucket = new List[nums.length+1];
        for(int n:map.keySet()){
            int freq = map.get(n);
            if(bucket[freq]==null)
                bucket[freq] = new LinkedList<>();
            bucket[freq].add(n);
        }
        
        List<Integer> res = new LinkedList<>();
        for(int i=bucket.length-1; i>0 && k>0; --i){
            if(bucket[i]!=null){
                List<Integer> list = bucket[i]; 
                res.addAll(list);
                k-= list.size();
            }
        }
        
        return res;
    }
    
}

