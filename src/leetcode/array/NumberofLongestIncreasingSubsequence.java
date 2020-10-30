package leetcode.array;

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
//        int[] nums = {2,2,2,2,2};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
        int len = nums.length;
        int[] lengths = new int[len];
        int[] counts = new int[len];
        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);
        int longestIncreasingSeq = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
                longestIncreasingSeq = Math.max(longestIncreasingSeq, lengths[i]);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (lengths[i] == longestIncreasingSeq) {
                res += counts[i];
            }
        }
        return res;
    }
}
