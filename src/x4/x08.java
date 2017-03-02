/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class x08 {
    public static void main(String[] args){
        //System.out.println(decodeString("2[abc]3[cd]ef"));
        //System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[2[b]]"));
        System.out.println(decodeString("sd2[f2[e]g]i"));
        System.out.println(decodeString("2[2[2[b]]]"));
    }
    
    //388. Longest Absolute File Path
    public int lengthLongestPath(String input) {
        String[] tokens = input.split("\n");
        int result = 0;
        int curLen = 0;
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            int level = countLevel(s);

            // if current directory/file depth is lower that the top directory/file on the stack, pop from stack 
            while (stack.size() > level) {
                curLen -= stack.pop();
            }

            // +1 here because a "/" needs to be counted following each diretory
            int len = s.replaceAll("\t", "").length() + 1;
            curLen += len;

            // if s contains ".", we have found a file!
            if (s.contains(".")) {
                result = curLen - 1 > result ? curLen - 1 : result;
            }
            stack.add(len);
        }
        return result;
    }
    
    private int countLevel(String s) {
        String cur = s.replaceAll("\t", "");
        return s.length() - cur.length();
    }
    
    //394. Decode String
    public static String decodeString(String s) {
        Stack<Integer> intStack = new Stack();
        Stack<String> strStack = new Stack();
        String retstr ="";
        int times = 0;
        String value = "";
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                if(intStack.isEmpty()) retstr += value;
                times = 10 * times + (s.charAt(i) - '0');                
                //value = "";               
            }else if(s.charAt(i) == '['){
                strStack.push(value);
                value = "";
                if(times != 0){
                    intStack.push(times);
                    times = 0;
                }                
            }else if(s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder (strStack.pop());
                int repeatTimes = intStack.pop();
                for (int j = 0; j < repeatTimes; j++) {
                    temp.append(value);
                }
                value = temp.toString();
            }else{
                value += String.valueOf(s.charAt(i));
            }
        }
        return value;
    }
}
