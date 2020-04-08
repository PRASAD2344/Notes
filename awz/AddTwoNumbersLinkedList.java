//https://leetcode.com/problems/add-two-numbers/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumUp = null;
        ListNode sumUpPresentPointer = null;
        int carryForward = 0;
        while(l1 != null || l2 != null || carryForward > 0){
            int sum = (l1!=null ? l1.val : 0) + (l2!=null ? l2.val : 0) + carryForward;
            int firstDigit = sum % 10;
            carryForward = sum / 10;
            if(sumUp == null){
                ListNode newNode = new ListNode(firstDigit);
                sumUp = newNode;
                sumUpPresentPointer = newNode;
            }else{
                ListNode newNode = new ListNode(firstDigit);
                sumUpPresentPointer.next = newNode;
                sumUpPresentPointer = newNode;
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return sumUp;
    }
}
