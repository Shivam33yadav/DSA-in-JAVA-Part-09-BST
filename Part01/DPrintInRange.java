
import java.util.*;
public class DPrintInRange {
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
    public static void printInRange(Node root, int k1, int k2) {

        if(root == null) {
            return;
        }
           if(root.data >= k1 && root.data <= k2) {
              printInRange(root.left, k1, k2);
              System.out.println(root.data+" ");
              printInRange(root.right, k1, k2);
           }else{
            printInRange(root.right, k1, k2);
           }
           
    }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i = 0; i<values.length;i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
            printInRange(root,5, 12);
        
    }
}
