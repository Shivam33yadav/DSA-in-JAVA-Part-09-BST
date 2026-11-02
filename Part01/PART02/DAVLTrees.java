public class DAVLTrees {  // Only concept will be ask
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }
    public static int height(Node root) {
        if(root == null)
            return 0;

        return root.height;
    }
    // Right rotate subtree rooted with y
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        //Perform rotation
        x.right = y;
        y.left = T2;

        //update heights
        y.height= Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // return new root
        return x;
    }
    //Left rotate subtree rooted with x
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        //perform rotation
        y.left = x;
        x.right = T2;

        // update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // return new root
        return y;
    }
    public static int getBalance(Node root) {
        if(root == null)
            return 0;

        return height(root.left) - height(root.right);
    }
     public static Node insert(Node root, int key) { // ye func bst k andr node ko insert krega and return bhii node ko ..jo change hoga wo ..in last it return root
        if(root == null) 
            return new Node(key);
        
        
        if(key < root.data) 
            //left subtree
            root.left = insert(root.left, key); 
        else if (key > root.data)
            //right subtree
            root.right = insert(root.right, key);
        else
             return root;  // duplicate keys not allowed
   // update root height
   root.height = 1 + Math.max(height(root.left), height(root.right));
   
   // get roots balance factor
   int bf = getBalance(root);  // Make getBalance function

   // Left left Case  check 
   if(bf > 1 && key < root.left.data)
    return rightRotate(root);

   //Right Right Case check
   if(bf < -1 && key > root.right.data)
       return leftRotate(root);

   //Left Right Case
   if(bf > 1 && key > root.left.data) {
    root.left = leftRotate(root.left);
    return rightRotate(root);
   }

   //Right Left case
   if(bf < -1 && key < root.right.data) {
    root.right = rightRotate(root.right);
    return leftRotate(root);
   }
   return root; // returned if AVL balanced
}
  public static void preorder(Node root) {
        if(root == null) {
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);


    }

    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        /*             AVL Tree expected
                      
                    30
                   /  \
                  20   40
                 /  \    \ 
                10  25    50     
        
        */
       preorder(root);

    }
}
