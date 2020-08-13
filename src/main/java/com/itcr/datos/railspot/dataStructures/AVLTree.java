package com.itcr.datos.railspot.dataStructures;

/**
 * This class will we be instanced to create a new AVL Tree
 *
 * @param <T>
 */
public class AVLTree<T>
{
    NodeAVL<T> root;

    /**
     * Manages the height of the tree
     * @param N
     * @return
     */
    public int height(NodeAVL<T> N)
    {
        if (N == null)
            return 0;
        return N.getHeight();
    }

    /**
     * Maximum value in the tree
     * @param a
     * @param b
     * @return
     */
    public int max(int a, int b)
    {
        return Math.max(a, b);
    }

    /**
     * Right rotation for the tree
     * @param y
     * @return the node rotated
     */
    public NodeAVL<T> rightRotate(NodeAVL<T> y)
    {
        NodeAVL<T> x = y.getLeft();
        NodeAVL<T> T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        y.setHeight( max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);

        return x;
    }

    /**
     * Left rotation for the tree
     * @param y
     * @return the node rotated
     */
    public NodeAVL<T> leftRotate(NodeAVL<T> x)
    {
        NodeAVL<T> y = x.getRight();
        NodeAVL<T> T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);

        return y;
    }

    /**
     * This will manage the tree and its balance
     * @param N
     * @return the balance of the tree
     */
    public int getBalance(NodeAVL<T> N)
    {
        if (N == null)
            return 0;
        return height(N.getLeft()) - height(N.getRight());
    }

    /**
     * This will add a new node to the tree
     * @param data
     * @param key
     */
    public void add(T data, int key){
        this.root = add_aux(this.root, data, key);
    }

    /**
     * Auxiliary method for add method
     * @param node
     * @param data
     * @param key
     * @return
     */
    public NodeAVL<T> add_aux(NodeAVL<T> node, T data, int key)
    {
        /* 1. Perform the normal BST rotation */
        if (node == null)
            return (new NodeAVL<T>(data, key));

        if (key < node.getKey())
            node.setLeft(add_aux(node.getLeft(), data, key));
        else if (key > node.getKey())
            node.setRight(add_aux(node.getRight(), data, key));
        else
            return node;

        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));

        int balance = getBalance(node);

        if (balance > 1 && key < node.getLeft().getKey())
            return rightRotate(node);

        if (balance < -1 && key > node.getRight().getKey())
            return leftRotate(node);

        if (balance > 1 && key > node.getLeft().getKey())
        {
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);
        }

        if (balance < -1 && key < node.getRight().getKey())
        {
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
        }

        return node;
    }

    /**
     * Given a non-empty binary search tree, return the node with minimum key value found in that tree.
     * Note that the entire tree does not need to be searched.
     * @param node
     * @return the minimum value
     */
    public NodeAVL<T> minValueNode(NodeAVL<T> node)
    {
        NodeAVL<T> current = node;

        /* loop down to find the leftmost leaf */
        while (current.getLeft() != null)
            current = current.getLeft();

        return current;
    }

    /**
     * This will delete the node of a given key
     * @param key
     */
    public void deleteNode(int key){
        this.root = deleteNode_aux(this.root, key);
    }

    /**
     * Auxiliary method for the delete node method
     * @param root
     * @param key
     * @return
     */
    public NodeAVL<T> deleteNode_aux(NodeAVL<T> root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;

        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.getKey())
            root.setLeft(deleteNode_aux(root.getLeft(), key));

            // If the key to be deleted is greater than the
            // root's key, then it lies in right subtree
        else if (key > root.getKey())
            root.setRight(deleteNode_aux(root.getRight(), key));

            // if key is same as root's key, then this is the node
            // to be deleted
        else
        {

            // node with only one child or no child
            if ((root.getLeft() == null) || (root.getRight() == null))
            {
                NodeAVL<T> temp = null;
                if (temp == root.getLeft())
                    temp = root.getRight();
                else
                    temp = root.getLeft();

                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else // One child case
                    root = temp; // Copy the contents of
                // the non-empty child
            }
            else
            {

                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                NodeAVL<T> temp = minValueNode(root.getRight());

                // Copy the inorder successor's data to this node
                root.setKey(temp.getKey());

                // Delete the inorder successor
                root.setRight(deleteNode_aux(root.getRight(), temp.getKey()));
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.setHeight(max(height(root.getLeft()), height(root.getRight())) + 1);

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        // this node became unbalanced)
        int balance = getBalance(root);

        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.getLeft()) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && getBalance(root.getLeft()) < 0)
        {
            root.setLeft(leftRotate(root.getLeft()));
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && getBalance(root.getRight()) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.getRight()) > 0)
        {
            root.setRight(rightRotate(root.getRight()));
            return leftRotate(root);
        }

        return root;
    }

    /**
     * When needed this method will help convert the node into a String
     * @return
     */
    public String toString() {
        return this.toString(new StringBuilder(), true, new StringBuilder(),this.root).toString();
    }

    /**
     * This method will return the root of the tree
     * @return
     */
    public NodeAVL<T> getRoot(){
        return this.root;
    }


    /**
     * This method prints the tree in way that is more humane tp understand.
     * @param prefix
     * @param isTail
     * @param sb
     * @param head
     * @return
     */
    public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb,NodeAVL<T> head) {
        if(head.getRight()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, new StringBuilder(), head.getRight()));
        }
        sb.append(prefix).append(isTail ? "└──" : "┌──").append("[").append(head.getKey()).append("]").append("\n");
        if(head.getLeft()!=null) {
            sb.append(toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, new StringBuilder(), head.getLeft()));
        }
        return sb;
    }


    /**
     * This will set the tree to blank
     */
    public void clear(){ this.root=null; }
}