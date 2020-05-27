//https://leetcode.com/problems/reverse-linked-list/
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
//1 -> 2 -> 3 -> 4
class Solution {
  public ListNode reverseList(ListNode head) {
      ListNode newRoot = null;
      while(head!=null){
          if(newRoot==null)
              newRoot = new ListNode(head.val);
          else
              newRoot = new ListNode(head.val,newRoot);
          head = head.next;
      }
      return newRoot;
  }
}