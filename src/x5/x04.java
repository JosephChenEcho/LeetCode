/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x5;
import java.util.*;
/**
 *
 * @author jochen
 */
public class x04 {
    public static void main(String[] args){}
    
    //442. Find All Duplicates in an Array
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> retList = new ArrayList<Integer>();
        HashSet<Integer> intSet = new HashSet<Integer>();
        for(int i : nums){
            if(!intSet.add(i)){
                retList.add(i);
            }
        }
        return retList;
    }
    
    //450. Delete Node in a BST
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
        return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}

