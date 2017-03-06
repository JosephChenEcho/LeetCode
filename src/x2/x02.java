/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;
import java.util.*;
/**Unsolved Hard: 123, 124, 126, 128, 135, 138, 140
 * 
 *
 * @author Joseph
 */
public class x02 {
    public static void main(String[] args){
        //wordBreak
        String str = "catsanddog";
        List<String> input = new ArrayList();
        input.add("cat");
        input.add("cats");
        input.add("and");
        input.add("sand");
        input.add("dog");

        wordBreak(str,input);
               // ["cat","cats","and","sand","dog"]
                
    }
    
    //121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int max = 0;
        if(prices.length <= 1) return max;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < min) min = prices[i];
            if(prices[i] - min > max) max = prices[i] - min;
        }        
        return max;
    }
    
    //122. Best Time to Buy and Sell Stock II
    public int maxProfit2(int[] prices) {
        int max = 0;
        boolean buy = false;
        int buyPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length - 1; i++){
            if(!buy && prices[i] < prices[i + 1]){
                //buy stock
                buyPrice = prices[i];
                buy = true;
                continue;
            }
            if(buy && prices[i] > prices[i + 1]){
                max += prices[i] - buyPrice;
                buy = false;
            }
        } 
        if(buy && prices[prices.length - 1] > buyPrice){
            max += prices[prices.length - 1] - buyPrice;
        }
        return max;
    }
    
    //125. Valid Palindrome
    public boolean isPalindrome(String s) {
        char[] carr = s.toLowerCase().toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            while(i <= j && !isalphanumeric(carr[i])) i++;
            while(i <= j && !isalphanumeric(carr[j])) j--;
            if(carr[i] != carr[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public boolean isalphanumeric(char c){
        return (c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')||(c >= '0' && c <= '9');
    }
    
    //127. Word Ladder
    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        /*
        if(beginWord.length() != endWord.length()) return 0;
        int len = beginWord.length();
        if(len == 0) return 0;
        if(beginWord.equals(endWord)) return 0;
        for(String str : wordList){
            if(len != str.length()) wordList.remove(str);
        }        
        if(wordList.isEmpty()) return 0;
        
        //Init               
        HashMap<String,Integer> wordMap = new HashMap();
        for(String str : wordList){
            if(!wordMap.containsKey(str)){
                wordMap.put(str, 0);
            }
        }
        if(!wordMap.containsKey(endWord)){
            wordMap.put(endWord, 0);
        }
        
        List<String> preTouchList = new ArrayList();
        List<String> touchList = new ArrayList();
        touchList.add(beginWord);
        int count = 0;
        while(touchList.size() != preTouchList.size() && wordMap.get(endWord) == 0){
            preTouchList = new ArrayList(touchList);
            for(String str : preTouchList){
                count = wordMap.get(str);
                for(Map.Entry<String, Integer> e : wordMap.entrySet()){
                    if(e.getValue() == 0 && isLadder(e.getKey(),str)){
                        wordMap.put(e.getKey(), count + 1);
                        touchList.add(e.getKey());
                    }
                }
            }
        }        
        int retint = wordMap.get(endWord);
        if(wordList.contains(endWord) && retint > 0) retint++;
        return retint;
*/
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }
    
    public static boolean isLadder(String begin, String end){
        int diff = 0;
        for(int i = 0; i < begin.length(); i++){
            if(begin.charAt(i) != end.charAt(i)) diff++;
            if(diff > 1) return false;
        }
        return diff == 1;
    }
    
    //128. Longest Consecutive Sequence
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length 
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }
    

    
    //129. Sum Root to Leaf Numbers
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        List<TreeNode> treeList = new ArrayList();
        treeList.add(root);
        while(!treeList.isEmpty()){
            List<TreeNode> tmpList = new ArrayList();
            for(TreeNode t : treeList){
                if(t.left != null){
                    t.left.val += t.val * 10;
                    tmpList.add(t.left);
                }
                if(t.right != null){
                    t.right.val += t.val * 10;
                    tmpList.add(t.right);
                }                
                if(t.left == null && t.right == null){
                    sum += t.val;
                }
            }
            treeList = tmpList;
        }
        return sum;
    }
    
    //131. Palindrome Partitioning
    public static List<List<String>> partition(String s) {
        List<List<String>> retlist = new ArrayList();
        for(int i = 1; i < s.length(); i++){
            if(isPalind(s.substring(0, i))){
                for(List<String> lstr : partition(s.substring(i))){
                    List<String> solstr = new ArrayList();
                    solstr.add(s.substring(0,i));
                    solstr.addAll(lstr);
                    retlist.add(solstr);
                }
            }
        }      
        if(isPalind(s)){
            List<String> solstr = new ArrayList();
            solstr.add(s);
            retlist.add(solstr);
        }
        return retlist;
    }
    
    public static boolean isPalind(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }        
        return true;
    }
    
    //132. Palindrome Partitioning II
    public static int minCut(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] cut = new int[n];
        boolean[][] pal = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = 0; j <= i; j++) {
                if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;  
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }
            }
            cut[i] = min;
        }
        return cut[n - 1];
    }
    
    
    //133. Clone Graph
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
    
    //134. Gas Station
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                start = i+1;
            }
        }
        return total < 0 ? -1 : start;
    }
    
    //135. Candy
    public static int candy(int[] ratings) {
        int len = ratings.length;
        if(len == 0) return 0;
        if(len == 1) return 1;
        int result = 1, curCandy = 1, temp;
        
        for(int i=1;i<len;){
            if(ratings[i] > ratings[i-1]){
                curCandy++;
                result += curCandy;
                i++;
            }
            else if(ratings[i] == ratings[i-1]){
                curCandy = 1;
                result += curCandy;
                i++;
            }
            else{
                temp = curCandy;
                curCandy = 1;
                result += curCandy;
                while(i<len && ratings[i] < ratings[i-1]){
                    curCandy++;
                    result += curCandy;
                    i++;
                }
                result -= temp<curCandy?temp:curCandy;
                curCandy = 1;
                if(i == len) return result;
            }
        }        
        return result;
    }
    
    //136. Single Number
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]);
            }
        }
        Object[] ret = set.toArray();
        return (int)ret[0];
    }   
    
    //137. Single Number II
    public int singleNumber2(int[] nums) {
        //Arrays.sort(nums);
        //for(int i = 0)        
        return -1;
    }
        
    //138. Copy List with Random Pointer    
    private HashMap<Integer, RandomListNode> randMap = new HashMap();
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode cur = head;
        while(cur != null){
            randMap.put(cur.label, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            randMap.get(cur.label).next = cur.next == null ? null : randMap.get(cur.next.label);
            randMap.get(cur.label).random = cur.random == null ? null : randMap.get(cur.random.label);
            cur = cur.next;
        }
        return randMap.get(head.label);
        /*int val = head.label;
        if(randMap.containsKey(val)){
            return randMap.get(val);
        }        
        RandomListNode copyNode = new RandomListNode(head.label);
        randMap.put(val, copyNode);
        copyNode.next = copyRandomList(head.next);
        copyNode.random = copyRandomList(head.random);
        return copyNode;*/
    }
    
    
    //139. Word Break
    public static boolean wordBreak(String s, Set<String> wordDict) {
        /*if(s == null && wordDict.isEmpty()) return true;
        if(s == null || wordDict.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String debugstr = s.substring(j,i);
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        
        return dp[s.length()];*/
        if(s == null && wordDict.isEmpty()) return true;
        if(s == null || wordDict.isEmpty()) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 0; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    //break;
                }
            }
        }
        return dp[s.length()];
    }
    
    //140. Word Break II
    private static HashMap<String, List<String>> wordMap = new HashMap();
    public static List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet();
        for(String str : wordDict){wordSet.add(str);};
        if(wordMap.containsKey(s) && !wordMap.get(s).isEmpty()){
            return wordMap.get(s);
        }
        List<String> cur = new ArrayList();
        for(String str: wordDict){
            if(s.startsWith(str)){
                List<String> rest = wordBreak(s.substring(str.length()), wordDict);
                if(s.equals(str)){
                    cur.add(str);
                }
                for(String strrest: rest){
                    cur.add(str + " " + strrest);
                }
                
            }
        }
        wordMap.put(s, cur);
        return cur;
    }

}
