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
        TreeNode input1 = new TreeNode(5);
        TreeNode input2 = new TreeNode(4);
        TreeNode input3 = new TreeNode(8);
        TreeNode input4 = new TreeNode(11);
        TreeNode input5 = new TreeNode(13);
        TreeNode input6 = new TreeNode(4);
        TreeNode input7 = new TreeNode(7);
        TreeNode input8 = new TreeNode(2);
        TreeNode input9 = new TreeNode(5);
        TreeNode input10 = new TreeNode(1);
        
        input1.left = input2;
        input1.right = input3;
        input2.left = input4;
        input3.left = input5;
        input3.right = input6;
        input4.left = input7;
        input4.right = input8;
        input6.left = input9;
        input6.right = input10;
        
        flatten(input1);
        TreeNode current = input1;
    
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
    
    //107. Binary Tree Level Order Traversal II
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        List<List<Integer>> retList2 = new ArrayList();
        while(!retList.isEmpty()){
            retList2.add(retList.get(retList.size() - 1));
            retList.remove(retList.size() - 1);
        }
        return retList2;
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
    
    //109. Convert Sorted List to Binary Search Tree
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }
    
    public TreeNode sortedListToBST(ListNode start, ListNode end){
        if(start == end) return null;
        ListNode mid = start;
        ListNode tail = start;
        while(tail.next != end && tail.next.next != end){
            mid = mid.next;
            tail = tail.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(start, mid);
        root.right = sortedListToBST(mid.next, end);        
        return root;
    }

    //110. Balanced Binary Tree
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    
    //111. Minimum Depth of Binary Tree
    public int minDepth(TreeNode root) {
        /*int count = 0;
        List<TreeNode> treeList = new ArrayList();
        if(root == null) return 0;
        treeList.add(root);
        while(true){
            count++;
            List<TreeNode> tmpTreeList = new ArrayList();
            for(TreeNode t : treeList){                
                if(t.left == null && t.right == null) return count;                
                if(t.left != null) tmpTreeList.add(t.left);
                if(t.right != null) tmpTreeList.add(t.right);                
            }
            treeList = tmpTreeList;
        }*/              
        if(root == null) return 0;
        if(root.left == null){
            return 1 + minDepth(root.right);
        }else if(root.right == null){
            return 1 + minDepth(root.left);
        }else{
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
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
    
    //113. Path Sum II
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> retlist = new ArrayList();
        if(root == null) return retlist;
        PathSum(retlist, new ArrayList(), root, sum);        
        return null;
    }
    
    public static void PathSum(List<List<Integer>> retlist, List<Integer> ilist, TreeNode root, int sum){
        if(root.right == null && root.left == null){
            if(root.val == sum){
                ilist.add(root.val);
                retlist.add(ilist);
            }
            return;
        }
        int nextsum = sum - root.val;
        if(nextsum <= 0) return;
        if(root.left != null){
            List<Integer> leftlist = new ArrayList(ilist);
            leftlist.add(root.val);
            PathSum(retlist, leftlist, root.left, nextsum);
        }
        if(root.right != null){
            List<Integer> rightlist = new ArrayList(ilist);
            rightlist.add(root.val);
            PathSum(retlist, rightlist, root.right, nextsum);
        }
    }
    
    //114. Flatten Binary Tree to Linked List
    public static void flatten(TreeNode root) {
        if(root == null) return;
        TreeNode rightRoot = root.right;
        TreeNode current = root;
        root.right = root.left;
        root.left = null;
        flatten(root.right);
        flatten(rightRoot);
        while(current.right != null){
            current = current.right;
        }
        current.right = rightRoot;
    }
}
