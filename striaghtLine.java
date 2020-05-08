/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
 
Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1= coordinates[0][0];
        int y1= coordinates[0][1];
        int x2= coordinates[1][0];
        int y2 = coordinates[1][1];
        
        int dx = x2-x1; 
        int dy= y2-y1;
        
       for (int[] ne : coordinates){
            
            int x = ne[0];
            int y = ne[1];
            
            if(dx * (y-y2)!= dy * (x-x2))// inorder to avoid divided by zero
            {
                return false;
            }
            
            
        }
        return true;
        
    }
}
/* Time complexity = (N) since coordintes.length
 * Sapce complexity = O(1)
 */
