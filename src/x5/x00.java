/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x5;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class x00 {
    public static void main(String[] args){
    
    }
    
    //401. Binary Watch
    public List<String> readBinaryWatch(int num) {
        List<String> retList = new ArrayList<String>();
        for(int i = 0; i <= num; i++){
            int[] hournum = new int[]{1, 2, 4, 8};
            int[] minnum = new int[]{1, 2, 4, 8, 16, 32};
            List<Integer> hourpos = new ArrayList<Integer>();
            List<Integer> minpos = new ArrayList<Integer>();
            getHour(hourpos, 0, hournum, num, 0);
            getMinute(minpos, 0, minnum, num - i, 0);
            retList.addAll(combineHourMinute(hourpos,minpos));
        }        
        return retList;
    }
    
    public void getHour(List<Integer> hourpos, int start, int[] hournum, int count, int sum){
        if(start == count){
            if(sum < 12) hourpos.add(sum);
            return;
        }
        for(int i = start; i < hournum.length; i++){
            getHour(hourpos, i + 1, hournum, count - 1, sum + hournum[i]);
        }
    }
    
    public void getMinute(List<Integer> minpos, int start, int[] minnum, int count, int sum){
        if(start == count){
            if(sum < 60) minpos.add(sum);
            return;
        }
        for(int i = start; i < minnum.length; i++){
            getMinute(minpos, i + 1, minnum, count - 1, sum + minnum[i]);
        }
    }
    
    public List<String> combineHourMinute(List<Integer> hour, List<Integer> minute){
        List<String> retList = new ArrayList<>();
        for(int ih : hour){
            for(int im : minute){
                String time = String.valueOf(ih) + ":";// + im<10 ? "0" : "" + String.valueOf(im);
                if(im < 10){
                    time += "0" + String.valueOf(im);
                }else{
                    time += String.valueOf(im);
                }
                retList.add(time);
            }
        }
        return retList;
    }
    
    //402. Remove K Digits
    public String removeKdigits(String num, int k) {
        int digits = num.length() - k;
        char[] stk = new char[num.length()];
        int top = 0;
        // k keeps track of how many characters we can remove
        // if the previous character in stk is larger than the current one
        // then removing it will get a smaller number
        // but we can only do so when k is larger than 0
        for (int i = 0; i < num.length(); ++i) {
            char c = num.charAt(i);
            while (top > 0 && stk[top-1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            stk[top++] = c;
        }
        // find the index of first non-zero digit
        int idx = 0;
        System.out.println(String.valueOf(stk));
        while (idx < digits && stk[idx] == '0') idx++;
        return idx == digits? "0": new String(stk, idx, digits - idx);
    }
    
    //404. Sum of Left Leaves
    public int sumOfLeftLeaves(TreeNode root) {
        // only return leaf
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null){
            ans += isLeft(root.left, true);
        }
        if(root.right != null){
            ans += isLeft(root.right, false);
        }
        return ans;
    }
    
    public int isLeft(TreeNode root, boolean left){
        int ans = 0;
        if(root.left == null && root.right == null && left){
            return root.val;
        }
        if(root.left != null){
            ans += isLeft(root.left, true);
        }
        if(root.right != null){
            ans += isLeft(root.right, false);
        }
        return ans;
    }
    
    //405. Convert a Number to Hexadecimal
    public String toHex(int num) {
        
        long n = num & 0x00000000ffffffffL;
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, map[(int) (n % 16)]);
            n = n / 16;
        }
        return num == 0 ? "0" : sb.toString();
       
    }
    
    //408. Valid Word Abbreviation
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }
}
