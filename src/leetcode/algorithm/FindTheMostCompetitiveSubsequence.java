package leetcode.algorithm;

public class FindTheMostCompetitiveSubsequence {

    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length ;
        int[] ans = new int[k];
        int j = 0;

        for (int i = 0; i < len; ++i) {
            while (j > 0 && ans[j - 1] > nums[i] && j - 1 + len - i >= k)
                j--;
            if (j < k)
                ans[j++] = nums[i];
        }

        return ans;
    }
}
