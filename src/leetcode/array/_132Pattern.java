package leetcode.array;

import java.util.Stack;
import java.util.TreeSet;

public class _132Pattern {

    public static void main(String[] args) {
        int[] arr = {3,1,4,2};
        System.out.println(find132pattern(arr));
    }

    // O(NlogN) solution
    public static boolean find132pattern1(int[] nums) {
        int[] arr = nums.clone();
        for(int i=1; i < arr.length ; i++){
            arr[i] = Math.min(arr[i-1],arr[i]);
        }

        // to efficiently return number lower than given number
        // using tree
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i = arr.length - 1 ; i >=0 ;i--){
            int num = nums[i];
            if(tree.lower(num) != null){
                int right = tree.lower(num);
                int left = arr[i-1];
                if(left < right){
                    return true;
                }
            }
            tree.add(num);
        }
        return false;
    }

    // O(N) solution using stack
    public static boolean find132pattern(int[] nums) {
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack =  new Stack<>();

        for(int i= nums.length - 1; i >= 0 ; i--){
            if(nums[i] < s3){
                return true;
            }else{
                while(!stack.empty() && nums[i] > stack.peek()){
                    s3 = Math.max(s3,stack.peek());
                    stack.pop();
                }
            }
            stack.add(nums[i]);
        }
        return false;
    }
}
