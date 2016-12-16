/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;

/**
 *
 * @author Joseph
 */
public class x06 {
    public static void main(String[] args){
            
    }
    
    //263. Ugly Number
    public boolean isUgly(int num) {
        while(num%2==0&&num!=0){
            num /=2;
        }
        while(num%3==0&&num!=0){
            num /=3;
        }
        while(num%5==0&&num!=0){
            num /=5;
        }
        if(num == 1) return true; 
        return false;
    }
    
    //264. Ugly Number II
    public int nthUglyNumber(int n) {
        int i = 0;
        int num = 0;
        while(i < n){
            
        }
        
        return -1;
    }
}
