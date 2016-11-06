/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;

import java.util.*;

/**
 *
 * @author Joseph
 */

//173. Binary Search Tree Iterator
public class BSTIterator {
    
    private Stack<TreeNode> tStk = new Stack();

    
    public BSTIterator(TreeNode root) {
        while(root != null){
            tStk.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !tStk.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = tStk.pop();
        if(cur.right != null){
            TreeNode tmp = cur.right;
            while(tmp != null){
                tStk.push(tmp);
                tmp = tmp.left;
            }
        }
        return cur.val;
    }
    

}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
