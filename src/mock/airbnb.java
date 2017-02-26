/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 * @author Joseph
 */
public class airbnb {
    public static void main(String[] args){
        //String[] input = {"1,28,300.6,San Francisco","4,5,209.1,San Francisco","20,7,203.4,Oakland","6,8,202.9,San Francisco","6,10,199.8,San Francisco","1,16,190.5,San Francisco","6,29,185.3,San Francisco","7,20,180.0,Oakland",
        //    "6,21,162.2,San Francisco","2,18,161.7,San Jose","2,30,149.8,San Jose","3,76,146.7,San Francisco","2,14,141.8,San Jose"};
        String[] input = {"1,28,300.1,Melbourne","4,5,209.1,Melbourne",
"5,7,208.1,Melbourne",
"1,8,207.1,Melbourne" ,
"1,10,206.1,Melbourne" ,
"2,16,205.1,Melbourne" ,
"1,29,204.1,Melbourne" ,
"6,20,203.1,Melbourne" ,
"1,21,202.1,Melbourne" ,
"8,18,201.1,Melbourne" ,
"8,30,200.1,Melbourne" ,
"7,11,199.1,Melbourne"};
        paginate(5,input);
        
    }
    static void StairCase(int n) {
        for(int i = 0; i < n; i++){
            printspace(n - i - 1);
            printsharp(i + 1);
            System.out.println();
        }
    }
    
    static void printspace(int n){
        for(int i = 0; i < n; i++){
            System.out.print(" ");
        }
    }
    
    static void printsharp(int n){
        for(int i = 0; i < n; i++){
            System.out.print("#");
        }    
    }
    
    static int summation(int[] numbers) {
        int len = numbers[0];
        int sum = 0;
        for(int i = 1; i <= numbers.length; i++){
            sum += numbers[i];
        }
        return sum;

    }
    
    static String[] paginate(int num, String[] results){
        
        List<String> resList = new ArrayList(Arrays.asList(results));
        HashSet<Integer> idSet = new HashSet();
        List<String> retList = new ArrayList();
        int i = 0;
        Boolean visitEnd = false;
        while(!resList.isEmpty()){
            String strres = resList.get(i);
            int id = Integer.parseInt(strres.split(",")[0]);
            if(!idSet.contains(id)){
                if(!visitEnd){
                    idSet.add(id);
                } 
                retList.add(strres);
                resList.remove(i);
                //page spearator; reset HashSet
                if((retList.size() + 1) % (num + 1) == 0){
                    retList.add("");
                    idSet = new HashSet();
                    i = 0;
                    visitEnd = false;
                }
            }else{
                i++;                
            }
            if(i >= resList.size()){
                visitEnd = true;
                idSet = new HashSet();
                i = 0;
            }
        }
        String[] retarr = retList.toArray(new String[retList.size()]);
        return retarr;
    }
    
}
