/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

/**
 *
 * @author jochen
 */
public class x01 {
    public static void main(String[] args){
        System.out.println();
        int[] nums = {3,2,4};
        twoSum(nums,6);
    }
    
    //1.Two Sum
    public static int[] twoSum(int[] nums, int target){
        int[] ret = new int[2];
        for(int i = 0; i < nums.length; i++){
            int next = target - nums[i];
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] == next){
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        
        return ret;
    }
}
