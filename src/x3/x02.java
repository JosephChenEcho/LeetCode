/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class x02 {
    public static void main(String[] args){
        maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
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
        int depth = rightMostDepth(root);   //depth of the last full level
        int result = (1 << depth) - 1;  //num of nodes from root to the last full level
        TreeNode cur = root;
        int rootdepth = 1;
        while (cur != null) {
            int leftdepth = rightMostDepth(cur.left);
            if (leftdepth + rootdepth == depth) cur = cur.left; //the partially full level ends within the left subtree
            else {  //ends in the right subtree
                result += (1 << leftdepth - 1); //add the number of nodes in the partially full level within the left subtree
                cur = cur.right;    //continue to search for the end point of partially full level
            }
            rootdepth++;
        }
        return result;
    }
    
    private static int rightMostDepth(TreeNode root) {  //the depth from root to the right most leave
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.right;
        }
        return depth;
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
        
    //227. Basic Calculator II
    public int calculate(String s) {
        char[] carr = s.trim().toCharArray();
        List<Integer> iList = new ArrayList();
        List<Character> cList = new ArrayList();
        int ival = 0;
        for(int i = 0; i < carr.length; i++){
            if(carr[i] == ' ') continue;
            if(carr[i] - '0' >= 0 && carr[i] - '0' <= 9){
                ival = ival * 10 + (carr[i] - '0');
            }else{
                iList.add(ival);
                ival = 0;
                cList.add(carr[i]);
            }
        }        
        iList.add(ival);
        int pre = iList.get(0);
        int ret = 0;
        for(int i = 0; i < cList.size(); i++){
            char c = cList.get(i);
            if(c == '+' || c == '-'){
                ret += pre;
                if(c == '+'){
                    pre = iList.get(i + 1);
                }else{
                    pre = 0 - iList.get(i + 1);
                }
            }else{
                if(c == '*'){
                    pre *= iList.get(i + 1);
                }else{
                    pre /= iList.get(i + 1);
                }
            }
        }
        ret += pre;
        return ret;
    }
    
    //228. Summary Ranges
    public List<String> summaryRanges(int[] nums) {
        List<String> retList = new ArrayList();
        if(nums.length == 0) return retList;
        String str = String.valueOf(nums[0]);
        int start = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i - 1] + 1){
                if(nums[i - 1] != start){
                    str += "->" + String.valueOf(nums[i - 1]);
                }
                retList.add(str);
                start = nums[i];
                str = String.valueOf(nums[i]);
            }
        }        
        if(nums[nums.length - 1] != start){
            str += "->" + String.valueOf(nums[nums.length - 1]);
        }
        retList.add(str);
        return retList;
    }
    //229. Majority Element II
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
		return new ArrayList();
	List<Integer> result = new ArrayList();
	int number1 = nums[0], number2 = nums[0], count1 = 0, count2 = 0, len = nums.length;
	for (int i = 0; i < len; i++) {
		if (nums[i] == number1)
			count1++;
		else if (nums[i] == number2)
			count2++;
		else if (count1 == 0) {
			number1 = nums[i];
			count1 = 1;
		} else if (count2 == 0) {
			number2 = nums[i];
			count2 = 1;
		} else {
			count1--;
			count2--;
		}
	}
	count1 = 0;
	count2 = 0;
	for (int i = 0; i < len; i++) {
		if (nums[i] == number1)
			count1++;
		else if (nums[i] == number2)
			count2++;
	}
	if (count1 > len / 3)
		result.add(number1);
	if (count2 > len / 3)
		result.add(number2);
	return result;
    }
    
    //230. Kth Smallest Element in a BST
    public int kthSmallest(TreeNode root, int k) {
        int count = countNodes1(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        
        return root.val;
    }
    
    private int countNodes1(TreeNode n) {
        if (n == null) return 0;        
        return 1 + countNodes(n.left) + countNodes(n.right);
    }
    
    //231. Power of Two
    public boolean isPowerOfTwo(int n) {
        return n > 0 && ((n - 1) & n) == 0;
    }
    
    //232. Implement Queue using Stacks
    
    //234. Palindrome Linked List
    public static boolean isPalindrome(ListNode head) {
        ListNode reverse = null;
        ListNode point = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode tmp = point;
            point = point.next;
            tmp.next = reverse;
            reverse = tmp;            
        }        
        if(fast != null) point = point.next;
        while(point != null && reverse != null){
            if(point.val != reverse.val) return false;
            point = point.next;
            reverse = reverse.next;
        }
        return true;
    }
    //235. Lowest Common Ancestor of a Binary Search Tree
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int left = p.val > q.val ? q.val : p.val;
        int right = p.val > q.val ? p.val : q.val;
        TreeNode retNode = root;
        while(!(retNode.val >= left && retNode.val <= right)){
            if(retNode.left != null && retNode.val >= right){
                retNode = retNode.left;
            }else if(retNode.right != null && retNode.val <= left){
                retNode = retNode.right;
            }else{
                return null;
            }
        }
        return retNode;
    }
    //236. Lowest Common Ancestor of a Binary Tree
    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        /*TreeNode retNode = root;
        while(hasNode(retNode,p) && hasNode(retNode,q)){
            if(hasNode(retNode.left,p) && hasNode(retNode.left,q)){
                retNode = retNode.left;
            }else if(hasNode(retNode.right,p) && hasNode(retNode.right,q)){
                retNode = retNode.right;
            }else{
                return retNode;
            }
        }
        return null;*/
        if(root == null) {
            return null;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null || root == p || root == q) {
            return root;
        }
        if(left != null) {
            return left;
        }
        return right;
    }
    
    public static boolean hasNode(TreeNode parent, TreeNode node){
        if (parent == null) return false;
        if (parent == node) return true;
        return hasNode(parent.left, node) || hasNode(parent.right, node);
    }    
    
    //237. Delete Node in a Linked List
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
    //238. Product of Array Except Self
    //For example, given [1,2,3,4], return [24,12,8,6].
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
    
    //239. Sliding Window Maximum
    public static int[] maxSlidingWindow(int[] in, int w) {
        int[] max_left = new int[in.length];
        int[] max_right = new int[in.length];

        max_left[0] = in[0];
        max_right[in.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

            final int j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
        }

        final int[] sliding_max = new int[in.length - w + 1];
        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }
    
    //240. Search a 2D Matrix II
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m<1) return false;
        int n = matrix[0].length;

        return searchMatrix(matrix, new int[]{0,0}, new int[]{m-1, n-1}, target);
    }

    private boolean searchMatrix(int[][] matrix, int[] upperLeft, int[] lowerRight, int target) {
	if(upperLeft[0]>lowerRight[0] || upperLeft[1]>lowerRight[1]
			|| lowerRight[0]>=matrix.length || lowerRight[1]>=matrix[0].length) 
		return false;
	if(lowerRight[0]-upperLeft[0]==0 && lowerRight[1]-upperLeft[1]==0)
		return matrix[upperLeft[0]][upperLeft[1]] == target;
	int rowMid = (upperLeft[0] + lowerRight[0]) >> 1;
	int colMid = (upperLeft[1] + lowerRight[1]) >> 1;
	int diff = matrix[rowMid][colMid] - target;
	if(diff > 0) {
		return searchMatrix(matrix, upperLeft, new int[]{rowMid, colMid}, target)
				|| searchMatrix(matrix, new int[]{upperLeft[0],colMid+1}, new int[]{rowMid, lowerRight[1]}, target)
				|| searchMatrix(matrix, new int[]{rowMid+1,upperLeft[1]}, new int[]{lowerRight[0], colMid}, target);
	}
	else if(diff < 0) {
 		return searchMatrix(matrix, new int[]{upperLeft[0], colMid+1}, new int[]{rowMid, lowerRight[1]}, target)
				|| searchMatrix(matrix, new int[]{rowMid+1, upperLeft[1]}, new int[]{lowerRight[0], colMid}, target)
				|| searchMatrix(matrix, new int[]{rowMid+1, colMid+1}, lowerRight, target);
	}
	else return true;
    }
}
