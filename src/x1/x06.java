/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;

import java.util.*;

/**
 *
 * @author jochen
 */
public class x06 {
    public static void main(String[] args){
        System.out.println(uniquePaths(23,12));
    }
    
    //61. Rotate List
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int len = 1;
        ListNode last = head;
        while(last.next != null){
            last = last.next;
            len++;
        }
        k = k % len;
        if(k == 0) return head;
        ListNode previous = new ListNode(0);
        previous.next = head;
        ListNode target = head;
        for(int i = 0; i < len - k; i++){
            previous = previous.next;
            target = target.next;
        }
        previous.next = null;
        last.next = head;
               
        return target;
    }
    
    //62. Unique Paths
    public static int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        uniquePaths(0,0, map);
        return map[0][0];
    }
    
    public static int uniquePaths(int m, int n, int[][] map) {
        if (m == map.length - 1 || n == map[0].length - 1) return 1;
        if (map[m][n] == 0) map[m][n] = uniquePaths(m + 1, n, map) + uniquePaths(m, n + 1, map);
        return map[m][n];
    }
    
    //73. Set Matrix Zeroes
    public void setZeroes(int[][] matrix){
        if(matrix == null) return;
        HashSet<Integer> col = new HashSet();
        HashSet<Integer> row = new HashSet();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    col.add(i);
                    row.add(j);
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j ++){
                if(col.contains(i) || row.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
