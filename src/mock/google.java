/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;

/**
 *
 * @author jochen
 */
public class google {
    
    //color : 1 - while 2 - black
    public int capturego(int[][] board, int color){
        int target = color == 1 ? 2 : 1;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 2){
                    
                }
            }
        }               
        return -1;
    }
    
    public int[] findgroup(int[][] board, int[][] visited){
        int[] ret = new int[2]; //[count,liberty]
        return null;
    }
}
