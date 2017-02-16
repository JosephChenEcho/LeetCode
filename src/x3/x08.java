/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;
import java.util.*;
/**
 *
 * @author jochen
 */
public class x08 {
    public static void main(String[] args){        
        TreeNode input1 = new TreeNode(1);
        TreeNode input2 = new TreeNode(2);
        TreeNode input3 = new TreeNode(3);
        TreeNode input4 = new TreeNode(4);
        TreeNode input5 = new TreeNode(5);
        TreeNode input6 = new TreeNode(6);
        TreeNode input7 = new TreeNode(7);
        input1.left = input2;
        input1.right = input3;
        input2.left = input4;
        input2.right = input5;
        input3.left = input6;
        input3.right = input7;
        System.out.println(serialize(input1));

    }
    
    //283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while(i < len){
            while(i < len && nums[i] == 0){
                i++;
            }
            if(i == len) break;
            nums[j] = nums[i];
            j++;
            i++;
        }
        while(j < len){
            nums[j] = 0;
            j++;
        }
    }
    
    //289. Game of Life
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dieOrLive(i, j, board, m, n);
            }
        }        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] /= 2;
            }
        }    
    }
    
    public static void dieOrLive(int i, int j, int[][] board, int m, int n){
        int count = 0;
        if(board[i][j] == 1){
            if(i > 0 && board[i-1][j]%2 == 1) count++;
            if(i < m - 1 && board[i+1][j]%2 == 1) count++;
            if(j > 0 && board[i][j-1]%2 == 1) count++;
            if(j < n - 1 && board[i][j+1]%2 == 1) count++;
            if(i > 0 && j > 0 && board[i-1][j-1]%2 == 1) count++;
            if(i > 0 && j < n - 1 && board[i-1][j+1]%2 == 1) count++;
            if(i < m - 1 && j > 0 && board[i+1][j-1]%2 == 1) count++;
            if(i < m - 1 && j < n - 1 && board[i+1][j+1]%2 == 1) count++;
            if(count == 2 || count == 3) board[i][j] += 2;
        }else{
            if(i > 0 && board[i-1][j]%2 == 1) count++;
            if(i < m - 1 && board[i+1][j]%2 == 1) count++;
            if(j > 0 && board[i][j-1]%2 == 1) count++;
            if(j < n - 1 && board[i][j+1]%2 == 1) count++;
            if(i > 0 && j > 0 && board[i-1][j-1]%2 == 1) count++;
            if(i > 0 && j < n - 1 && board[i-1][j+1]%2 == 1) count++;
            if(i < m - 1 && j > 0 && board[i+1][j-1]%2 == 1) count++;
            if(i < m - 1 && j < n - 1 && board[i+1][j+1]%2 == 1) count++;
            if(count == 3) board[i][j] = 2;
        }
    }
    
    //290. Word Pattern
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        char[] pats = pattern.toCharArray();
        if(words.length != pats.length) return false;
        HashMap<Character, String> map = new HashMap();
        for(int i = 0 ; i < pats.length; i++){
            if(map.containsKey(pats[i])){
                if(!map.get(pats[i]).equals(words[i])){
                    return false;
                }
            }else if(map.containsValue(words[i])){
                if(!map.containsKey(pats[i]) || !map.get(pats[i]).equals(words[i])){
                    return false;
                }
            }else{
                map.put(pats[i], words[i]);
            }
        }        
        return true;
    }
    
    //291. Word Pattern II
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);       
    } 
    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pat.length()) return true;
        if (i == str.length() || j == pat.length()) return false;

        // get current pattern character
        char c = pat.charAt(j);

        // if the pattern character exists
        if (map.containsKey(c)) {
          String s = map.get(c);

          // then check if we can use it to match str[i...i+s.length()]
          if (!str.startsWith(s, i)) {
            return false;
          }

          // if it can match, great, continue to match the rest
          return isMatch(str, i + s.length(), pat, j + 1, map, set);
        }

        // pattern character does not exist in the map
        for (int k = i; k < str.length(); k++) {
          String p = str.substring(i, k + 1);

          if (set.contains(p)) {
            continue;
          }

          // create or update it
          map.put(c, p);
          set.add(p);

          // continue to match the rest
          if (isMatch(str, k + 1, pat, j + 1, map, set)) {
            return true;
          }

          // backtracking
          map.remove(c);
          set.remove(p);
        }

        // we've tried our best but still no luck
        return false;
    }
    
    //292. Nim Game
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    //297. Serialize and Deserialize Binary Tree
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {        
        StringBuilder sb=new StringBuilder();
        TreeNode x=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while (x!=null || !stack.isEmpty()) {
            if (x!=null) {
                sb.append(String.valueOf(x.val));
                sb.append(' ');
                stack.push(x);
                x=x.left;
            }
            else {
                sb.append("null ");
                x=stack.pop();
                x=x.right;
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        TreeNode retNode;
        data = data.substring(1, data.length() - 1);
        if(data.length() == 0) return null;
        String[] nodeval = data.split(",");
        retNode = new TreeNode(Integer.parseInt(nodeval[0]));
        List<TreeNode> nodeList = new ArrayList();
        int i = 1;
        while(!nodeList.isEmpty()){
            List<TreeNode> tmpList = new ArrayList();
            for(int j = 0; j < nodeList.size(); j++){
                TreeNode cur = nodeList.get(i);
                String left = i < nodeval.length ?  nodeval[i++] : "null";
                String right = i < nodeval.length ? nodeval[i++] : "null";
                if(!left.equals("null")){
                    TreeNode leftNode = new TreeNode(Integer.parseInt(left));
                    cur.left = leftNode;
                    tmpList.add(leftNode);
                }
                if(!right.equals("null")){
                    TreeNode rightNode = new TreeNode(Integer.parseInt(right));
                    cur.right = rightNode;
                    tmpList.add(rightNode);
                }
            }
            nodeList = tmpList;
        }        
        return retNode;
    }
    
    //299. Bulls and Cows
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        /*int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                numbers[s] ++;
                numbers[g] --;
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;                
            }
        }
        return bulls + "A" + cows + "B";*/
        Boolean[] useds = new Boolean[secret.length()];
        Boolean[] usedg = new Boolean[secret.length()];
        for(int i = 0; i < secret.length(); i++){
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            useds[i] = false;
            usedg[i] = false;
            if (s == g) {
                bulls++;
                useds[i] = true;
                usedg[i] = true;
            }
        }
        for(int i = 0; i < secret.length(); i++){            
            int s = Character.getNumericValue(guess.charAt(i));
            for(int j = 0; j < secret.length(); j++){
                int g = Character.getNumericValue(secret.charAt(j));
                if(s == g){
                    if(!(useds[i]&&usedg[j]))
                    {cows++;
                    usedg[i] = true;
                    useds[j] = true;
                    }
                }
            }
        }
        
        return bulls + "A" + cows + "B";              
    }
    
    //300. Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {
        int[] map = new int[nums.length];
        int max = -1;
        for(int i = 0; i < map.length; i++){
            map[i] = 1;
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] > nums[i]){
                    map[j] = Math.max(map[j], map[i] + 1);
                    max = Math.max(max, map[j]);
                }
            }
        }
        
        return max;
    }
}
