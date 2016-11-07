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
        System.out.println(countPrimes(5));
        
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
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode point = pre;
        while(point.next != null){
            if(point.next.val != val){
                point = point.next;
            }else{
                point.next = point.next.next;
            }
        }
        
        return pre.next;
    }
    
    //204. Count Primes
    public static int countPrimes(int n) {
        /*List<Integer> iList = new ArrayList();
        for(int i = 2; i <n; i++) iList.add(i);
        for(int i = 0; i < iList.size(); i++){
            int prime = iList.get(i);
            int m = 2;
            int last = iList.get(iList.size() - 1);
            while(m * prime <= last){
                if(iList.contains(m * prime)) iList.remove((Object)(m*prime));
                m++;
            }
        }
        
        return iList.size();
        int[] prime = new int[n+1];
        int count=0;
        for(int i=2;i<n;i++){
            if(prime[i]==-1) continue;
            count++;
            for(int j=i;n/i>=j;j++) prime[i*j]=-1;
        }
        return count;*/
        int[] numarr = new int[n+1];
        int count = 0;
        for(int i=2; i < n; i++){
            if(numarr[i] == -1) continue;
            count++;
            for(int j = 2; i*j < n; j++){
                numarr[i*j] = -1;
            }
        }
        return count;
    }
}
