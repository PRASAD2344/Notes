//https://leetcode.com/explore/interview/card/amazon/77/linked-list/2976/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode newList=null;
      ListNode newListCurrentPointer=null;
      for(;l1!=null && l2!=null;){
          ListNode requiredNode = null;
          if(l1.val <= l2.val){
              requiredNode = l1;
              l1 = l1.next;
          }else{
              requiredNode = l2;
              l2 = l2.next;
          }
          if(newList == null){
              newListCurrentPointer = requiredNode;
              newList = newListCurrentPointer;
          }else{
              newListCurrentPointer.next = requiredNode;
              newListCurrentPointer = newListCurrentPointer.next;
          }
      }
      if(l1 != null && newList == null){
          newList = l1;
      }else if(l1 != null && newList != null){
          newListCurrentPointer.next = l1;
      }else if(l2 != null && newList == null){
          newList = l2;
      }else if(l2 != null && newList != null){
          newListCurrentPointer.next = l2;
      }
      return newList;
  }
}