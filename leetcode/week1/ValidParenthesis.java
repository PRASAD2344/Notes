//https://leetcode.com/problems/valid-parentheses/
class Solution {
    public boolean isValid(String s) {
        if(s==null || s.length()%2 > 0){
            return false;
        }
        Map<Character,Character> reverseMap = new HashMap<>();
        reverseMap.put(')','(');
        reverseMap.put(']','[');
        reverseMap.put('}','{');
        Stack<Character> parenthesis = new Stack<>();
        for(int i=0;i<s.length();i++){
            Character token = new Character(s.charAt(i));
            if(token == '(' || token == '{' || token == '[')
                parenthesis.push(token);
            else if(parenthesis.empty() || !parenthesis.pop().equals(reverseMap.get(token)))
                return false;
        }
        return parenthesis.empty();
    }
}
