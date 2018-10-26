package Section_1;

import java.util.HashMap;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class Solution_1_1 {

    /**
     * Checks a string to determine if the it is composed of unique characters.
     * Implements a HashMap to determine if a character c is used more than once
     *
     * @param str the string to be checked
     * @return returns true if unique and false if not unique
     */
    static boolean isUniqueChars1(String str) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (charMap.get(c) == null) {
                charMap.put(c, 1);
            } else {
                int val = charMap.get(c);
                charMap.put(c, val + 1);
            }
        }
        for (char key : charMap.keySet()) {
            if (charMap.get(key) > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * A driver function for the solution
     */
    public static void main(String[] args) {
        String nonUnique = "cool guy";
        String unique = "uniq";
        assert isUniqueChars1(nonUnique) == false;
        assert isUniqueChars1(unique) == true;
    }
}
