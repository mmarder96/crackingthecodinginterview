package Section_1;

public class Solution_1_5 {

    static String compress(String s){

        StringBuilder compressed = new StringBuilder();
        char last = s.charAt(0);
        int count = 1;
        for (int i=1; i<s.length(); i++){
            if (s.charAt(i) == last) { // found repeated char
                count++;
            } else { // insert char count and update last char
                compressed.append(last); // insert char
                compressed.append(count); // insert count
                last = s.charAt(i);
                count = 1;
            }
            if (i == s.length()-1){ // catch end of string
                compressed.append(last); // insert char
                compressed.append(count); // insert count
            }
        }

        if (s.length() <= compressed.toString().length()){
            return s;
        } else {
            return compressed.toString();
        }
    }

    public static void main(String[] args){
        System.out.println(compress("aabcccccaaab"));
        System.out.println(compress("abcdefg"));
    }
}
