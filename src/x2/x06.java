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
}

