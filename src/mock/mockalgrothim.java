/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import java.util.*;
/**
 *
 * @author jochen
 */
public class mockalgrothim {
    public static void main(String[] args){
        //subsets(new int[]{1,2,3});
        System.out.println(canDivided(new int[]{1,4,7,6,4,2,1,2,3,4,6,4}));
    }
    
    public static boolean canDivided(int[] input){
        int sum = 0;
        for(int i : input){
            sum += i;
        }
        System.out.println(sum);
        if(sum % 2 == 1) return false;
        
        return reachtarget(input, 0, 0, sum/2);
    }
    
    public static boolean reachtarget(int[] input, int sum, int idx, int target){
        if(sum == target) return true;
        if(idx == input.length) return false;
        for(int i = idx; i < input.length; i++){
            int nextsum = sum + input[i];
            if(reachtarget(input, nextsum, i + 1, target)){ 
                System.out.println(input[i]);
                return true;}            
        }
        return false;
    }
    
    //78. Subsets
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retList = new ArrayList();
        subsethelper(retList,new ArrayList(), nums, -1);
        return retList;
    }
    
    public static void subsethelper(List<List<Integer>> retList, List<Integer> cur, int[] nums, int idx){
        retList.add(new ArrayList(cur));
        for(int i = idx + 1; i < nums.length; i++){
            cur.add(nums[i]);
            subsethelper(retList, cur, nums, i);
            cur.remove(cur.size() - 1);
        }
    }
    
    //Pow(x, n)
    public double myPow(double x, int n) {

        if(n == 1) return x;
        if(n == -1) return 1/x;
        if(n == 0) return 1;
        double res = 1.00;
        int divid = n / 2;
        int mod = n % 2;
        res = myPow(x, divid);
        res *= res;
        if(mod == 1) res *= x;
        if(mod == -1) res /= x;
        return res;
    }
}
