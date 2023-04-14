package com.sprint2.binarytree;

public class BinaryTree {
    Node root;

    public boolean isEmpty() {
        return root == null;
    }

    public int getSize() {
        return getSizeRecursive(root);
    }

    private int getSizeRecursive(Node current) {
        return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
    }

    // Method to start the recursion from the root node
    public void add(int value){
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value){
        if (current == null){
            // When the current node is null, insert the new node in that position
            return new Node(value);
        } if (value < current.value){
            // If the node's value is lower than the current node's, we go to the left child
            current.left = addRecursive(current.left, value);
        } else if (value > current.value){
            // If the node's value is greater than the current node's, we go to the right child
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    // Public method that starts from root
    public boolean containsNode(int value){
        return containsNodeRecursive(root, value);
    }

    // Method to check if the tree contains a specific value
    private boolean containsNodeRecursive(Node current, int value){
        if(current == null){
            return false;
        } if (value == current.value){
            return true;
        } return (value<current.value?containsNodeRecursive(current.left, value):containsNodeRecursive(current.right, value));
        // Continue searching to the left or right, depending on if the value you're searching for is greater or less than.
    }

    // Start deletion from root
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    // Deleting a node
    private Node deleteRecursive(Node current, int value){
        // Find the node to delete
        if (current == null){
            return null;
        } if(value == current.value){
            // Node to delete found, now to find if the node has a child.
            // Node has no child
            if(current.left == null && current.right == null){
                return null;
            }
            // Node has one child
            if(current.right == null){
                // Return the non-null child so it can be assigned to the parent node
                return current.left;
            }
            if(current.left == null){
                // Return the non-null child so it can be assigned to the parent node
                return current.right;
            }
            // Node has two children
            else{
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
            }
        } if (value < current.value){
            // If the value is lower than the node, move to the left child and run the recursion again.
            current.left = deleteRecursive(current.left, value);
            return current;
        } if(value > current.value){
            // If the value is greater than the node, move to the right child and run the recursion again.
            current.right = deleteRecursive(current.right, value);
            return current;
        } else{
            // If the value is greater than the node, move to the left child and run the recursion again.
            current.left = deleteRecursive(current.left, value);
            return current;
        }
    }

    // Find the smallest node
    private int findSmallestValue(Node root){
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    // In-order traversal. Visit the left sub-tree, then the root node, and then right sub-tree
    public void traverseInOrder(Node node){
        if (node != null){
            traverseInOrder(node.left);
            System.out.print(" "+node.value);
            traverseInOrder(node.right);
        }
    }
    // Pre-order traversal. Visit the root node, then the left sub-tree, then the right sub-tree
    public void traversePreOrder(Node node){
        if (node != null){
            System.out.print(" "+node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    // Post-order traversal. Visit the left sub-tree, then the right sub-tree, then the root node
    public void traversalPostOrder(Node node){
        if (node != null){
            traversalPostOrder(node.left);
            traversalPostOrder(node.right);
            System.out.print(" "+node.value);
        }
    }
    class Node {
        int value;
        Node left;
        Node right;

        Node (int value){
            this.value = value;
            left = null;
            right = null;
        }
    }


}

