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
        for(int i : diffWaysToCompute("2*3-4*5")){
            System.out.println(i);
        }
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
}
