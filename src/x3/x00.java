/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x3;

import java.util.*;

/**Unsolved Hard:
 * 212, 214, 218
 * 
 * @author jochen
 */
public class x00 {
    public static void main(String args[]){
        int input = 1329;
        while(input != 1){
            int ret = 0;
            while(input != 0){
                int mod = input % 10;
                ret += mod * mod;
                input /= 10;
            }
            System.out.println("ret = " + ret);
            input = ret;
        }
    }
    //202. Happy Number
    public boolean isHappy(int n) {
        HashSet<Integer> intSet = new HashSet();
        while(n != 1){
            int ret = 0;
            while(n != 0){
                int mod = n % 10;
                ret += mod * mod;
                n /= 10;
            }
            
            n = ret;
            if(!intSet.add(n)) return false;
        }
        return true;
    }
    
    //203. Remove Linked List Elements
    public ListNode removeElements(ListNode head, int val) {
        return null;
    }
    
    //204. Count Primes
    public int countPrimes(int n) {
        return -1;
    }
}
