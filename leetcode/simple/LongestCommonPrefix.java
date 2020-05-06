//https://leetcode.com/problems/longest-common-prefix
class Solution {
  public String longestCommonPrefix(String[] strs) {
      int minLength = Integer.MAX_VALUE;
      String retValue = "";
      if(strs.length == 0)
          return retValue;
      else if(strs.length == 1)
          return strs[0];
      for(int i=0;i<strs.length;i++){
          minLength = Math.min(minLength,strs[i].length());
      }
      for(int i=minLength;i>=1;i--){
          String prefix = strs[0].substring(0,i);
          boolean found = true;
          for(int j=1;j<strs.length;j++){
              if(!strs[j].startsWith(prefix)){
                  found=false;
                  break;
              }
          }
          if(found){
              retValue = prefix;
              break;
          }
      }
      return retValue;
  }
}