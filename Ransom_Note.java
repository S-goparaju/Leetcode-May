/* Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

public boolean canConstruct(String ransomNote, String magazine) {
    // For each character, c,  in the ransom note.
    for (char c : ransomNote.toCharArray()) {
        // Find the index of the first occurrence of c in the magazine.
        int index = magazine.indexOf(c);
        // If there are none of c left in the String, return False.
        if (index == -1) {
            return false;
        }
        // Use substring to make a new string with the characters 
        // before "index" (but not including), and the characters 
        // after "index". 
        magazine = magazine.substring(0, index) + magazine.substring(index + 1);
    }
    // If we got this far, we can successfully build the note.
    return true;
}


/* Time Complexity : O(m.n)
* Space Complexity : O(m)
*/
