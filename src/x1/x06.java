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
        System.out.println(uniquePaths(4,4));
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
        return uniquePathswithPoint(0, 0, m, n);
    }
    
    public static int uniquePathswithPoint(int x, int y, int m, int n){
        if(x == m - 1 || y == n - 1) return 1;        
        return uniquePathswithPoint(x, y + 1, m, n) + uniquePathswithPoint(x + 1, y, m, n);
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
