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
public class x08 {
    public static void main(String[] args){        
        getHint("1122","2211");

    }
    
    //283. Move Zeroes
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        while(i < len){
            while(i < len && nums[i] == 0){
                i++;
            }
            if(i == len) break;
            nums[j] = nums[i];
            j++;
            i++;
        }
        while(j < len){
            nums[j] = 0;
            j++;
        }
    }
    
    //289. Game of Life
    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dieOrLive(i, j, board, m, n);
            }
        }        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] /= 2;
            }
        }    
    }
    
    public static void dieOrLive(int i, int j, int[][] board, int m, int n){
        int count = 0;
        if(board[i][j] == 1){
            if(i > 0 && board[i-1][j]%2 == 1) count++;
            if(i < m - 1 && board[i+1][j]%2 == 1) count++;
            if(j > 0 && board[i][j-1]%2 == 1) count++;
            if(j < n - 1 && board[i][j+1]%2 == 1) count++;
            if(i > 0 && j > 0 && board[i-1][j-1]%2 == 1) count++;
            if(i > 0 && j < n - 1 && board[i-1][j+1]%2 == 1) count++;
            if(i < m - 1 && j > 0 && board[i+1][j-1]%2 == 1) count++;
            if(i < m - 1 && j < n - 1 && board[i+1][j+1]%2 == 1) count++;
            if(count == 2 || count == 3) board[i][j] += 2;
        }else{
            if(i > 0 && board[i-1][j]%2 == 1) count++;
            if(i < m - 1 && board[i+1][j]%2 == 1) count++;
            if(j > 0 && board[i][j-1]%2 == 1) count++;
            if(j < n - 1 && board[i][j+1]%2 == 1) count++;
            if(i > 0 && j > 0 && board[i-1][j-1]%2 == 1) count++;
            if(i > 0 && j < n - 1 && board[i-1][j+1]%2 == 1) count++;
            if(i < m - 1 && j > 0 && board[i+1][j-1]%2 == 1) count++;
            if(i < m - 1 && j < n - 1 && board[i+1][j+1]%2 == 1) count++;
            if(count == 3) board[i][j] = 2;
        }
    }
    
    //290. Word Pattern
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        char[] pats = pattern.toCharArray();
        if(words.length != pats.length) return false;
        HashMap<Character, String> map = new HashMap();
        for(int i = 0 ; i < pats.length; i++){
            if(map.containsKey(pats[i])){
                if(!map.get(pats[i]).equals(words[i])){
                    return false;
                }
            }else if(map.containsValue(words[i])){
                if(!map.containsKey(pats[i]) || !map.get(pats[i]).equals(words[i])){
                    return false;
                }
            }else{
                map.put(pats[i], words[i]);
            }
        }        
        return true;
    }
    
    //292. Nim Game
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
    
    //299. Bulls and Cows
    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        /*int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g) bulls++;
            else {
                numbers[s] ++;
                numbers[g] --;
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;                
            }
        }
        return bulls + "A" + cows + "B";*/
        Boolean[] useds = new Boolean[secret.length()];
        Boolean[] usedg = new Boolean[secret.length()];
        for(int i = 0; i < secret.length(); i++){
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            useds[i] = false;
            usedg[i] = false;
            if (s == g) {
                bulls++;
                useds[i] = true;
                usedg[i] = true;
            }
        }
        for(int i = 0; i < secret.length(); i++){            
            int s = Character.getNumericValue(guess.charAt(i));
            for(int j = 0; j < secret.length(); j++){
                int g = Character.getNumericValue(secret.charAt(j));
                if(s == g){
                    if(!(useds[i]&&usedg[j]))
                    {cows++;
                    usedg[i] = true;
                    useds[j] = true;
                    }
                }
            }
        }
        
        return bulls + "A" + cows + "B";              
    }
}
