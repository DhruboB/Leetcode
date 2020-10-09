package leetcode.medium.linkedlist;

public class AddTwoNumbers {


    public static void main(String[] args) {
//        int[] arr1 = {9,9,9,9,9,9,9};
//        int[] arr2 = {9,9,9,9};
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        ListNode l1 = createLL(arr1);
        ListNode l2 = createLL(arr2);

        Solution sln = new Solution();

        ListNode l = sln.addTwoNumbers(l1,l2);
        while(l!= null){
            System.out.print(l.val + " ");
            l=l.next;
        }
    }

    public static ListNode createLL(int[] arr){
        ListNode node = null;
        ListNode prevNode = null;
        for( int i = arr.length -1 ; i >=0 ; i--){
            node = new ListNode(arr[i]);
            node.next = prevNode;
            prevNode = node;
        }
        return node;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int l1Len = getLength(l1);
        int l2Len = getLength(l2);
        ListNode shorter = l1Len <= l2Len ? l1 : l2;
        ListNode longer = l1Len > l2Len ? l1 : l2;
        int digitSum = 0;
        ListNode sumHead = null;
        ListNode node = null;
        ListNode prevNode = null;
        int remainder = 0;
        while(shorter != null && longer != null){
            digitSum = remainder + shorter.val + longer.val;
            remainder = 0;
            node = new ListNode(digitSum%10);
            if(prevNode != null){
                prevNode.next = node;
                prevNode = node;
            }
            if(digitSum >= 10){
                remainder = digitSum / 10;
            }
            if(sumHead == null){
                sumHead = node;
                prevNode = node;
            }
            shorter = shorter.next;
            longer = longer.next;
        }
        while(longer != null){
            digitSum = remainder + longer.val;
            remainder = 0;
            node = new ListNode(digitSum%10);
            if(prevNode != null){
                prevNode.next = node;
                prevNode = node;
            }
            if(digitSum >= 10){
                remainder = digitSum / 10;
            }
            longer = longer.next;
        }
        if(remainder != 0){
            node = new ListNode(remainder);
            prevNode.next = node;
        }
        return sumHead;
    }

    int getLength(ListNode node){
        if(node == null) return 0;
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return length;
    }
}
