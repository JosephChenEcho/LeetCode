/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package x4;

/**
 *
 * @author Joseph
 */
class SumNode{
    SumNode smaller, larger;
    int dup = 1;
    int val, count;
    public SumNode(){
        count = 0;
    }
}