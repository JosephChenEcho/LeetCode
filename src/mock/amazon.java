/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class amazon {
    public static void main(String[] args){
        ListNode input1 = new ListNode(1);
        input1.next = new ListNode(2);
        reverseList(input1);
    
    }
    
    public static String[] largestItemAssociation(String[][] itemAssociation)
	{
		// WRITE YOUR CODE HERE
                HashMap<String, List<String>> itemMap = new HashMap<>();
                for(int i = 0; i < itemAssociation.length; i++){
                    String first = itemAssociation[i][0];
                    String second = itemAssociation[i][1];
                    
                    if(!itemMap.containsKey(first)){
                        itemMap.put(first, new ArrayList<String>());
                    }
                    itemMap.get(first).add(second);
                    if(!itemMap.containsKey(second)){
                        itemMap.put(second, new ArrayList<String>());
                    }
                    itemMap.get(second).add(first);
                }
                System.out.println();
		HashSet<String> visited = new HashSet<>();
                HashMap<String, List<String>> sumMap = new HashMap<>();
                for(String key : itemMap.keySet()){
                    if(!visited.contains(key)){
                        sumMap.put(key,dfsgraph(itemMap, key,visited));
                    }
                }
                int max = 0;
                List<String> retList = new ArrayList();
                for(String key: sumMap.keySet()){
                    if(sumMap.get(key).size() > max){
                        max = sumMap.get(key).size();
                        retList.clear();
                        retList.add(key);
                        retList.addAll(sumMap.get(key));
                    }
                }
                System.out.println(sumMap.size());
                String[] retarr = new String[retList.size()];
                for(int i = 0; i < retarr.length; i++){
                    retarr[i] = retList.get(i);
                }
                return retarr;
	}
    public static List<String> dfsgraph(HashMap<String, List<String>> itemMap, String key,HashSet<String> visited){
        List<String> retList = new ArrayList();        
        visited.add(key);
        for(int i = 0; i < itemMap.get(key).size(); i++){
            if(!retList.contains(itemMap.get(key).get(i))){
                retList.add(itemMap.get(key).get(i));
            }
        }
        String[] item = (String[])itemMap.get(key).toArray();
        Arrays.sort(item);
        for(int i = 0; i < item.length; i++){
            String newkey = item[i];
            if(!visited.contains(newkey)){
                for(String str : dfsgraph(itemMap, newkey,visited)){
                    if(!retList.contains(str)){
                        retList.add(str);
                    }
                }
            }
        }
        return retList;
    }
    
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return null;
        List<List<String>> retList = new ArrayList();
        HashSet<String> wordSet = new HashSet();
        for(String str: wordList){
            wordSet.add(str);
        }
        //wordSet.add(beginWord);
        retList = helper(beginWord, endWord, wordSet);
        return retList;
    }
    
    public static List<List<String>> helper(String beginWord, String endWord, HashSet<String> wordSet){
        List<List<String>> retList = new ArrayList();
        for(int i = 0; i < beginWord.length(); i++){
            for(int j = 0; j < 26; j++){
                char[] oldWord = beginWord.toCharArray();
                if(beginWord.charAt(i) == 'a' + j) continue;
                oldWord[i] = (char)('a' + j);
                String newWord = String.valueOf(oldWord);
                if(wordSet.contains(newWord)){
                    wordSet.remove(newWord);
                    if(newWord.equals(endWord)){
                        List<String> tmp = new ArrayList();
                        tmp.add(newWord);
                        retList.add(tmp);
                        return retList;
                    }
                    List<List<String>> tmpList = helper(newWord, endWord, wordSet);
                    for(List<String> ls : tmpList){
                        List<String> tmp = new ArrayList();
                        tmp.add(newWord);
                        tmp.addAll(ls);
                        retList.add(tmp);
                        
                    }
                }
            }
        }
        return retList;
    
    }
    
    //1. Two Sum
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            
            if(map.containsKey(nums[i]) && map.get(nums[i]) != i){
                ret[0] = map.get(nums[i]);
                ret[1] = i;
                return ret;
            }
            map.put(target - nums[i], i);
        }
        
        return ret;
    }
    
    public int numIslands(char[][] grid) {
        int cnt = 0;
        if(grid.length == 0) return cnt;
        int len = grid.length;
        int wid = grid[0].length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < wid; j++){
                if(grid[i][j] == '2') continue;
                if(grid[i][j] == '1'){
                    cnt++;
                    readIsland(i,j,grid);
                }
            }
        }        
        return cnt;
    }
    
    public void readIsland(int i, int j, char[][] grid){
        int len = grid.length;
        int wid = grid[0].length;
        grid[i][j] = '2';
        if(i - 1 >=0 && grid[i-1][j] == '1') readIsland(i-1,j,grid);
        if(j - 1 >=0 && grid[i][j-1] == '1') readIsland(i,j-1,grid);
        if(i + 1 < len && grid[i+1][j] == '1') readIsland(i+1,j,grid);
        if(j + 1 < wid && grid[i][j + 1] == '1') readIsland(i,j+1,grid);
    }
    
    //20. Valid Parentheses
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch==')' || ch==']' || ch=='}') {
                if(stack.isEmpty()) return false;
                if(ch==')' && stack.pop()!='(') return false;
                if(ch==']' && stack.pop()!='[') return false;
                if(ch=='}' && stack.pop()!='{') return false;
            }
            else stack.push(ch);
        }
        return stack.isEmpty() ? true : false; 
    }
    
    //138. Copy List with Random Pointer
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> nMap = new HashMap<>();
        RandomListNode p =  head;
        while(p != null){
            nMap.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = head;
        while(p != null){
            nMap.get(p).next = nMap.get(p.next);
            nMap.get(p).random = nMap.get(p.random);
        }
        return nMap.get(head);
    }
    
    //236. Lowest Common Ancestor of a Binary Tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);        
        if(left != null && right != null){
            return root;
        }else if(left == null){
            return right;
        }else{
            return left;
        }
    }
    
    //438. Find All Anagrams in a String
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--; 

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }
    
    //606. Construct String from Binary Tree
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        if(t.left == null && t.right == null) return String.valueOf(t.val);
        if(t.right == null){
            return String.valueOf(t.val) + "(" + tree2str(t.left) + ")";
        }else{
            return String.valueOf(t.val) + "("+ tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
        }        
    }
    
    //538. Convert BST to Greater Tree
    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> tstack = new Stack();
        if(root == null) return null;
        int great = 0;
        TreeNode p = root;
        while(p != null){
            tstack.add(p);
            p = p.right;
        }
        while(!tstack.isEmpty()){
            TreeNode right = tstack.pop();
            right.val += great;
            great = right.val;
            p = right.left;
            while(p != null){
                tstack.add(p);
                p = p.right;
            }
        }
        
        return root;
    }
    
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }        
        return max;
    }
    
    //206. Reverse Linked List
    public static ListNode reverseList(ListNode head){
        if(head == null) return null;
        ListNode tail = head;
        ListNode p = head.next;
        while(p != null){
            ListNode tmp = p;
            p = p.next;
            tmp.next = tail;
            tail = tmp;            
        }        
        return tail;
    }
    //536. Construct Binary Tree from String
    public TreeNode str2tree(String s) {
        
        return null;
    }
}


