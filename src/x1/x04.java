/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;
//import java.math.*;

/**Unsolved Hard:
 * 41, 42, 44, 45, 52(Can improve), 56
 * Solved 51
 * @author Joseph
 */
public class x04 {
    public static void main(String[] args){
        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        trap(input);
    }
    
    //42. Trapping Rain Water
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        while(left < right && height[left] <= height[left + 1]){
            left = left + 1;
        }
        while(left < right && height[right] <= height[right - 1]){
            right = right - 1;
        }        
        int sum = 0;
        while(left < right){
            int leftedge = height[left];
            int rightedge = height[right];
            if(leftedge < rightedge){
                while(left < right && leftedge > height[++left]){
                    sum += leftedge - height[left];
                }
            }else{
                while(left < right && rightedge > height[--right]){
                    sum += rightedge - height[right];
                }
            }
        }
        return sum;
    }
    
    //43. Multiply Strings
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }  

        StringBuilder sb = new StringBuilder();
        for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
        return sb.length() == 0 ? "0" : sb.toString();
    }
    
    //45. Jump Game II
    public int jump(int[] nums) {
        int maxReach = nums[0];
        int edge = 0;
        int minstep = 0;
        for(int i = 1; i < nums.length; i++) {
            if (i > edge) {
                minstep += 1;                
                edge = maxReach;
                if(edge > nums.length - 1)
                    return minstep;
            }
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach == i){
                return -1;
            }
        }
        return minstep;
    }
    
    //46. Permutations
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retlist = new ArrayList<>();
        List<Integer> numlist = new ArrayList();
        for(int i : nums){
            numlist.add(i);
        }                     
        return permuteSet(retlist, numlist);
    }
    
    public static List<List<Integer>> permuteSet(List<List<Integer>> inlist, List<Integer> innums){
        List<List<Integer>> outlist = new ArrayList();
        if (innums.size() == 0) return inlist;
        if (inlist.size() == 0){
            for(int i = 0; i < innums.size(); i++){
                List<Integer> outnums = new ArrayList(innums);
                List<Integer> tmplist = new ArrayList();
                tmplist.add(innums.get(i));
                outnums.remove(i);
                List<List<Integer>> tlist = new ArrayList();
                tlist.add(tmplist);
                //outlist.addAll(permuteSet( tlist,outnums));
                for(List<Integer> als : permuteSet(tlist ,outnums)){
                    if(!outlist.contains(als)) outlist.add(als);
                }
            }     
            return outlist;
        }
        for(List<Integer> al : inlist){
            for(int i = 0; i < innums.size(); i++){
                List<Integer> outnums = new ArrayList(innums);
                List<Integer> tmplist = new ArrayList(al);
                tmplist.add(innums.get(i));
                outnums.remove(i);
                List<List<Integer>> tlist = new ArrayList();
                tlist.add(tmplist);
                //outlist.addAll(permuteSet(tlist ,outnums));
                for(List<Integer> als : permuteSet(tlist ,outnums)){
                    if(!outlist.contains(als)) outlist.add(als);
                }
            }
        }
        return outlist;
    }
    
    //47. Permutations II Need more understanding on it
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums == null || nums.length == 0) return ret;        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];        
        permuteHelper(nums, 0, ret, used, new ArrayList<Integer>());        
        return ret;
    }
    
    public static void permuteHelper(int[] nums, int len, List<List<Integer>> ret, boolean[] used, List<Integer> curr) {
        System.out.print("Set :");
        for(int i : curr){
            System.out.print(i + ",");
        }
        System.out.print("len = "+len);
        for(boolean i : used){
            System.out.print(i + ",");
        }
        System.out.println();
        
        if (len == nums.length) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                    continue;
                }
                used[i] = true;
                curr.add(nums[i]);
                permuteHelper(nums, len + 1, ret, used, curr);
                curr.remove(curr.size() - 1);
                used[i] = false;
            }
        }
    }
    
    //48. Rotate Image
    public static void rotate(int[][] matrix) {
        //if len =6 mid: 3/3
        //if len = 7 mid 4/3
        int limitx = (matrix.length + 1)/2;
        int limity = matrix.length - limitx;
        int lefttopx = 0;
        int lefttopy = 0;
        int righttopx = matrix.length - 1;
        int righttopy = 0;
        int leftbottomx = 0;
        int leftbottomy = matrix.length - 1;
        int rightbottomx = matrix.length - 1;
        int rightbottomy = matrix.length - 1;
        
        for(int i = 0; i < limitx; i++){
            for(int j = 0; j < limity; j++){
                int tmp = matrix[lefttopx + i][lefttopy + j];
                matrix[lefttopx + i][lefttopy + j] = matrix[righttopx - j][righttopy + i];
                matrix[righttopx - j][righttopy + i] = matrix[rightbottomx - i][rightbottomy - j];
                matrix[rightbottomx - i][rightbottomy - j] = matrix[leftbottomx + j][leftbottomy - i];
                matrix[leftbottomx + j][leftbottomy - i] = tmp;
            }
        }
    }   

    //49. Group Anagrams    
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> retlist = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return retlist;
        }
        HashMap<String, List<String>> groupSet = new HashMap();
        for(String str :strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String mark = String.valueOf(chars);
            if(groupSet.containsKey(mark)){
                groupSet.get(mark).add(str);
            }else{
                List<String> tmp = new ArrayList();
                tmp.add(str);
                groupSet.put(mark, tmp);
            }
        }
        for(Map.Entry ent : groupSet.entrySet()){
            retlist.add((List<String>)ent.getValue());
        }
        
        return retlist;
    }  
    
    //50. Pow(x, n)
    public static double myPow(double x, int n) {
        double temp=x;
        if(n==0) return 1;
        temp=myPow(x,n/2);
        if(n%2==0) return temp*temp;
        else {
            if(n > 0) return x*temp*temp;
            else return (temp*temp)/x;
        }
    }
    
    //51. N-Queens
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> retlist = new ArrayList();        
        int[] board = new int[n];
        nQueenHelper(retlist, board, 0);        
        return retlist;
    }
    
    public static Boolean nQueenHelper(List<List<String>> retlist, int[] inboard,int idx){
        if(idx >= inboard.length){
            /*System.out.print("Solution : ");
            for(int i : inboard){
                System.out.print(i + ",");
            }
            System.out.println();*/
            List<String> solutionlist = new ArrayList();
            for(int iq : inboard){
                char[] cstr = new char[inboard.length];
                for(int i = 0; i < cstr.length; i++){
                    cstr[i] = '.';                    
                }
                cstr[iq] = 'Q';
                solutionlist.add(String.valueOf(cstr));
            }
            retlist.add(solutionlist);
            return true;
        }
        
        for(int i = 0; i < inboard.length; i++){
            int[] outboard = inboard.clone();
            outboard[idx] = i;
            if(validBoard(outboard,idx)){
                nQueenHelper(retlist,outboard,idx + 1);
            }
        }
        
        return false;
    }
    
    public static Boolean validBoard(int[] board, int idx){
        for(int i = 0; i < idx; i++){
            if(board[i] == board[idx]) return false;
            if(Math.abs(board[i] - board[idx]) == (idx - i) ) return false;
        }        
        return true;
    }
    
    //52. N-Queens II
    public static int totalNQueens(int n) {        
        List<List<String>> retlist = new ArrayList();        
        int[] board = new int[n];
        nQueenHelper(retlist, board, 0);        
        return retlist.size();
    }
    
    //53. Maximum Subarray
    public static int maxSubArray(int[] nums) {
        /*int max_so_far = nums[0], sum = nums[0];
        for(int i=1; i<nums.length; i++){
            sum = (nums[i] > sum+nums[i]) ? nums[i] : sum+nums[i];
            if(sum > max_so_far) max_so_far = sum;
        }
        return max_so_far;       */
        int[] max = new int[nums.length];
	for(int i=0;i<nums.length;i++)
	{
		if(i==0)
		{
			max[i]=nums[i];
		}
		else
		{
			max[i]=Math.max(max[i-1], max[i-1]+nums[i]);
		}
	}
	
	// find maxium
	int result = max[0];
	for(int i=1;i<nums.length;i++)
	{
		if(nums[i]>result)
	   	{
			result = nums[i];
		}

	}
	return result;
    }
    
    //54. Spiral Matrix
    public static List<Integer> spiralOrder(int[][] matrix) {               
        List<Integer> res = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return res;
        
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        
        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if(left > right || top > bottom) break;
            
            for(int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if(left > right || top > bottom) break;
            
            for(int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if(left > right || top > bottom) break;
            
            for(int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if(left > right || top > bottom) break;
        }
        
        return res;
    }
    
    //55. Jump Game
    public static boolean canJump(int[] nums) {
        /*if(nums.length > 1 && nums[0] == 0) return false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i + nums[i] >= nums.length) return true;
            }else if(i == nums.length - 1){
                return true;
            }else{
                int j = 1;
                for(; j <= i; j++){
                    if(nums[i - j] > j){
                        break;
                    }
                }
                if(j > i) return false;
            }
        }        
        return false;*/
        int reachable = 0;
        for (int i=0; i<nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }
    
    //56. Merge Intervals
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1){
            return intervals;
        }
        
        Comparator<Interval> c = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        };
        intervals.sort(c);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> retList = new ArrayList<>();
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start > end){
                retList.add(new Interval(start, end));
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }else{
                end = Math.max(end,intervals.get(i).end);
            }
        }
        retList.add(new Interval(start, end));
        return retList;
    }
    /*
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
        return intervals;
    
        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }*/
    
    //57. Insert Interval
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList();
        List<Interval> right = new ArrayList();
        int s = newInterval.start;
        int e = newInterval.end;
        int min = s;
        int max = e;

        for(Interval iv : intervals){
            if(iv == null) continue;
            if(iv.end < s ){ 
                ret.add(iv);
            }else if(iv.start <= e){
                min = Math.min(min, iv.start);
                max = Math.max(max, iv.end);
            }else{
                right.add(iv);
            }
        }
        Interval niv = new Interval(min,max);
        ret.add(niv);
        ret.addAll(right);
        return ret;
    }
    
    //58. Length of Last Word
    public static int lengthOfLastWord(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int last = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == ' '){
                last = 0;
            }else{
                last++;
            }
        }        
        return last;
    }
    
    //59. Spiral Matrix II
    public static int[][] generateMatrix(int n) {
        int[][] retint = new int[n][n];
        int v = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        while(v <= n*n){
            for(int i = left; i <= right; i++){
                retint[top][i] = v++;
            }
            top++;
            for(int i = top; i <= bottom; i++){
                retint[i][right] = v++;
            }
            right--;
            for(int i = right; i >= left; i--){
                retint[bottom][i] = v++;
            }
            bottom--;
            for(int i = bottom; i >= top; i--){
                retint[i][left] = v++;
            }
            left++;
        }
        return retint;
    }
    
    //60. Permutation Sequence
    public static String getPermutation(int n, int k) {
        if(n == 0 || k == 0) return null;
        int max = 1;               
        List<Integer> intal = new ArrayList();
        for(int i = 1; i <= n; i++){
            intal.add(i);
            max *= i;
        }        
        if(k > max) return null;
        return getPermutation(intal, k, max);
    }
    
    public static String getPermutation(List<Integer> intal, int k, int max){        
        String retstr = "";
        if(intal.size() == 0) return "";
        max = max/(intal.size());              
        int idx = (k - 1)/max;
        k = k - idx * max;        
        retstr = String.valueOf(intal.get(idx));
        intal.remove(idx);        
        return retstr + getPermutation(intal, k, max);
    }       
}
