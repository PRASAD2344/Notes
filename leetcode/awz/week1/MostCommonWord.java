//https://leetcode.com/problems/most-common-word/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> occurances = new HashMap<>();
        Map<String,Integer> bannedMap = new HashMap<>();
        for(String word : banned)
            bannedMap.put(word,1);
        StringBuilder word = new StringBuilder();
        for(int i=0;i<paragraph.length();i++){
            char c = paragraph.charAt(i);
            if(Character.isLetter(c)){
                word.append(Character.toLowerCase(c));
            }else if(word.length() > 0){
                String token = word.toString();
                updateMap(occurances,token);
                word = new StringBuilder();
            }
        }
        if(word.length() > 0){
                String token = word.toString();
                updateMap(occurances,token);
        }
        int maxFound = -1;
        String maxWord = "";
        for (Map.Entry<String,Integer> entry : occurances.entrySet()){
            if(!bannedMap.containsKey(entry.getKey()) && entry.getValue() > maxFound){
                maxWord = entry.getKey();
                maxFound = entry.getValue();
            }
        }
        return maxWord;
    }
    
    public void updateMap(Map<String,Integer> wordMap,String token){
        if(wordMap.containsKey(token))
            wordMap.put(token,wordMap.get(token)+1);
        else
            wordMap.put(token,1);
    }
}
