/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x2;


/**
 *
 * @author jochen
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){ val = x; }
    
    public String toString(){
        String retstr = "";
        ListNode current = this;
        while(current != null){
            retstr += current.val + "\t";
            current = current.next;
        }
        return retstr;
    }
}
