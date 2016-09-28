/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;
//import java.math.*;

/**Unsolved Hard:
 * 41, 42, 44, 45, 51, 52, 56, 67 
 * @author Joseph
 */
public class x04 {
    public static void main(String[] args){
        List<List<Integer>> input = new ArrayList();
        int[] testinput = {1,2,3};
        input = permute(testinput);
        
        for(int i = 0; i < input.size(); i++){
            System.out.print("Set " + i +": ");
            for(int ii : input.get(i)){
                System.out.print(ii+",");
            }
            System.out.println();
        }
    }
    
    //43. Multiply Strings
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    //46. Permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retlist = new ArrayList<>();
        List<Integer> numlist = new ArrayList();
        for(int i : nums){
            numlist.add(i);
        }                     
        return permuteSet(retlist, numlist);
    }
    
    public static List<List<Integer>> permuteSet(List<List<Integer>> inlist, List<Integer> innums){
        List<List<Integer>> outlist = new ArrayList();
        if (innums.size() == 0) return inlist;
        if (inlist.size() == 0){
            for(int i = 0; i < innums.size(); i++){
                List<Integer> outnums = new ArrayList(innums);
                List<Integer> tmplist = new ArrayList();
                tmplist.add(innums.get(i));
                outnums.remove(i);
                List<List<Integer>> tlist = new ArrayList();
                tlist.add(tmplist);
                outlist.addAll(permuteSet( tlist,outnums));
            }     
            return outlist;
        }
        for(List<Integer> al : inlist){
            for(int i = 0; i < innums.size(); i++){
                List<Integer> outnums = new ArrayList(innums);
                List<Integer> tmplist = new ArrayList(al);
                tmplist.add(innums.get(i));
                outnums.remove(i);
                List<List<Integer>> tlist = new ArrayList();
                tlist.add(tmplist);
                outlist.addAll(permuteSet(tlist ,outnums));
            }
        }
        return outlist;
    }
    
    //51. N-Queens
    public static List<List<String>> solveNQueens(int n) {
        String[] board = new String[n];
        return null;
    }

}
