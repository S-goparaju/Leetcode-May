/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/

class Solution {
    private Map <Integer,Integer> counting (int[]nums){
        Map<Integer,Integer> counts = new HashMap<Integer,Integer>();
        for(int x: nums){
            if(!counts.containsKey(x)){
                counts.put(x,1);
            }
            else{
                counts.put(x,counts.get(x)+1);
            }
        }
            return counts;
        
    }
    public int majorityElement(int[] nums) {
        
        Map<Integer,Integer> counts = counting(nums);
        
        Map.Entry<Integer,Integer> majorEntry = null;
        
        for ( Map.Entry<Integer,Integer> entry : counts.entrySet()){
            
            if(majorEntry == null || entry.getValue()> majorEntry.getValue()){
                majorEntry=entry;
            }
        }
        return majorEntry.getKey();
    }
}

/* Time complexity O(n)
   Space complexity O(n)
   */
