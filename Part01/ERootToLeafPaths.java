
import java.util.*;
public class ERootToLeafPaths {
      static class Node{
        int data;
        Node left;
        Node right; 

        //constructor
        Node(int data) {
            this.data = data;
        }
    }
      public static Node insert(Node root, int val) { // ye func bst k andr node ko insert krega and return bhii node ko ..jo change hoga wo ..in last it return root
        if(root == null) {
            root = new Node(val);
            return root;
        }//aesa mhi to shi position find
        if(root.data > val) {
            //left subtree
            root.left = insert(root.left, val); 
        }else{
            //right subtree
            root.right = insert(root.right, val);
        }
    
       return root;
    }
      public static void inorder(Node root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }
        

    public static void printPath(ArrayList<Integer>path){
        for(int i = 0; i<path.size(); i++) {
            System.out.println(path.get(i)+"->");
        }
        System.out.println("null");
    }
    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }
    //step 01  curr node ko path m add kr dena 
         path.add(root.data);
         if(root.left == null && root.right == null) {
              printPath(path);
         }
    // Step 02  left subtree ki jitni leaf h un tak pahuchna
         printRoot2Leaf(root.left, path);
         printRoot2Leaf(root.right, path);
         // we add now we are going to remove
         path.remove(path.size()-1); // last idx pr humhara root.data exist krta h

    }
    public static void main(String[] args) {
         int values[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i<values.length;i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
            printRoot2Leaf(root,  new ArrayList<>());
        
    }
}
