//Miguel Wentzel
//4478677
//Practical 7

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
class BST{
    Node root;
    public Node insert(Node root, int data){
        if(root == null){
            root = new Node(data);
            return root;
        }
        if(data < root.data){
            root.left = insert(root.left, data);
        } else if(data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }
    public void buildBalanced(int[] arr, int start, int end){
        if(start > end){
            return;
        }
        int mid = (start + end) / 2;
        root = insert(root, arr[mid]);
        buildBalanced(arr, start, mid - 1);
        buildBalanced(arr, mid + 1, end);
    }
    public boolean isBST(){
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
