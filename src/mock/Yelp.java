/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class Yelp {
    public static void main(String args[]){
        String[] input1 = new String[]{"ab", "bar", "foo"};
        String[] input2 = new String[]{"bar", "foo", "de"};
        System.out.println(restaurant(input1,input2));
    }
    
    public static String restaurant(String[] input1, String[] input2){
        HashMap<String, Integer> restmap = new HashMap<>();
        String retval = "No Ans";
        for(int i = 0; i < input1.length; i++){
            restmap.put(input1[i], i);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < input2.length; i++){
            if(restmap.containsKey(input2[i])){
                if(min > i + restmap.get(input2[i])){
                    min = i + restmap.get(input2[i]);
                    retval = input2[i];
                }
            }
        }
        
        return retval;
    }
    
    public static List<String> topColor(List<List<String>> image) {
        // change me!
        HashMap<String, Integer> colMap = new HashMap<>();
        for(int i = 0; i < image.size(); i++){
            for(int j = 0; j < image.get(i).size(); j++){
                String color = image.get(i).get(j);
                if(colMap.containsKey(color)){
                    colMap.put(color, colMap.get(color) + 1);
                }else{
                    colMap.put(color, 1);
                }
            }
        }
        int max = 0;
        List<String> retList = new ArrayList<>();
        Iterator it = colMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            if((int)pair.getValue() > max){
                retList.clear();
                retList.add((String)pair.getKey());
            }else if((int)pair.getValue() == max){                
                retList.add((String)pair.getKey());
            }
            it.remove();
        }        
        return retList;
    }
}
