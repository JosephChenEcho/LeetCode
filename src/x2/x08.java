/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class x08 {
    public static void main(String[] args){
        int[] input = new int[]{1,2};
        rotate(input,1);
        for(int i : input){
            System.out.println(i);
        }
    }
    
    //187. Repeated DNA Sequences
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        final int subLen = 10;
        if( s==null || s.length() <= 10) {
            return result;
        }

        //Define a memo to store each 10 letter-long sub-strings.
        Set<String> set = new HashSet<String>();
        Set<String> dupSet = new HashSet<String>();

        char[] chars = s.toCharArray();

        String str;
        for(int i=0; i<= chars.length-subLen; i++){
            str = new String(chars, i, subLen);
            if(set.contains(str)) {
                dupSet.add(str);
            } else{
                set.add(str);
            }
        }

        result.addAll(dupSet);

        return result;
    }
    
    //189. Rotate Array
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;
        rotate(0, nums.length - k - 1, nums);
        rotate(nums.length - k, nums.length - 1, nums);
        rotate(0, nums.length - 1, nums);
    }
    
    public static void rotate(int start, int end, int[] nums){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
