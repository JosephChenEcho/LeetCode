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
        return -1;
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
}
