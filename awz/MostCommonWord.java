//https://leetcode.com/problems/most-common-word/
/**
 * @param {string} paragraph
 * @param {string[]} banned
 * @return {string}
 */
var mostCommonWord = function(paragraph, banned) {
    var paragraphModified = paragraph.toLowerCase()
    .replace(/\!/g,' ')
    .replace(/\?/g,' ')
    .replace(/\'/g,' ')
    .replace(/\,/g,' ')
    .replace(/\;/g,' ')
    .replace(/\./g,' ');
    var tokens = paragraphModified.split(' ');
    var occurances = {}
    for(var i=0;i<tokens.length;i++){
        var tokenTrimmed=tokens[i].trim();
        if(banned.indexOf(tokenTrimmed) < 0 && tokenTrimmed.length > 0){
            occurances[tokenTrimmed] = occurances[tokenTrimmed] ? occurances[tokenTrimmed] + 1 : 1;
        }
    }
    var retValue = null;
    var maxOccurances = -1;
    for(var key of Object.keys(occurances)){
        if(occurances[key] > maxOccurances){
            maxOccurances = occurances[key];
            retValue = key;
        }
    }
    return retValue;
};
