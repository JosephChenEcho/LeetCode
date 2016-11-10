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
        minSubArrayLen(4, new int[]{2,3,1,2,4,3});
    }
    //201
    
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
    
    //205. Isomorphic Strings
    public boolean isIsomorphic(String s, String t) {
	if(s == null || t == null) return false;
        if(s == "") return t == "";
        if(t == "") return false;    
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
//            if(s.lastIndexOf(c1) != t.lastIndexOf(c2))
            if(s.indexOf(c1) != t.indexOf(c2))
                return false;
        }    
        return true;
    }
    
    //206. Reverse Linked List
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode ret = null;
        while(head != null){
            ListNode tmp = head;            
            head = head.next;
            tmp.next = ret;
            ret = tmp;
        }    
        return ret;
    }
    
    //207. Course Schedule
    ArrayList<Integer>[] graph ;
    boolean[] isVisited;
    boolean[] courseOK;
    public boolean canFinish(int numCourses, int[][] preR) {
        graph = new ArrayList[numCourses];    
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }   
        for(int i = 0; i < preR.length; i++) {
            graph[preR[i][1]].add(preR[i][0]);
        }
        isVisited = new boolean[numCourses];     // if the course have been visited.
        courseOK = new boolean[numCourses];      // if the course have been tested before to be available.

        for(int i = 0; i < numCourses; i++) {
           if (!dfs(i)) {
               return false;
           } 
        }
        return true;
    }

    private boolean dfs(int course) {
        if (courseOK[course]) return true; 
        if (isVisited[course]){
            return false;
        }else {
            isVisited[course] = true;
        }

        ArrayList<Integer> curPre = graph[course];

        for(Integer preRe: curPre) {
            if (!dfs(preRe)){
                return false;
            }
        }
        isVisited[course] = false;
        courseOK[course] = true;
        return true;
    }
    //208. Implement Trie (Prefix Tree)
    
    //209. Minimum Size Subarray Sum
    public static int minSubArrayLen(int s, int[] nums) {
        /*int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = 0;
            for(int j = 0; j + i < nums.length;j++){
                sum += nums[j + i];
                if(sum >= s){
                    min = Math.min(min, j + 1);
                    break;
                }
            }            
        }        
        return min == Integer.MAX_VALUE ? 0 : min;*/
        int start = 0;
        int end = 0;
        int sum = 0;
        int min;
        while(sum < s && end < nums.length){
            sum += nums[end++];
        }
        if(end == nums.length) return 0;
        min = end;
        //end--;
        while (!(end == nums.length && sum < s)){
            //init
            while(sum >= s){
                sum -= nums[start++];
            }
            start--;
            int tmp = end - start;
            min = Math.min(min, tmp);
            while(sum < s && end < nums.length){
                sum += nums[end++];
            }
        }
        
        return min;
    }
    
    //210. Course Schedule II
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        return null;
    }
}
