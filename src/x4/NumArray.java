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

//303. Range Sum Query - Immutable
public class NumArray {
    private int[] numarr;
    public NumArray(int[] nums) {
        this.numarr = nums;
        for(int i = 1; i < numarr.length; i++){
            numarr[i] += numarr[i-1];
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) return numarr[j];
        return numarr[j] - numarr[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
