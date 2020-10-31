package leetcode.array;

import java.util.*;

public class SortArrayByIncreasingFrequency {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3};
//        int[] nums = {2,3,1,3,2};
//        int[] nums = {-1,1,-6,4,5,-6,1,4,1};
        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> outputArray = new ArrayList<>();

        for (int current : nums) {
            int count = map.getOrDefault(current, 0);
            map.put(current, count + 1);
            outputArray.add(current);
        }

        SortComparator comp = new SortComparator(map);
        Collections.sort(outputArray, comp);
        int j = nums.length - 1;
        for (Integer i : outputArray) {
            nums[j--] = i;
        }
        return nums;
    }

    static class SortComparator implements Comparator<Integer> {
        private final Map<Integer, Integer> freqMap;

        SortComparator(Map<Integer, Integer> tFreqMap) {
            this.freqMap = tFreqMap;
        }

        @Override
        public int compare(Integer k1, Integer k2) {
            int freqCompare = freqMap.get(k2).compareTo(freqMap.get(k1));
            int valueCompare = k1.compareTo(k2);
            if (freqCompare == 0) {
                return valueCompare;
            } else {
                return freqCompare;
            }
        }
    }
}
