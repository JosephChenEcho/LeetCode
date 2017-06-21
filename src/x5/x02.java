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
public class x02 {
    
    public static void main(String[] args){
        //characterReplacement("ABAA",0);
        findAnagrams("abcdefbca","abc");
    }
    
    //422. Valid Word Square
    public boolean validWordSquare(List<String> words) {
        if(words == null || words.size() == 0){
            return true;
        }
        int n = words.size();
        for(int i=0; i<n; i++){
            for(int j=i; j<words.get(i).length(); j++){
                if(j >= n || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j))
                    return false;
            }
        }
        return true;
    }
    
    //424. Longest Repeating Character Replacement
    public static int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    
    //432. All O`one Data Structure
    
    //438. Find All Anagrams in a String
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> retList = new ArrayList();
        HashMap<Character, Integer> cntMap = new HashMap<>();
        for(char c : p.toCharArray()){
            if(!cntMap.containsKey(c)){
                cntMap.put(c, 0);
            }
            cntMap.put(c,cntMap.get(c) + 1 );
        }
        int start = 0;
        int end = 0;
        while(start < s.length() && end < s.length()){
            if(start < s.length() && !cntMap.containsKey(s.charAt(start))){
                start++;
                end = start;
                continue;
            }
            while(end < s.length()){
                if(end < s.length() && cntMap.containsKey(s.charAt(end))){
                    if(end - start == p.length() - 1){
                        HashMap<Character, Integer> chk = (HashMap)cntMap.clone();
                        int i;
                        for(i = start; i <= end; i++){
                            if(chk.get(s.charAt(i)) == 0){
                                break;
                            }
                            chk.put(s.charAt(i), chk.get(s.charAt(i)) - 1);
                        }
                        if(i == end + 1){
                            retList.add(start);
                        }                        
                        start++;
                    }
                    end++;
                }
                else{
                    end++;
                    start = end;
                    break;
                }
            }
            
        }
        
        
        return retList;
    }
}

