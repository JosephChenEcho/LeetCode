/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;

/**
 *
 * @author Joseph
 */
public class x02 {
    public static void main(String[] args){
        computeArea(0,0,0,0,-1,-1,1,1);
    }
    //221. Maximal Square
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }
    
    //222. Count Complete Tree Nodes
    public int countNodes(TreeNode root) {
        return -1;
    }
    
    //223. Rectangle Area
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        //get left and right
        int left = A < E ? E : A;
        int right = C < G ? C : G;
     
        //get bottom and top
        int bottom = B < F ? F : B;
        int top = D < H ? D : H;
        int cover = (right - left) * (top - bottom);
        if(bottom >= top || left >= right) cover = 0;
        return (G - E) * (H - F) + (C - A) * (D - B) - cover;
    }
    
    //225. Implement Stack using Queues
    
    //226. Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        TreeNode rleft = invertTree(root.right);
        TreeNode rright = invertTree(root.left);
        root.left = rleft;
        root.right = rright;
        return root;
    }
    
    //232. Implement Queue using Stacks
}
