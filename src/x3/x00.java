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
        //findWords(new char[][]{"b".toCharArray(),"a".toCharArray(),"b".toCharArray()},"bbabab");
        shortestPalindrome("aaacebcaaa");
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
    static ArrayList<Integer>[] graph ;
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
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while(end < nums.length){
            while(sum < s && end < nums.length){
                sum += nums[end++];
            }
            while(sum >= s){
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }       
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    //210. Course Schedule II
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] incLinkCounts = new int[numCourses];
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<Integer>();
        }   
        for (int[] edge : prerequisites) {
            incLinkCounts[edge[0]]++;
            graph[edge[1]].add(edge[0]);
        }
        return solveByBFS(incLinkCounts);
        //return solveByDFS(adjs);
    }    
    private static int[] solveByBFS(int[] incLinkCounts){
        int[] order = new int[incLinkCounts.length];
        Queue<Integer> toVisit = new ArrayDeque<>();
        for (int i = 0; i < incLinkCounts.length; i++) {
            if (incLinkCounts[i] == 0) toVisit.offer(i);
        }
        int visited = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            order[visited++] = from;
            for (int to : graph[from]) {
                incLinkCounts[to]--;
                if (incLinkCounts[to] == 0) toVisit.offer(to);
            }
        }
        return visited == incLinkCounts.length ? order : new int[0]; 
    }
    
    private int[] solveByDFS(List<List<Integer>> adjs) {
        BitSet hasCycle = new BitSet(1);
        BitSet visited = new BitSet(adjs.size());
        BitSet onStack = new BitSet(adjs.size());
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = adjs.size() - 1; i >= 0; i--) {
            if (visited.get(i) == false && hasOrder(i, adjs, visited, onStack, order) == false) return new int[0];
        }
        int[] orderArray = new int[adjs.size()];
        for (int i = 0; !order.isEmpty(); i++) orderArray[i] = order.pop();
        return orderArray;
    }

    private boolean hasOrder(int from, List<List<Integer>> adjs, BitSet visited, BitSet onStack, Deque<Integer> order) {
        visited.set(from);
        onStack.set(from);
        for (int to : adjs.get(from)) {
            if (visited.get(to) == false) {
                if (hasOrder(to, adjs, visited, onStack, order) == false) return false;
            } else if (onStack.get(to) == true) {
                return false;
            }
        }
        onStack.clear(from);
        order.push(from);
        return true;
    }
    
    //211. Add and Search Word - Data structure design
    
    //212. Word Search II
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> retList = new ArrayList();
        for(int i = 0; i < words.length; i++){
            if(findWords(board, words[i])){
                if(!retList.contains(words[i])) retList.add(words[i]);
            }
        }
        return retList;
    }
    
    public static boolean findWords(char[][] board, String word){
        int len = board.length;
        int wid = board[0].length;
        boolean[][] visited = new boolean[len][wid];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < wid; j++){
                if(findWords(board, word, 0, visited, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean findWords(char[][] board, String word, int idx, boolean[][] visited, int i, int j){
        if(idx == word.length()) return true;
        int len = board.length;
        int wid = board[0].length;
        if(i < 0 || j < 0 || i == len || j == wid) return false;        
        if(word.charAt(idx) == board[i][j] && !visited[i][j]){
            visited[i][j] = true;
            boolean result = (findWords(board, word, idx + 1, visited, i + 1, j)) ||
                    (findWords(board, word, idx + 1, visited, i, j + 1)) ||
                    (findWords(board, word, idx + 1, visited, i - 1, j)) ||
                    (findWords(board, word, idx + 1, visited, i, j - 1));
            visited[i][j] = false;
            return result;
        }        
        return false;
    }
    
    //213. House Robber II
    /*public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] nums1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, nums.length);
                
        nums1[1] = Math.max(nums1[0], nums1[1]);
        for(int i = 2; i < nums1.length; i++){
            nums1[i] = Math.max(nums1[i] + nums1[i - 2], nums1[i-1]);
        } 
        nums2[1] = Math.max(nums2[0], nums2[1]);
        for(int i = 2; i < nums2.length; i++){
            nums2[i] = Math.max(nums2[i] + nums2[i - 2], nums2[i-1]);
        } 
        
        return Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
    }*/
    
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    private int rob(int[] num, int lo, int hi) {
        int include = 0, exclude = 0;
        for (int j = lo; j <= hi; j++) {
            int i = include, e = exclude;
            include = e + num[j];
            exclude = Math.max(e, i);
        }
        return Math.max(include, exclude);
    }
    
    //214. Shortest Palindrome
    public static String shortestPalindrome(String s) {
        int j = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(j)) { j += 1; }
        }
        if (j == s.length()) { return s; }
        String suffix = s.substring(j);
        String test = new StringBuffer(suffix).reverse().toString();
        test = shortestPalindrome(s.substring(0, j));
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
    }
    
    //215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k){
             return 0;
         }
         Queue<Integer> pq = new PriorityQueue<Integer>(k);
         for(int i = 0; i < nums.length; i++){
             if(i < k){
                 pq.add(nums[i]);
             }else{
                 if(nums[i] > pq.peek()){
                     pq.poll();
                     pq.add(nums[i]);
                 }
             }
         }
         return pq.peek();
    }
    
    //216. Combination Sum III
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> retList = new ArrayList();
        List<Integer> curList = new ArrayList();
        for(int i = 1; i < n/k && i < 10; i++){
            curList = new ArrayList();
            curList.add(i);
            combinationSum3(i + 1, k - 1, n - i, retList, curList);
        }
        return retList;
    }
    
    public static void combinationSum3(int start, int k, int n, List<List<Integer>> retList, List<Integer> curList){
        if(start > n) return;
        if(start <= n && k ==1 && n < 10){
            List<Integer> tmpList = new ArrayList(curList);
            tmpList.add(n);
            retList.add(tmpList);
            return;
        }
        for(int i = start; i < 10; i++){
            List<Integer> tmpList = new ArrayList(curList);
            tmpList.add(i);
            combinationSum3(i + 1, k - 1, n - i, retList, tmpList);
        }
    }
    
    //217. Contains Duplicate
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> iset = new HashSet();
        for(int i : nums){
            if(!iset.add(i)) return true;
        }
        return false;
    }
    
    //218. The Skyline Problem
    public List<int[]> getSkyline(int[][] buildings) {    
        //buildings [Li, Ri, Hi]
        Comparator<int[]> c = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        Arrays.sort(buildings, c);
        List<int[]> retList = new ArrayList<>();
        return null;
    }
    
    //219. Contains Duplicate II
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> iMap = new HashMap();
        for(int i = 0; i < nums.length; i++){
            if(iMap.containsKey(nums[i])){
                if(k >= i - iMap.get(nums[i])) return true;
            }
            iMap.put(nums[i], i);
        }
        return false;
    }
    
    //220. Contains Duplicate III
      /*Given an array of integers, find out whether there are two distinct indices i and j in the array
        such that the difference between nums[i] and nums[j] is at most t and the difference
        between i and j is at most k.*/
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }
}
