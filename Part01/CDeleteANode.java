
import java.util.*;

public class CDeleteANode { //IMP QUESTION
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
      
    public static Node delete(Node root, int val) {
        if(root.data < val) { //value bdi means root k right m jana
            root.right = delete(root.right, val);

        }else if(root.data > val) {
            root.left = delete(root.left, val);
        }else{  // voila 
            //case 01 -> Leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            //Case 2 -> single child
            if(root.left == null) {
                return root.right;
            }else if(root.right == null) {
                return root.left;
            }

            //case 03 -> both children
           Node IS = findInorderSuccessor(root.right); // kyuki ye pta h ki ye right m hota hai
           root.data = IS.data;
          root.right = delete(root.right, IS.data);

        }
        return root;
     }
      
     public static Node findInorderSuccessor(Node root) {
        while(root.left != null ) {
            root = root.left;
        }
        return root;
     }
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};
        Node root = null;

        for(int i =0; i<values.length; i++) {
            root = insert(root, values[i]);

        }
        inorder(root);
        System.out.println();

        delete(root, 1);
        System.out.println();

        inorder(root);
    }
}

