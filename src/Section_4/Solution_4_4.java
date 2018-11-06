package Section_4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the
 * nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
 * lists).
 */
public class Solution_4_4 {

    static ArrayList makeDepthList(BST root){
        ArrayList<LinkedList<BST>> depthList = new ArrayList<>();
        return makeDepthListUtil(root, depthList, 0);
    }

    static ArrayList makeDepthListUtil(BST root, ArrayList<LinkedList<BST>> depthList, int depth){
        if (root == null)  // Base case
            return null;

        if (depth == depthList.size()){
            depthList.add(depth, new LinkedList<>());
        }
        depthList.get(depth).add(root);
        makeDepthListUtil(root.left, depthList, depth+1);
        makeDepthListUtil(root.right, depthList, depth+1);
        return depthList;
    }

    public static void main(String[] args) {
        BST bst = new BST(4);
        bst.insert(2);
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);

        ArrayList<LinkedList<BST>> list = makeDepthList(bst);

        for (LinkedList<BST> l : list){
            for (BST n : l) {
                System.out.printf("Depth: %d, Item: %d \n", list.indexOf(l), n.data);
            }
        }
    }
}
