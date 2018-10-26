package Section_2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class Solution_2_1 {

    static LinkedList removeDuplicates(LinkedList<Integer> list) {
        HashSet set = new HashSet<>();

        // Use iterator to avoid ConcurrentModificationException
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer v = it.next();
            if (!set.contains(v)){
                set.add(v);
            } else {
                it.remove();
            }
        }
        return list;
    }

    static boolean containsDuplicates(LinkedList<Integer> list) {
        HashSet set = new HashSet<>();
        for (int v : list) {
            if (!set.contains(v)){
                set.add(v);
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 6, 9, 3, 2, 6, 2, 1, 6, 9};
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : array)
            list.add(i);

        // assert list contains duplicates
        assert containsDuplicates(list) == true;
        // remove duplicates from list
        list = removeDuplicates(list);
        // assert duplicates are removed
        assert containsDuplicates(list) == false;
    }
}
