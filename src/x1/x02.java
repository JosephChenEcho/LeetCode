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
