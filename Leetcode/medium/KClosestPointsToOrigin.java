//https://leetcode.com/problems/k-closest-points-to-origin/
//Runtime: 91 ms, faster than 5.79% of Java online submissions for K Closest Points to Origin.
//Memory Usage: 117.3 MB, less than 5.59% of Java online submissions for K Closest Points to Origin.
class Solution {
  public int[][] kClosest(int[][] points, int K) {
      Map<Double,List<Integer>> indexDistanceMap = new TreeMap<>();
      if(K == points.length)
          return points;
      for(int i=0;i<points.length;i++){
          double distance = Math.sqrt(Math.pow(points[i][0]-0,2)+Math.pow(points[i][1]-0,2));
          if(!indexDistanceMap.containsKey(distance)){
              List<Integer> newList = new ArrayList<>();
              newList.add(i);
              indexDistanceMap.put(distance,newList);
          }else{
              indexDistanceMap.get(distance).add(i);
          }
      }
      int i=0;
      int[][] retValue = new int[K][2];
      for(Map.Entry<Double,List<Integer>> entry : indexDistanceMap.entrySet()){
          List<Integer> pointsForADistance = entry.getValue();
          for(int j=0;j<pointsForADistance.size();j++){
              retValue[i] = points[pointsForADistance.get(j)];
              i++;
              if(i==K)
                  break;
          }
          if(i==K)
              break;
      }
      return retValue;
  }
}