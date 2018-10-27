package Section_1;

/**
 * Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, si and s2, write code to check if s2 is
 * a rotation of si using only one call to isSubstring (e.g.,"waterbottle"is a rotation
 * of "erbottlewat").
 */
public class Solution_1_8 {

    static Boolean isRotation(String s1, String s2){
        if (s1.length() != s2.length() || s1.length() <= 0){
            return false;
        }
        StringBuilder builder = new StringBuilder(s1);
        builder.append(s1);
        String s1s1 = builder.toString();
        return s1s1.contains(s2);
    }

    public static void main(String[] args){
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        String s3 = "bottlewat";
        String s4 = "abcdefghijk";

        assert isRotation(s1, s2) == true;
        assert isRotation(s2, s3) == false;
        assert isRotation(s1, s4) == false;
    }
}
