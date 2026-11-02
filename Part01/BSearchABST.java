
import java.util.*;

public class BSearchABST { // t.c O(H)
     static class Node{
        int data;
        Node left;
        Node right; 

        //constructor
        Node(int data) {
            this.data = data;
        }
    }

    public static boolean search(Node root, int key) {
              if(root == null) {
                return false;
              }
              if(root.data == key) {
                return true;
              }
              if(root.data > key) {
               return search(root.left, key); // root k left m aur key pass kr denge

              }
              else{
                return search(root.right, key);
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
    public static void main(String[] args) {
        int values[] = {5, 1, 3, 4, 2, 7};
        Node root = null;

        for(int i =0; i<values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();

        if(search(root,1)){ // jisko dhoondna wo key mm
            System.out.println("Found");
        }else{
        System.out.println("Not found");
        }

    }
    
}
