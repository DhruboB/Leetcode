package leetcode.medium.array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
//        int k = 3;

//        int[] arr = {1,2,3,4,5,6,7};
//        int k = 3;

//        int[] arr = {1,2,3,4};
//        int k = 2;

        int[] arr = {1,2};
        int k = 2;

//        int[] arr = {-1,-100,3,99};
//        int k = 2;

        rotate(arr, k);
        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] nums, int k) {
        rotateRight(nums, k , 0 , nums.length-1);
    }

    private static void rotateRight(int[] nums, int k, int start, int end){
        int len = end - start + 1;
        k = k % len;
        if (len == 1 || k == 0) return;
        int i = k;
        while (i < len) {
            for (int j = 0; j < k; j++) {
                if (i < len) {
                    swap(nums, i++, j);
                }
            }
        }

        if(len%k != 0) {
            rotateRight(nums, k - len%k, 0, k-1 );
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
