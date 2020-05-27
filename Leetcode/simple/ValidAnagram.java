//https://leetcode.com/problems/valid-anagram
class Solution {
  public boolean isAnagram(String s, String t) {
      Map<Integer,Integer> sCount = new HashMap<>();
      Map<Integer,Integer> tCount = new HashMap<>();
      if(s.length() != t.length())
          return false;
      for(int i=0;i<s.length();i++){
          int sChar = s.charAt(i);
          int tChar = t.charAt(i);
          if(sCount.containsKey(sChar)){
              sCount.put(sChar,sCount.get(sChar)+1);
          }else
              sCount.put(sChar,1);
          if(tCount.containsKey(tChar)){
              tCount.put(tChar,tCount.get(tChar)+1);
          }else
              tCount.put(tChar,1);
      }
      if(sCount.size() != tCount.size())
          return false;
      for(Map.Entry<Integer,Integer> charCount : sCount.entrySet()){
          if(!tCount.containsKey(charCount.getKey()) || !tCount.get(charCount.getKey()).equals(charCount.getValue()))
              return false;
      }
      return true;
  }
}