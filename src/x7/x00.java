/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x7;

/**
 *
 * @author jochen
 */
public class x00 {
    public static void main(String args[]){
    
    }
    
    //617. Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        if(t1 == null && t2 != null){
            return t2;
        }
        if(t1 != null && t2 == null){
            return t1;
        }
        TreeNode retNode = new TreeNode(t1.val + t2.val);
        retNode.left = mergeTrees(t1.left,t2.left);
        retNode.right = mergeTrees(t1.right,t2.right);
        return retNode;
    }
}
