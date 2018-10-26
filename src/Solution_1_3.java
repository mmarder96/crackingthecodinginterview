import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is a permutation of the other
 */

public class Solution_1_3 {

    /**
     * Checks two strings to determine if the one is a permutation of the other.
     *
     * @param str1 the first string to be checked
     * @param str2 the second string to be checked
     * @return returns true if unique and false if not unique
     */
    static boolean permCheck(String str1, String str2){
        if (str1.length() != str2.length())
            return false;

        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    /**
     * A driver function for the solution
     */
    public static void main(String[] args) {
        String str1 = "Poop";
        String str2 = "Popo";

        String str3 = "Fake News";
        String str4 = "Lake News";

        assert permCheck(str1, str2) == true;
        assert permCheck(str2, str3) == false;
        assert permCheck(str3,str4) == false;

    }
}
