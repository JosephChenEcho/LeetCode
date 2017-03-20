/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;
import java.util.*;
/**
 *
 * @author jochen
 */
public class x02 {
    public static void main(String[] args){
        //String[][] input = new String[][]{{"MUC","LHR"},{"JKF","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        String[][] input = new String[][]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        findItinerary(input);
        lengthOfLongestSubstringKDistinct("",0);
    
    }
    //322. Coin Change
    public static int coinChange(int[] coins, int amount) {     
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 1;
    
	while(sum<=amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;
                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
            sum++;
	}
	return dp[amount];
        /*
        Arrays.sort(coins);
        int retval = coinChange(coins, amount, coins.length - 1);
        return retval;
        */
    }
    
    public static int coinChange(int[] coins, int amount, int idx){
        if(idx < 0) return -1;
        int count = 0;
        while(coins[idx] <= amount){
            count++;
            amount -= coins[idx];
        }
        if(amount == 0) return count;
        int nextcount = coinChange(coins, amount, idx - 1);
        while(nextcount == -1){
            count--;
            amount += coins[idx];
            if(count < 0) return -1;
            nextcount = coinChange(coins, amount, idx - 1);
        }
        return count + nextcount;
    }
    
    //324. Wiggle Sort II
    public void wiggleSort(int[] nums) {

    }
    
    //326. Power of Three
    public boolean isPowerOfThree(int n) {
        if(n == 0) return false;
        while( n % 3 == 0){
            n /= 3;
        }
        if(n == 1) return true;
        return false;
    }
    
    //328. Odd Even Linked List
    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        odd.next = head;
        ListNode even = new ListNode(-1);
        ListNode point = even;
        while(head.next != null){
            point.next = head.next;
            point = point.next;
            head.next = head.next.next;
            if(head.next != null) head = head.next;
        }
        if(point != null) point.next = null;
        head.next = even.next;
        return odd.next;
    }
    
    //331. Verify Preorder Serialization of a Binary Tree
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
    
    //332. Reconstruct Itinerary
    static Map<String, Queue<String>> flights;
    static LinkedList<String> path;

    public static List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }
        dfs("JFK");
        return path;
    }

    public static void dfs(String departure) {
        Queue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
    /*
    
    */
    
    //334. Increasing Triplet Subsequence
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= min) min = num;
            else if(num < secondMin) secondMin = num;
            else if(num > secondMin) return true;
        }
        return false;
    }
    
    //336. Palindrome Pairs
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(words == null || words.length == 0){
            return res;
        }
        //build the map save the key-val pairs: String - idx
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], i);
        }

        //special cases: "" can be combine with any palindrome string
        if(map.containsKey("")){
            int blankIdx = map.get("");
            for(int i = 0; i < words.length; i++){
                if(isPalindrome(words[i])){
                    if(i == blankIdx) continue;
                    res.add(Arrays.asList(blankIdx, i));
                    res.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        //find all string and reverse string pairs
        for(int i = 0; i < words.length; i++){
            String cur_r = reverseStr(words[i]);
            if(map.containsKey(cur_r)){
                int found = map.get(cur_r);
                if(found == i) continue;
                res.add(Arrays.asList(i, found));
            }
        }

        //find the pair s1, s2 that 
        //case1 : s1[0:cut] is palindrome and s1[cut+1:] = reverse(s2) => (s2, s1)
        //case2 : s1[cut+1:] is palindrome and s1[0:cut] = reverse(s2) => (s1, s2)
        for(int i = 0; i < words.length; i++){
            String cur = words[i];
            for(int cut = 1; cut < cur.length(); cut++){
                if(isPalindrome(cur.substring(0, cut))){
                    String cut_r = reverseStr(cur.substring(cut));
                    if(map.containsKey(cut_r)){
                        int found = map.get(cut_r);
                        if(found == i) continue;
                        res.add(Arrays.asList(found, i));
                    }
                }
                if(isPalindrome(cur.substring(cut))){
                    String cut_r = reverseStr(cur.substring(0, cut));
                    if(map.containsKey(cut_r)){
                        int found = map.get(cut_r);
                        if(found == i) continue;
                        res.add(Arrays.asList(i, found));
                    }
                }
            }
        }

        return res;
    }

    public String reverseStr(String str){
        StringBuilder sb= new StringBuilder(str);
        return sb.reverse().toString();
    }

    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    //337. House Robber III
    public int rob(TreeNode root) {
        int[] ret = dprob(root);
        return Math.max(ret[0], ret[1]);
    }
    
    public int[] dprob(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }else{
            int[] retval = new int[2]; //[0] withour rob root; [1] rob root
            int[] left = dprob(root.left);
            int[] right = dprob(root.right);
            retval[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            retval[1] = root.val + left[0] + right[0];            
            return retval;
        }
    }
    
    //338. Counting Bits
    public int[] countBits(int num) {
        if(num == 0) return new int[]{0};
        int[] retval = new int[num+1];
        retval[0] = 0;
        retval[1] = 1;
        int delta = 2;
        for(int i = 2; i <= num;){
            while(i < 2 * delta && i <= num){
                retval[i] = 1 + retval[i - delta];
                i++;
            }
            delta *= 2;
            
        }
        return retval;
    }
    
    //340. Longest Substring with At Most K Distinct Characters
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int res = 0;
        HashMap <Character,Integer> cMap = new HashMap();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!cMap.containsKey(c)){
                cMap.put(c, 1);
            }else{
                int n = cMap.get(c);
                cMap.put(c, n + 1);
            }
            while(cMap.size() > k){
                c = s.charAt(start);
                int n = cMap.get(c);
                if(n != 1){
                    cMap.put(c, n - 1);
                }else{
                    cMap.remove(c);
                }
            }
            res = Math.max(res, i - start + 1);
            start ++;            
        }
        
        return res;
    }

}
