/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;
//import java.math.*;

/**Unsolved Hard:
 * 41, 42, 44, 45, 52(Can improve), 56, 67 
 * Solved 51
 * @author Joseph
 */
public class x04 {
    public static void main(String[] args){
        int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(input);
        for(int[] ai : input){
            for(int i : ai){
                System.out.print(i + "\t");
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
    
    //48. Rotate Image
    public static void rotate(int[][] matrix) {
        //if len =6 mid: 3/3
        //if len = 7 mid 4/3
        int limitx = (matrix.length + 1)/2;
        int limity = matrix.length - limitx;
        int lefttopx = 0;
        int lefttopy = 0;
        int righttopx = matrix.length - 1;
        int righttopy = 0;
        int leftbottomx = 0;
        int leftbottomy = matrix.length - 1;
        int rightbottomx = matrix.length - 1;
        int rightbottomy = matrix.length - 1;
        
        for(int i = 0; i < limitx; i++){
            for(int j = 0; j < limity; j++){
                int tmp = matrix[lefttopx + i][lefttopy + j];
                matrix[lefttopx + i][lefttopy + j] = matrix[righttopx - j][righttopy + i];
                matrix[righttopx - j][righttopy + i] = matrix[rightbottomx - i][rightbottomy - j];
                matrix[rightbottomx - i][rightbottomy - j] = matrix[leftbottomx + j][leftbottomy - i];
                matrix[leftbottomx + j][leftbottomy - i] = tmp;
            }
        }
    }
    
    public void rotateByPoint(int[][] matrix){
    
    }
    
    //51. N-Queens
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> retlist = new ArrayList();        
        int[] board = new int[n];
        nQueenHelper(retlist, board, 0);        
        return retlist;
    }
    
    public static Boolean nQueenHelper(List<List<String>> retlist, int[] inboard,int idx){
        if(idx >= inboard.length){
            /*System.out.print("Solution : ");
            for(int i : inboard){
                System.out.print(i + ",");
            }
            System.out.println();*/
            List<String> solutionlist = new ArrayList();
            for(int iq : inboard){
                char[] cstr = new char[inboard.length];
                for(int i = 0; i < cstr.length; i++){
                    cstr[i] = '.';                    
                }
                cstr[iq] = 'Q';
                solutionlist.add(String.valueOf(cstr));
            }
            retlist.add(solutionlist);
            return true;
        }
        
        for(int i = 0; i < inboard.length; i++){
            int[] outboard = inboard.clone();
            outboard[idx] = i;
            if(validBoard(outboard,idx)){
                nQueenHelper(retlist,outboard,idx + 1);
            }
        }
        
        return false;
    }
    
    public static Boolean validBoard(int[] board, int idx){
        for(int i = 0; i < idx; i++){
            if(board[i] == board[idx]) return false;
            if(Math.abs(board[i] - board[idx]) == (idx - i) ) return false;
        }        
        return true;
    }
    
    //52. N-Queens II
    public static int totalNQueens(int n) {        
        List<List<String>> retlist = new ArrayList();        
        int[] board = new int[n];
        nQueenHelper(retlist, board, 0);        
        return retlist.size();
    }
    
    

}
