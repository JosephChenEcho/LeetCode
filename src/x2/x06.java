/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;

/** UnSolved Hard:
 * 164, 174
 * @author jochen
 */
public class x06 {
    public static void main(String[] args){
        compareVersion("1","0");
    }
    //162. Find Peak Element
    public int findPeakElement(int[] nums) {
         return findPeak(nums, 0, nums.length-1);
    }
    
    public int findPeak(int[] nums, int begin, int end){
        if(begin == end) return begin;
        int mid = (begin + end)/2;
        if(nums[mid] < nums[mid + 1]){
            return findPeak(nums, mid + 1, end);
        }else{
            return findPeak(nums, begin, mid);
        }
    }    
    
    //165. Compare Version Numbers
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int max = Math.max(v1.length, v2.length);       
        for(int i = 0; i < max; i++){
            int i1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int i2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if(i1 > i2) return 1;
            if(i1 < i2) return -1;
        }
        return 0;
    }
}

