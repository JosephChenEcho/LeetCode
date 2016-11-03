/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;

import java.util.*;

/** UnSolved Hard:
 * 164, 174
 * @author jochen
 */
public class x06 {
    public static void main(String[] args){
        System.out.println(convertToTitle(52));
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
    
    //167. Two Sum II - Input array is sorted
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum > target){ right--;}
            else if(sum < target){ left++;}
            else{
                ret[0] = left + 1;
                ret[1] = right + 1;
                return ret;
            }
        }        
        return ret;
    }
    
    //168. Excel Sheet Column Title
    public static String convertToTitle(int n) {
        //A-65
        if(n < 27){
            char c = (char)(n + 64);
            return String.valueOf(c);
        }else{
            int pre = (n-1)/26;
            int post = n - pre*26;
            return convertToTitle(pre) + convertToTitle(post);
        }        
    }
}

