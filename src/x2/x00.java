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
    
    //102. Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList();
        if(root == null) return retList;
        List<List<TreeNode>> treeList = new ArrayList();
        List<TreeNode> initTree = new ArrayList();
        initTree.add(root);
        treeList.add(initTree);
        while(treeList.size() > retList.size()){
            List<TreeNode> tmpTreeList = new ArrayList();
            List<Integer> tmpIntList = new ArrayList();
            for(TreeNode t : treeList.get(treeList.size() - 1)){
                tmpIntList.add(t.val);
                if(t.left != null) tmpTreeList.add(t.left);
                if(t.right != null) tmpTreeList.add(t.right);
            }
            if(!tmpIntList.isEmpty()) retList.add(tmpIntList);
            if(!tmpTreeList.isEmpty()) treeList.add(tmpTreeList);
        }        
        return retList;
    }
    
    //103. Binary Tree Zigzag Level Order Traversal
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> retList = new ArrayList();
        if(root == null) return retList;
        List<List<TreeNode>> treeList = new ArrayList();
        List<TreeNode> initTree = new ArrayList();
        initTree.add(root);
        treeList.add(initTree);
        boolean reverse = false;
        while(treeList.size() > retList.size()){
            List<TreeNode> tmpTreeList = new ArrayList();
            List<Integer> tmpIntList = new ArrayList();
            List<TreeNode> lastTreeList = treeList.get(treeList.size() - 1);
            for(int i = 0; i < lastTreeList.size(); i++){
                TreeNode t = lastTreeList.get(i);                
                if(t.left != null) tmpTreeList.add(t.left);
                if(t.right != null) tmpTreeList.add(t.right);
                if(reverse){
                    t = lastTreeList.get(lastTreeList.size() - 1 - i);
                }
                tmpIntList.add(t.val);
            }
            reverse = !reverse;
            /*
            for(TreeNode t : treeList.get(treeList.size() - 1)){
                tmpIntList.add(t.val);
                if(t.left != null) tmpTreeList.add(t.left);
                if(t.right != null) tmpTreeList.add(t.right);
            }*/
            if(!tmpIntList.isEmpty()) retList.add(tmpIntList);
            if(!tmpTreeList.isEmpty()) treeList.add(tmpTreeList);
        }        
        return retList;
    }
    
    //104. Maximum Depth of Binary Tree
    public static int maxDepth(TreeNode root) {
        /*int max = 0;
        if(root == null) return max;
        List<TreeNode> lvl = new ArrayList();
        lvl.add(root);
        while(!lvl.isEmpty()){
            List<TreeNode> tmplvl = new ArrayList();
            for(TreeNode t : lvl){
                if(t.left != null) tmplvl.add(t.left);
                if(t.right != null) tmplvl.add(t.right);
            }
            lvl = tmplvl;
            max++;
        }        
        return max;*/
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    //105. Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        int rootVal = preorder[0];
        int rootIdx = 0;
        while(inorder[rootIdx] != rootVal) rootIdx++;
        //rootIdx = Arrays.binarySearch(inorder, rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIdx + 1), Arrays.copyOfRange(inorder, 0, rootIdx));
        root.right = buildTree(Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length), Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length));
        return root;
    }
    
    //106. Construct Binary Tree from Inorder and Postorder Traversal
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;

        int rootVal = postorder[postorder.length - 1];
        int rootIdx = 0;
        while(inorder[rootIdx] != rootVal) rootIdx++;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree2(Arrays.copyOfRange(inorder, 0, rootIdx), Arrays.copyOfRange(postorder, 0, rootIdx));
        root.right = buildTree2(Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length), Arrays.copyOfRange(postorder, rootIdx, postorder.length - 1));        
        return root;
    }
    
    //108. Convert Sorted Array to Binary Search Tree
    /*public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int rootIdx = (nums.length - 1)/2;
        TreeNode root = new TreeNode(nums[rootIdx]);
        int[] leftnums = Arrays.copyOfRange(nums, 0, rootIdx);
        int[] rightnums = Arrays.copyOfRange(nums, rootIdx + 1, nums.length);
        root.left = sortedArrayToBST(leftnums);
        root.right = sortedArrayToBST(rightnums);
        return root;
    }*/
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(0, nums.length-1, nums);
    }
    public TreeNode buildBST(int low, int high, int[] nums){
        if(low > high) return null;
        int mid = (low + high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(low, mid-1, nums);
        root.right = buildBST(mid+1, high, nums);
        return root;
    }
    
    //112. Path Sum
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.val == sum) return true;
            return false;
        }        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
