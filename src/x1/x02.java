/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class x02 {
    
    public static void main(String[] args){
        divide(-2147483648,-1);
    }
    
    //21 Merge Two Sorted Lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        return null;        
    }
    
    //29 Divide Two Integers
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;
        
        long result = 0;
        while(ldividend >= ldivisor){
            long subSum = ldivisor;
            long count = 1;
            while(subSum + subSum <= ldividend){
                subSum += subSum;
                count += count;
            }
            ldividend -= subSum;
            result += count;
        }
        
        return (int)result * sign;
    }
    
    //36 Valid Sudoku
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> nums = new HashSet<Character>();
        for(int i=0;i<9;i++){
            nums.clear();
            for(int j=0;j<9;j++){
                if (board[i][j]!='.'){           
                    if (!nums.add(board[i][j])) return false;
                }
            }
        }
        
        for(int i=0;i<9;i++){
            nums.clear();
            for(int j=0;j<9;j++){
                if (board[j][i]!='.'){           
                    if (!nums.add(board[j][i])) return false;
                }
            }
        }
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                nums.clear();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        if (board[3*i+k][3*j+l]!='.'){           
                            if (!nums.add(board[3*i+k][3*j+l])) return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
