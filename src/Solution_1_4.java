/**
 * Write a method to replace all spaces in a string with'%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing
 * in Java, please use a character array so that you can perform this operation
 * in place.)
 * EXAMPLE
 * Input: "Mr John Smith     "
 * Output: "Mr%20John%20Smith"
 */

public class Solution_1_4 {

    /**
     * Trims spaces around string and replaces interior spaces with "%20"
     *
     * @param str the string to be filtered
     * @return returns the filtered string
     */
   static String filterString(String str){
       return str.trim().replaceAll("( )+", "%20");
   }

    /**
     * A driver function for the solution
     */
    public static void main(String[] args) {
        assert filterString("  Mr John Smith     ").equals("%20John%20Smith");
    }
}

