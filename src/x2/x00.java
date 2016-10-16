/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;

import java.util.*;

/**
 * Unsolved Hard:
 * 115, 117
 * @author jochen
 */
public class x00 {
    public static void main(String args[]){
        TreeNode input = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode left2 = new TreeNode(3);
        TreeNode left3 = new TreeNode(4);
        TreeNode right1 = new TreeNode(2);
        TreeNode right2 = new TreeNode(4);
        TreeNode right3 = new TreeNode(3);
        input.left = left1;
        input.right = right1;
        //left1.left = left2;
        left1.right = left3;
        right1.left = right2;
        //right1.right = right3;
        System.out.println(isSymmetric(input));
    
    }
    
    //101. Symmetric Tree
    public static boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false; 
        
        return isMirror(root.left, root.right);
    }
    
    public static boolean isMirror(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val) && isMirror(right.left, left.right) && isMirror(right.right, left.left);
    }
}
