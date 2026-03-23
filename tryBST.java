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
    private boolean isBSTUtil(Node node, int min, int max){
        if(node == null){
            return true;
        }
        if(node.data <= min || node.data >= max){
            return false;
        }
        return isBSTUtil(node.left, min, node.data) && isBSTUtil(node.right, node.data, max);
    }
    public Node delete(Node root, int key){
        if(root == null){
            return root;
        }
        if(key < root.data){
            root.left = delete(root.left, key);
        } else if(key > root.data){
            root.right = delete(root.right, key);
        } else {
            if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }
}
