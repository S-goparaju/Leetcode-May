/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        
        int length = s.length();
        for(int i = 0; i<length; i++){
            char a = s.charAt(i);
            map.put(a,map.getOrDefault(a,0)+1);
        }
        
        for(int i=0; i<length;i++){
            if (map.get(s.charAt(i)) == 1) 
                return i;
        }
        return -1;
    
        }
    }


/* Time complexity O(N)since we go through the string of length N two times.
Space complexity : O(N) since we have to keep a hash map with N elements.
*/
