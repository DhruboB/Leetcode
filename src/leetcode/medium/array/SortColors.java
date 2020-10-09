package leetcode.medium.array;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = {2,0,2,1,1,0};
        sortColors(colors);
        System.out.println(Arrays.toString(colors));
     }

     // O(N) time O(1) space
    public static void sortColors(int[] nums) {
        int[] counts = new int[3];
        for(int i = 0 ; i < nums.length ; i++){
            counts[nums[i]] = ++counts[nums[i]];
        }
        int index = 0;

        while(counts[0] > 0 ){
            nums[index++] = 0 ;
            counts[0] = --counts[0];
        }
        while(counts[1] > 0 ){
            nums[index++] = 1 ;
            counts[1] = --counts[1];
        }
        while(counts[2] > 0 ){
            nums[index++] = 2 ;
            counts[2] = --counts[2];
        }
    }
}
