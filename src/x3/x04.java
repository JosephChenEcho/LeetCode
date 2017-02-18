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
public class x04 {
    public static void main(String[] args){
        getFactors(12);
    }
    
    //241. Different Ways to Add Parentheses
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> retList = new ArrayList();
        char[] carr = input.trim().toCharArray();
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
        //only one number
        if(cList.isEmpty()){
            retList.add(ival);
            return retList;
        }
        
        retList.addAll(compute(iList, cList, 0, iList.size() - 1));
        
        return retList;
    }
    
    public static List<Integer> compute(List<Integer> iList, List<Character> cList, int istart, int iend){
        List<Integer> retList = new ArrayList();
        if(istart == iend){
            //System.out.println(iend);
            retList.add(iList.get(istart));
            return retList;
        }
        for(int i = istart; i < iend; i++){
            List<Integer> head = compute(iList, cList, istart, i);
            List<Integer> tail = compute(iList, cList, i + 1, iend);
            char c = cList.get(i);
            for(int hi : head){
                for(int ti : tail){
                    if(c == '+'){
                        retList.add(hi + ti);                        
                    }else if(c == '-'){
                        retList.add(hi - ti);
                    }else if(c == '*'){
                        retList.add(hi * ti);
                    }else if(ti != 0){
                        retList.add(hi /ti);
                    }            
                }
            }
        }
        return retList;
    }
    
    //242. Valid Anagram
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for (int i : alphabet) if (i != 0) return false;
        return true;
    }
    
    //249. Group Shifted Strings
    public List<List<String>> groupStrings(String[] strings) {
        /*
        HashMap<Integer, List<String>> groupMap = new HashMap();
        List<List<String>> retList = new ArrayList();
        for(String str : strings){
            int len = str.length();
            if(groupMap.containsKey(len)){
                groupMap.get(len).add(str);
            }else{
                List<String> tmp = new ArrayList();
                tmp.add(str);
                groupMap.put(len, tmp);
            }            
        }
        for(Map.Entry<Integer,List<String>> set : groupMap.entrySet()){
            retList.add(set.getValue());
        }        
        return retList;*/
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a';
            String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
    //254. Factor Combinations
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> retList = new ArrayList();
        dfsFactors(retList, new ArrayList<Integer>(), n, 2);
        return retList;
    }
    
    public static void dfsFactors(List<List<Integer>> retList, List<Integer> item, int n, int start){
        if(n <= 1){
            if(item.size() > 1){
                retList.add(new ArrayList(item));
                return;
            }
        }
        for(int i = start; i <= n; i++){
            if(n % i == 0){
                item.add(i);
                dfsFactors(retList,item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
    
    //257. Binary Tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> retList = new ArrayList();
        if(root == null) return retList;
        String strroot = String.valueOf(root.val);
        if(root.right == null && root.left == null){
            retList.add(strroot);
            return retList;
        }
        if(root.right != null){
            retList.addAll(binaryTreePaths(strroot+"->",root.right));
        }
        if(root.left != null){
            retList.addAll(binaryTreePaths(strroot+"->",root.left));
        }
        return retList;
    }
    
    public List<String> binaryTreePaths(String start, TreeNode root){
        String strroot = start + String.valueOf(root.val);
        List<String> retList = new ArrayList();
        if(root.right == null && root.left == null){
            retList.add(strroot);
            return retList;
        }
        if(root.right != null){
            retList.addAll(binaryTreePaths(strroot+"->",root.right));
        }
        if(root.left != null){
            retList.addAll(binaryTreePaths(strroot+"->",root.left));
        }
        return retList;
    }
    
    //258. Add Digits
    public int addDigits(int num) {
        /*while(num > 9){
            int res = 0;
            while(num != 0){
                res += num % 10;
                num /= 10;
            }
            num = res;
        }
        return num;*/
        return num==0?0:(num%9==0?9:(num%9));
    }
    
    //260. Single Number III
    public int[] singleNumber(int[] nums) {
        // Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;
        
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
