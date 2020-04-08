//https://leetcode.com/problems/rotting-oranges/
/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function(grid) {
    var numberOfMinutes = 0;
    var numberOfFresh = 0;
    for(var i=0;i<grid.length;i++){
        for(var j=0;j<grid[0].length;j++){
            if(grid[i][j]==1)
                numberOfFresh++;
        }
    }
    while(numberOfFresh > 0){
        var numberOfNewRottens = 0;
        var rows = [];
        var cols = [];
        for(var i=0;i<grid.length;i++){
            for(var j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    rows.push(i);cols.push(j+1);//Left
                    rows.push(i);cols.push(j-1);//Right
                    rows.push(i+1);cols.push(j);//Bottom
                    rows.push(i-1);cols.push(j);//Right
                }
            }
        }
        for(i=0;i<rows.length;i++){
            if(rows[i]<0 || cols[i]<0 || rows[i]>=grid.length || cols[i]>=grid[0].length)
                continue;
            if(grid[rows[i]][cols[i]] == 1){
                grid[rows[i]][cols[i]] = 2;
                numberOfNewRottens++;
                numberOfFresh--;
            }
        }
        if(numberOfNewRottens == 0){
            break;
        }   
        numberOfMinutes++;
    }
    if(numberOfFresh > 0)
        return -1;
    else
        return numberOfMinutes;
};