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
public class x08 {
    public static void main(String[] args){
        
        hammingWeight(14);
    }
    
    //186. Reverse Words in a String II    
    public void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
    //187. Repeated DNA Sequences
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();
        final int subLen = 10;
        if( s==null || s.length() <= 10) {
            return result;
        }

        //Define a memo to store each 10 letter-long sub-strings.
        Set<String> set = new HashSet<String>();
        Set<String> dupSet = new HashSet<String>();

        char[] chars = s.toCharArray();

        String str;
        for(int i=0; i<= chars.length-subLen; i++){
            str = new String(chars, i, subLen);
            if(set.contains(str)) {
                dupSet.add(str);
            } else{
                set.add(str);
            }
        }

        result.addAll(dupSet);

        return result;
    }
    
    //189. Rotate Array
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;
        rotate(0, nums.length - k - 1, nums);
        rotate(nums.length - k, nums.length - 1, nums);
        rotate(0, nums.length - 1, nums);
    }
    
    public static void rotate(int start, int end, int[] nums){
        while(start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
    
    //190. Reverse Bits
    public static int reverseBits(int n) {
        if (n == 0) return 0;
    
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if ((n & 1) == 1) result++;
            n >>= 1;
        }
        return result;
    }
    
    //191. Number of 1 Bits
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            int p = n & -n;
            n ^= p;
            count++;
        }
        return count;
    }
    
    //198. House Robber
    public int rob(int[] nums) {
        /*int pre1 = 0;
        int pre2 = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = max;
        }
        return max;
        */
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        nums[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i-1]);
        }        
        return nums[nums.length - 1];
        
    }
    
    //199. Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> retList = new ArrayList();
        if(root == null) return retList;
        List<TreeNode> curLvl =  new ArrayList();
        curLvl.add(root);
        while(!curLvl.isEmpty()){
            retList.add(curLvl.get(curLvl.size() - 1).val);
            List<TreeNode> tmpLvl = new ArrayList();
            for(TreeNode r : curLvl){
                if(r.left != null) tmpLvl.add(r.left);
                if(r.right != null) tmpLvl.add(r.right);
            }
            curLvl = tmpLvl;
        }
        return retList;
    }
    
    //200. Number of Islands
    public static int numIslands(char[][] grid) {
        int cnt = 0;
        if(grid == null) return cnt;
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
    
    public static void readIsland(int i, int j, char[][] grid){
        int len = grid.length;
        int wid = grid[0].length;
        grid[i][j] = '2';
        if(i - 1 >=0 && grid[i-1][j] == '1') readIsland(i-1,j,grid);
        if(j - 1 >=0 && grid[i][j-1] == '1') readIsland(i,j-1,grid);
        if(i + 1 < len && grid[i+1][j] == '1') readIsland(i+1,j,grid);
        if(j + 1 < wid && grid[i][j + 1] == '1') readIsland(i,j+1,grid);
    }
}
