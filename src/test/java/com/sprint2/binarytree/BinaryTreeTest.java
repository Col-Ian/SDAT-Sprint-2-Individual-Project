package com.sprint2.binarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinaryTreeTest {
    private BinaryTree createBinaryTree(){
        BinaryTree bt = new BinaryTree();
        bt.add(7);
        bt.add(4);
        bt.add(2);
        bt.add(5);
        bt.add(9);
        bt.add(1);
        bt.add(3);
        return bt;
    }

    private BinaryTree createEmptyTree(){
        BinaryTree ebt = new BinaryTree();
        return ebt;
    }

    @Test
    public void doesItContain(){
        BinaryTree bt = createBinaryTree();
        assertTrue(bt.containsNode(7));
        assertTrue(bt.containsNode(1));

        assertFalse(bt.containsNode(8));
    }

    @Test
    public void doesItDelete(){
        BinaryTree bt = createBinaryTree();
        assertTrue(bt.containsNode(3));
        bt.delete(3);

        assertFalse(bt.containsNode(3));
    }

    @Test
    public void correctSize(){
        BinaryTree bt = createBinaryTree();
        assertTrue(bt.getSize()==7);
    }

    @Test
    public void isItEmpty() {
        BinaryTree bt = createBinaryTree();
        assertFalse(bt.isEmpty());
    }

    @Test
    public void testTraversal(){
        BinaryTree pobt = createBinaryTree();
        BinaryTree iobt = createBinaryTree();
        BinaryTree pbt = createBinaryTree();

        System.out.println("Pre-order traversal:");
        pobt.traversePreOrder(pobt.root);
        System.out.println("");
        System.out.println("In-order traversal:");
        iobt.traverseInOrder(iobt.root);
        System.out.println("");
        System.out.println("Post-order traversal:");
        pbt.traversalPostOrder(pbt.root);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.add(7);
        bt.add(4);
        bt.add(2);
        bt.add(5);
        bt.add(9);
        bt.add(1);
        bt.add(3);

        System.out.println(bt.getSize());




    }
}
