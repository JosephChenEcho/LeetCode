/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x1;
import java.util.*;
/**
 *
 * @author Joseph
 */
public class x02 {
    
    public static void main(String[] args){
        ListNode input = new ListNode(1);
        ListNode input2 = new ListNode(2);
        input.next = input2;
        ListNode input3 = new ListNode(3);
        input2.next = input3;
        ListNode input4 = new ListNode(4);
        input3.next = input4;
        ListNode input5 = new ListNode(5);
        input4.next = input5;
        input5.next = new ListNode(6);
        ListNode output = swapPairs(input);
        System.out.println(output.toString());
    }
    
    //21 Merge Two Sorted Lists
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode retlist = null;
        ListNode curl1 = l1;
        ListNode curl2 = l2;
        ListNode current = null;
        
        while(curl1 == null && curl2 == null){
            ListNode temp = null;
            if(curl1.val > curl2.val){
                temp.val = curl1.val;
                curl1 = curl1.next;
            }
            else{
                temp.val = curl2.val;
                curl2 = curl2.next;
            }
            
            if(retlist == null){
                retlist = temp;
                current = retlist;
            }
            else{
                current.next = temp;
                current = current.next;
            }
        }
        
        if(curl1 == null) current.next = curl2;
        if(curl2 == null) current.next = curl1;
        
        return retlist;        
    }
    
    //24 Swap nodes in pairs
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode node1 = head;
        ListNode node2;
        ListNode temp;
        ListNode pre = null;
        while(node1 != null){
            node2 = node1.next;
            if(node2 == null) return head;
            temp = node2.next;
            node2.next = node1;
            node1.next = temp;
            if(pre != null){
                pre.next = node2;
            }else{
                head = node2;
            }
            pre = node1;
            node1 = pre.next;
        }
        return head;
    }
    
    //29 Divide Two Integers
    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        //Take care the edge cases.
        if (ldivisor == 0) return Integer.MAX_VALUE;
        if ((ldividend == 0) || (ldividend < ldivisor)) return 0;
        
        long result = 0;
        while(ldividend >= ldivisor){
            long subSum = ldivisor;
            long count = 1;
            while(subSum + subSum <= ldividend){
                subSum += subSum;
                count += count;
            }
            ldividend -= subSum;
            result += count;
        }
        
        return (int)result * sign;
    }
    
    //36 Valid Sudoku
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> nums = new HashSet<Character>();
        for(int i=0;i<9;i++){
            nums.clear();
            for(int j=0;j<9;j++){
                if (board[i][j]!='.'){           
                    if (!nums.add(board[i][j])) return false;
                }
            }
        }
        
        for(int i=0;i<9;i++){
            nums.clear();
            for(int j=0;j<9;j++){
                if (board[j][i]!='.'){           
                    if (!nums.add(board[j][i])) return false;
                }
            }
        }
        
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                nums.clear();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        if (board[3*i+k][3*j+l]!='.'){           
                            if (!nums.add(board[3*i+k][3*j+l])) return false;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
