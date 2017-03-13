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
        List<String> retList = new ArrayList<String>();
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
