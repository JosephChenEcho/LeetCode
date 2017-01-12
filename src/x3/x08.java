/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;

/**
 *
 * @author jochen
 */
public class x08 {
    public static void main(String[] args){
        int[][] input = {{1,1},{1,0}};
        gameOfLife(input);
        for(int[] ai : input){
            for(int i : ai){
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }
    
    //283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while(i < len){
            while(i < len && nums[i] == 0){
                i++;
            }
            if(i == len) break;
            nums[j] = nums[i];
            j++;
            i++;
        }
        while(j < len){
            nums[j] = 0;
            j++;
        }
    }
    
    //289. Game of Life
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dieOrLive(i, j, board, m, n);
            }
        }        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] /= 2;
            }
        }    
    }
    
    public static void dieOrLive(int i, int j, int[][] board, int m, int n){
        int count = 0;
        if(board[i][j] == 1){
            if(i > 0 && board[i-1][j]%2 == 1) count++;
            if(i < m - 1 && board[i+1][j]%2 == 1) count++;
            if(j > 0 && board[i][j-1]%2 == 1) count++;
            if(j < n - 1 && board[i][j+1]%2 == 1) count++;
            if(i > 0 && j > 0 && board[i-1][j-1]%2 == 1) count++;
            if(i > 0 && j < n - 1 && board[i-1][j+1]%2 == 1) count++;
            if(i < m - 1 && j > 0 && board[i+1][j-1]%2 == 1) count++;
            if(i < m - 1 && j < n - 1 && board[i+1][j+1]%2 == 1) count++;
            if(count == 2 || count == 3) board[i][j] += 2;
        }else{
            if(i > 0 && board[i-1][j]%2 == 1) count++;
            if(i < m - 1 && board[i+1][j]%2 == 1) count++;
            if(j > 0 && board[i][j-1]%2 == 1) count++;
            if(j < n - 1 && board[i][j+1]%2 == 1) count++;
            if(i > 0 && j > 0 && board[i-1][j-1]%2 == 1) count++;
            if(i > 0 && j < n - 1 && board[i-1][j+1]%2 == 1) count++;
            if(i < m - 1 && j > 0 && board[i+1][j-1]%2 == 1) count++;
            if(i < m - 1 && j < n - 1 && board[i+1][j+1]%2 == 1) count++;
            if(count == 3) board[i][j] = 2;
        }
    }
}
