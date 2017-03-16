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
        //reconstructQueue(new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}});
        //reconstructQueue(new int[][]{{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}});
        reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
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
    
    //406. Queue Reconstruction by Height
    public static int[][] reconstructQueue(int[][] people) {
        /*
        List<int[]> pList = new ArrayList<>();
        List<int[]> retList = new ArrayList<>();
        Comparator<int[]> c = new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]){
                    return o2[0] - o1[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        };
        Arrays.sort(people,c);
        for(int[] i : people){pList.add(i);}
        List<int[]> tmpList = new ArrayList<>();
        
        while(!pList.isEmpty()){
            for(int i = 0; i < pList.size(); i++){
                int[] p = pList.get(i);
                int count = 0;
                int j = 0;
                for(j = 0; j < retList.size(); j++){
                    if(retList.get(j)[0] >= p[0]){
                        count++;
                    }
                    if(count > p[1]){
                        retList.add(j,p);
                        break;
                    }
                }
                if((count == p[1] )){
                    retList.add(p);
                }else if(j == retList.size()){
                    tmpList.add(p);
                }
            }
            if(tmpList.size() == pList.size()) return null;
            System.out.println("RetList : ");
            for(int[] ei : retList){
                System.out.print(ei[0] + " " + ei[1] + ", ");
            }     
            System.out.println();
            System.out.println("tmpList : ");
            for(int[] ei : tmpList){
                System.out.print(ei[0] + " " + ei[1] + ", ");
            }
            System.out.println();
            pList.clear();
            pList.addAll(tmpList);
            tmpList.clear();
            //pList = tmpList;            
        }
        int[][] retarr = new int[retList.size()][];
        for(int i = 0; i < retList.size(); i++){
            retarr[i] = retList.get(i);
        }        
        return retarr;
*/
        if (people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
            
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        int n = people.length;
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++)
            tmp.add(people[i][1], new int[]{people[i][0], people[i][1]});

        int[][] res = new int[people.length][2];
        int i = 0;
        for (int[] k : tmp) {
            res[i][0] = k[0];
            res[i][1] = k[1];
            i++;            
        }
        
        return res;
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
    
    //409. Longest Palindrome
    public int longestPalindrome(String s) {
        HashSet<Character> cSet = new HashSet<>();
        int res = 0;
        for(char c : s.toCharArray()){
            if(cSet.contains(c)){
                cSet.remove(c);
                res += 2;
            }else{
                cSet.add(c);
            }
        }
        if(!cSet.isEmpty()) res++;
        return res;
    }
    
    //410. Split Array Largest Sum
    public int splitArray(int[] nums, int m) {
        int L = nums.length;
        int[] S = new int[L+1];
        S[0]=0;
        for(int i=0; i<L; i++)
            S[i+1] = S[i]+nums[i];

        int[] dp = new int[L];
        for(int i=0; i<L; i++)
            dp[i] = S[L]-S[i];

        for(int s=1; s<m; s++)
        {
            for(int i=0; i<L-s; i++)
            {
                dp[i]=Integer.MAX_VALUE;
                for(int j=i+1; j<=L-s; j++)
                {
                    int t = Math.max(dp[j], S[j]-S[i]);
                    if(t<=dp[i])
                        dp[i]=t;
                    else
                        break;
                }
            }
        }

        return dp[0];
    }
    //411
    
    //412. Fizz Buzz
    public List<String> fizzBuzz(int n) {
        List<String> retList = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(i % 15 ==0){
                retList.add("FizzBuzz");
            }else if(i % 5 == 0){
                retList.add("Buzz");
            }else if(i % 3 == 0){
                retList.add("Fizz");
            }else{
                retList.add(String.valueOf(i));
            }
        }
        return retList;
    }
}
