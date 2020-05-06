//https://leetcode.com/problems/first-unique-character-in-a-string
class Solution {
  public int firstUniqChar(String s) {
     int retValue = Integer.MAX_VALUE;
     for(char c='a';c<='z';c++){
         int index = s.indexOf(c);
         if(index > -1 && index == s.lastIndexOf(c)){
             retValue = Math.min(index,retValue);
         }
     }
      return retValue == Integer.MAX_VALUE ? -1 : retValue;
  }
}