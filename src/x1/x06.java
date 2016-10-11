/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;

/**
 * Unsolved Hard:
 * 65,68,72,76
 * 
 * @author jochen
 */
public class x06 {
    public static void main(String[] args){
        int[] input = {1,1,1,2,2,3};
        removeDuplicates(input);
        
    }
    
    //61. Rotate List
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        ListNode last = head;
        while(last.next != null){
            last = last.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode previous = new ListNode(0);
        previous.next = head;
        ListNode target = head;
        for(int i = 0; i < len - k; i++){
            previous = previous.next;
            target = target.next;
        }
        previous.next = null;
        last.next = head;
               
        return target;
    }
    
    //62. Unique Paths
    public static int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];        
        return uniquePaths(m - 1,n - 1, map);
    }
    
    public static int uniquePaths(int m, int n, int[][] map) {
        if (m == 0 || n == 0) return 1;
        if (map[m][n] == 0) map[m][n] = uniquePaths(m - 1, n, map) + uniquePaths(m, n - 1, map);
        return map[m][n];
    }
    
    //63. Unique Paths II
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid[0][0]==1) return 0;
        final int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        int init = 1;
        for(int i=n-1; i>=0; i--){
            if(obstacleGrid[i][m-1]==1)
                init = 0;
            dp[i][m-1] = init;
        }
        init = 1;
        for(int j=m-1; j>=0; j--){
            if(obstacleGrid[n-1][j]==1)
                init = 0;
            dp[n-1][j] = init;
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=m-2; j>=0; j--){
                if(obstacleGrid[i][j]==0)
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }
    
    //64. Minimum Path Sum
    public static int minPathSum(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        for(int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }
        for(int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i-1][0];
            for(int j = 1; j < grid[0].length; j++){
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }
        }
        
        return grid[grid.length - 1][grid[0].length - 1];
    }
    
    //66. Plus One
    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for(int i = digits.length-1;i>=0;i--){
            digits[i] += carry;
            if(digits[i] > 9){
                carry = digits[i]/10;
                digits[i] %= 10;
            }
            else{
                return digits;
            }
        }
        int[] retarr = new int[digits.length+1];
        int[] cararr = new int[1];
        cararr[0] = carry;
        System.arraycopy(cararr, 0, retarr, 0, 1);
        System.arraycopy(digits, 0, retarr, 1, digits.length);
        
        return retarr;
    }
    
    //67. Add Binary
    public static String addBinary(String a, String b) {
        if(a.length() > b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        char[] acarr = a.toCharArray();
        for(int i = 0; i < a.length(); i++){
            if(acarr[a.length() - 1 - i] == '1'){
                b = addBinaryOne(b,i);
            }
        }
        return b;
    }
    public static String addBinaryOne(String b, int idx){
        char[] bcarr = b.toCharArray();
        int car = 1;
        for(int i = idx; i < b.length(); i++){
            if(bcarr[b.length() - 1 - i] == '0'){
                bcarr[b.length() - 1 - i] = '1';
                return String.valueOf(bcarr);
            }else{
                if(car == 0){
                    bcarr[b.length() - 1 - i] = '1';
                    car = 0;
                }else{
                    bcarr[b.length() - 1 - i] = '0';
                    car = 1;
                }
            }
        }
        
        return car == 1? "1" + String.valueOf(bcarr) : String.valueOf(bcarr);
    }
    
    //69. Sqrt(x)
    public static int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    
    //70. Climbing Stairs
    public static int climbStairs(int n) {
        if(n == 0) return 1;      
        if(n == 1) return 1;
        int ret = 0;
        int a = 1, b = 1;
        for(int i = 1; i < n; i++){
            ret = a + b;
            b = a;
            a = ret;
        }
        return ret;
    }
    
    //71. Simplify Path
    public static String simplifyPath(String path) {
        /*String[] strarr = path.split("/");
        if(strarr.length == 0) return "/";
        if(strarr[strarr.length - 1].equals(".")) return "/";
        if(strarr[strarr.length - 1].equals("..")) return "/";
        return "/" + strarr[strarr.length - 1];*/
        Stack<String> stack = new Stack();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        while(!stack.isEmpty()) res = "/" + stack.pop() + res;
        return res.isEmpty() ? "/" : res;    
    }
    
    //73. Set Matrix Zeroes
    public static void setZeroes(int[][] matrix){
        if(matrix == null) return;
        HashSet<Integer> col = new HashSet();
        HashSet<Integer> row = new HashSet();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    col.add(i);
                    row.add(j);
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(col.contains(i) || row.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    //74. Search a 2D Matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        /*int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }       
        return false;*/
        int start = 0, end = matrix.length - 1;
        int mid = (start + end) / 2;
        while(matrix.length > 1){
            mid = (start + end) / 2;
            if(target < matrix[mid][0]){
                if(mid == 0) break;
                end = mid;
            }
            else{
                if((mid + 1) >= matrix.length) break;
                if(target < matrix[mid + 1][0]) break;
                start = mid + 1;
            }
        }
        
        start = 0;
        end = matrix[mid].length - 1;
        int midd = (start + end) / 2;
        
        while(matrix[mid].length > 1){
            midd = (start + end) / 2;
            if(target < matrix[mid][midd]){
                if(midd == 0) break;
                end = midd;
            }
            else{
                if((midd + 1) >= matrix[mid].length) break;
                if(target < matrix[mid][midd + 1]) break;
                start = midd + 1;
            }
        }
        
        return target == matrix[mid][midd];
    }
    
    //75. Sort Colors
    public static void sortColors(int[] nums) {
        /*int red = 0, white = 0, blue = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) red++;
            if(nums[i] == 1) white++;
            if(nums[i] == 2) blue++;
        }
        for(int i = 0; i < nums.length; i++){
            if(i < red) nums[i] = 0;
            else if(i < red + white) nums[i] = 1;
            else nums[i] = 2;
        }*/
        int begin = 0, end = nums.length - 1;
        for(int i = 0; i <= end; i++){
            while(nums[i] == 2 && i < end){
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
                System.out.println("Begin: " + begin + "End: " +end);
                for(int ii : nums){
                    System.out.print(ii);
                }
                System.out.println();
            }
            while(nums[i] == 0 && i > begin){
                nums[i] = nums[begin];
                nums[begin] = 0;
                begin++;
                System.out.println("Begin: " + begin + "End: " +end);
                for(int ii : nums){
                    System.out.print(ii);
                }
                System.out.println();
            }
            System.out.println("Out of While");
            System.out.println("Begin: " + begin + "End: " +end);
            for(int ii : nums){
                System.out.print(ii);
            }
            System.out.println();
        }
    }
    
    //77. Combinations
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;    
    }
    
    //78. Subsets
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> retlist = new ArrayList();
        Arrays.sort(nums);
        List<Integer> empty = new ArrayList();
        retlist.add(empty);
        for(int i = 0; i < nums.length; i++){
            List<List<Integer>> tmp = new ArrayList();
            for(List<Integer> ial : retlist){
                List<Integer> tmpal = new ArrayList(ial);
                tmpal.add(nums[i]);
                tmp.add(tmpal);
            }
            retlist.addAll(tmp);
        }        
        return retlist;
    }
    
    //79. Word Search
    public static boolean exist(char[][] board, String word) {
        int len = board.length;
        int wid = board[0].length;
        boolean[][] used = new boolean[len][wid];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < wid; j++){
                if(exist(board,i,j,0,word,used)) return true;
            }
        }        
        return false;
    }
    
    public static boolean exist(char[][] board, int x, int y, int idx, String word, boolean[][] used){
        if(idx == word.length()) return true;
        int len = board.length;
        int wid = board[0].length;
        if(x < 0 || x == len || y < 0 || y == wid) return false;
        if(used[x][y]) return false;
        if(board[x][y] != word.charAt(idx)) return false;
        used[x][y] = true;
        boolean result = exist(board, x-1, y, idx + 1, word, used)||
                exist(board, x+1, y, idx + 1, word, used)||
                exist(board, x, y-1, idx + 1, word, used)||
                exist(board, x, y+1, idx + 1, word, used);
        used[x][y] = false;
        return result;
    }
    
    //80. Remove Duplicates from Sorted Array II
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {return 0;}
        int pointer = 0, flag = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && flag == 0) {
                flag = 1;
                pointer++;
            } else if (nums[i] != nums[i - 1]) {
                flag = 0;
                pointer++;
            }
            nums[pointer] = nums[i];
        }
        return pointer + 1;
    }
}
