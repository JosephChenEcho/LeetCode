/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;
import java.util.*;
/**Unsolved Hard: 123, 124, 126, 128, 132, 135, 138, 140
 * 
 *
 * @author Joseph
 */
public class x02 {
    public static void main(String[] args){
        /*HashSet<String> set = new HashSet();
        set.add("a");
        set.add("b");
        set.add("c");
        ladderLength("a","c",set);*/
        /*
        UndirectedGraphNode input1 = new UndirectedGraphNode(1);
        UndirectedGraphNode input2 = new UndirectedGraphNode(2);
        UndirectedGraphNode input3 = new UndirectedGraphNode(3);
        input1.neighbors.add(input2);
        input1.neighbors.add(input3);
        input2.neighbors.add(input3);
        input3.neighbors.add(input3);
        
        UndirectedGraphNode output = cloneGraph(input1);*/
        int[] gas = new int[]{0,5,6};
        int[] cost = new int[]{1,2,3};
        System.out.println(canCompleteCircuit(gas,cost));
                
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
    
    //133. Clone Graph
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        UndirectedGraphNode graph = new UndirectedGraphNode(node.label);      
        List<UndirectedGraphNode> nodeneigh = node.neighbors;
        for(UndirectedGraphNode n : nodeneigh){
            if(n == node){
                graph.neighbors.add(node); 
            }else{
                graph.neighbors.add(cloneGraph(n));
            }
        }
        return graph;
    }
    
    //134. Gas Station
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length == 0) return -1;
        int i;
        for(i = 0; i < gas.length; i++){
            int gasTank = gas[i] - cost[i];
            int j = i;
            while(gasTank > 0 && j != i - 1){
                j++;
                if(j >= gas.length) j -= gas.length;
                if(gasTank < 0) break;
                gasTank += gas[j] - cost[j];
                
            }
            if(j == i) break;
        }
        if(i == gas.length) return -1;
        return i;
    }
}
