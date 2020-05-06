//https://leetcode.com/problems/palindrome-linked-list/submissions/
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
  public boolean isPalindrome(ListNode head) {
      StringBuilder normal = new StringBuilder();
      StringBuilder reverse = new StringBuilder();
      ListNode currentPointer = head;
      while(currentPointer!=null){
          normal.append(currentPointer.val);
          reverse.insert(0,currentPointer.val);
          currentPointer = currentPointer.next;
      }
      return normal.toString().equals(reverse.toString());
  }
}