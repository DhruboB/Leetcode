package leetcode.medium.array;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6};

        RemoveDuplicatesfromSortedArrayII sln = new RemoveDuplicatesfromSortedArrayII();
        System.out.println(Arrays.toString(arr));
        System.out.println(sln.removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public int removeDuplicates(int[] nums) {
        // TODO Edge case check
        int len = nums.length;
        int deDupLength = len;
        int curr = -1;
        int count = 1;
        while (++curr < len - 1) {
            if (nums[curr] == nums[curr + 1]) {
                count++;
                continue;
            } else {
                if (count > 2) {
                    deDupLength -= count - 2;
                }
                count = 1;
            }
        }
        return deDupLength;
    }
}
