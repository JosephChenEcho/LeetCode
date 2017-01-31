/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;

/**
 *
 * @author jochen
 */
//304. Range Sum Query 2D - Immutable
public class NumMatrix {
    private int[][] nummat;
    public NumMatrix(int[][] matrix) {
        this.nummat = matrix;
        for(int i = 1; i < nummat.length; i++){
            nummat[i][0] += nummat[i-1][0];
        }
        for(int i = 1; i < nummat[0].length; i++){
            nummat[0][i] += nummat[0][i+1];
        }
        for(int i = 1; i < nummat.length; i++){
            for(int j = 1; j < nummat[0].length; j++){
                nummat[i][j] += nummat[i-1][j] + nummat[i][j-1] - nummat[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int iMin = Math.min(row1, row2);
        int iMax = Math.max(row1, row2);    
        int jMin = Math.min(col1, col2);
        int jMax = Math.max(col1, col2);
        int res = nummat[iMax][jMax];
        if(iMin != 0){res -= nummat[iMin - 1][jMax];}
        if(jMin != 0){res -= nummat[iMax][jMin - 1];}
        if(iMin !=0 && jMin !=0){res += nummat[iMin-1][jMin-1];}
        
        return res;
    }
    /*
    private int[][] sumRegion;

    public NumMatrix(int[][] matrix) {
        if (matrix.length != 0)  sumRegion = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                sumRegion[i + 1][j + 1] = sum + sumRegion[i][j + 1]; 
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion[row2 + 1][col2 + 1] - sumRegion[row1][col2 + 1] - sumRegion[row2 + 1][col1] + sumRegion[row1][col1];
    }
    */
}
