package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
//        int[] nums = {0,2,3,6,8,9};
        int[] nums = {0,1,2,4,5,7};
        for(String s : summaryRanges(nums)){
            System.out.print(s + ",");
        }
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return list;
        }

        int start = nums[0];
        int end = start;
        if(nums.length == 1){
            list.add(""+start);
            return list;
        }
        for(int i=1; i < nums.length ; i++){
            if(nums[i] != end + 1){
                if(start == end){
                    list.add(""+start);
                }else {
                    list.add("" + start + "->" + end);
                }
                start = nums[i];
            }
            end = nums[i];
        }
        if(start == end){
            list.add(""+start);
        }else {
            list.add("" + start + "->" + end);
        }
        return list;
    }
}
