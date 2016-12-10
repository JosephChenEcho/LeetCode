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
    
    }
    
    //241. Different Ways to Add Parentheses
    public List<Integer> diffWaysToCompute(String input) {
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
        
        return null;
    }
    
    public List<Integer> compute(List<Integer> iList, List<Character> cList, int istart, int iend){
        List<Integer> retList = new ArrayList();
        if(istart == iend){
            retList.add(iList.get(istart));
            return retList;
        }
        for(int i = istart; i <= iend; i++){
            
        }
        return null;
    }
}
