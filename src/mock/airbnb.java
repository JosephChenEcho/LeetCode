/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 *
 * @author Joseph
 */
public class airbnb {
    public static void main(String[] args){
        //String[] input = {"1,28,300.6,San Francisco","4,5,209.1,San Francisco","20,7,203.4,Oakland","6,8,202.9,San Francisco","6,10,199.8,San Francisco","1,16,190.5,San Francisco","6,29,185.3,San Francisco","7,20,180.0,Oakland",
        //    "6,21,162.2,San Francisco","2,18,161.7,San Jose","2,30,149.8,San Jose","3,76,146.7,San Francisco","2,14,141.8,San Jose"};
        alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});
        
    }
    static void StairCase(int n) {
        for(int i = 0; i < n; i++){
            printspace(n - i - 1);
            printsharp(i + 1);
            System.out.println();
        }
    }
    
    static void printspace(int n){
        for(int i = 0; i < n; i++){
            System.out.print(" ");
        }
    }
    
    static void printsharp(int n){
        for(int i = 0; i < n; i++){
            System.out.print("#");
        }    
    }
    
    static int summation(int[] numbers) {
        int len = numbers[0];
        int sum = 0;
        for(int i = 1; i <= numbers.length; i++){
            sum += numbers[i];
        }
        return sum;

    }
    
    static String[] paginate(int num, String[] results){
        
        List<String> resList = new ArrayList(Arrays.asList(results));
        HashSet<Integer> idSet = new HashSet();
        List<String> retList = new ArrayList();
        int i = 0;
        Boolean visitEnd = false;
        while(!resList.isEmpty()){
            String strres = resList.get(i);
            int id = Integer.parseInt(strres.split(",")[0]);
            if(!idSet.contains(id)){
                if(!visitEnd){
                    idSet.add(id);
                } 
                retList.add(strres);
                resList.remove(i);
                //page spearator; reset HashSet
                if((retList.size() + 1) % (num + 1) == 0){
                    retList.add("");
                    idSet = new HashSet();
                    i = 0;
                    visitEnd = false;
                }
            }else{
                i++;                
            }
            if(i >= resList.size()){
                visitEnd = true;
                idSet = new HashSet();
                i = 0;
            }
        }
        String[] retarr = retList.toArray(new String[retList.size()]);
        return retarr;
    }
    
    
    //Alien Dictonary
    public static String alienOrder(String[] words) {
        Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
        Map<Character, Integer> degree=new HashMap<Character, Integer>();
        String result="";
        if(words==null || words.length==0) return result;
        for(String s: words){
            for(char c: s.toCharArray()){
                degree.put(c,0);
            }
        }
        for(int i=0; i<words.length-1; i++){
            String cur=words[i];
            String next=words[i+1];
            int length=Math.min(cur.length(), next.length());
            for(int j=0; j<length; j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(map.containsKey(c1)) set=map.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: degree.keySet()){
            if(degree.get(c)==0) q.add(c);
        }
        while(!q.isEmpty()){
            char c=q.remove();
            result+=c;
            if(map.containsKey(c)){
                for(char c2: map.get(c)){
                    degree.put(c2,degree.get(c2)-1);
                    if(degree.get(c2)==0) q.add(c2);
                }
            }
        }
        if(result.length()!=degree.size()) return "";
        return result;
    }
    
    //68. Text Justification
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<String>();
        
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) break;
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            // if last line or number of words in the line is 1, left-justified
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                // middle justified
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            lines.add(builder.toString());
            index = last;
        }
        
        
        return lines;
    }
    
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph ;
        boolean[] isVisited;
        boolean[] courseOK;
        isVisited = new boolean[numCourses];
        courseOK = new boolean[numCourses];
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, isVisited, courseOK, graph)){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int course, boolean[] isVisited, boolean[] courseOK, ArrayList<Integer>[] graph){
        if(courseOK[course]) return true;
        if(isVisited[course]) return false;        
        isVisited[course] = true;
        for(int i = 0; i < graph[course].size(); i++){
            if(!dfs(graph[course].get(i), isVisited, courseOK, graph)){
                return false;
            }
        }
        isVisited[course] = false;
        courseOK[course] = true;
        return true;
    }
}
