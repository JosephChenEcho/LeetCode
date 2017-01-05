/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;

import java.util.Arrays;

/**
 *
 * @author Joseph
 */
public class x06 {
    public static void main(String[] args){
            
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
        return -1;
    }
}
