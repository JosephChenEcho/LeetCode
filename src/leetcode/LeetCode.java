/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author jochen
 */
public class LeetCode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    for(int x = 0; x < matrix.length; x++){
                        if(matrix[x][j] != 0) matrix[x][j] = Integer.MIN_VALUE;
                    }
                    for(int x = 0; x < matrix[0].length; x++){
                        if(matrix[i][x] != 0) matrix[i][x] = Integer.MIN_VALUE;
                    }
                }
            }
        }      
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == Integer.MIN_VALUE){
                    matrix[i][j] = 0;
                }
            }
        } 
        
    }
    
}
