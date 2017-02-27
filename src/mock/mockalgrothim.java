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
        subsets(new int[]{1,2,3});
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
