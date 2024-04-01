import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchHelper(val, root);
    }

    public boolean searchHelper(int val, BSTNode n)
    {
        if(val == n.getVal())
        {
            return true;
        }
        else if(val < this.getRoot().getVal())
        {
            return searchHelper(val, n.getLeft());
        }
        else if (val > this.getRoot().getVal())
        {
            return searchHelper(val, n.getRight());
        }
        return false;
    }


    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> returnedList = null;
        return getInorderHelper(returnedList, root);
    }

    // getInorder()
    // Return an ArrayList<BSTNode> that represents the Inorder Traversal of the tree.
    //
    // Inorder Traversal visits each node from Left → Root → Right
    public ArrayList<BSTNode> getInorderHelper(ArrayList<BSTNode> returnedList, BSTNode n)
    {
        if(n == null)
        {
            return returnedList;
        }
        else if(n.getLeft() != null)
        {
            getPostorderHelper(returnedList, n.getLeft());
        }
        else if(n != null)
        {
            returnedList.add(n);
        }
        else if(n.getRight() != null)
        {
            getPostorderHelper(returnedList, n.getRight());
        }
        return returnedList;
    }


    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> returnedList = null;
        return getPreorderHelper(returnedList, root);
    }

    // getPreorder()
    // Return an ArrayList<BSTNode> that represents the Preorder Traversal of the tree.
    //
    // Preorder Traversal visits each node from Root → Left → Right
    public ArrayList<BSTNode> getPreorderHelper(ArrayList<BSTNode> returnedList, BSTNode n)
    {
        if(n == null)
        {
            return returnedList;
        }
        returnedList.add(n);
        if(n.getLeft()!= null)
        {
            return getPreorderHelper(returnedList, n.getLeft());
        }
        if(n.getRight() != null)
        {
            return getPreorderHelper(returnedList, n.getRight());
        }
        return returnedList;
    }


    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> returnedList = null;
        return getPostorderHelper(returnedList, root);
    }

    //getPostorder()
    //Return an ArrayList<BSTNode> that represents the Postorder Traversal of the tree.
    //
    //Postorder Traversal visits each node from Left → Right → Root
    public ArrayList<BSTNode> getPostorderHelper(ArrayList<BSTNode> returnedList, BSTNode n)
    {
        if(n == null)
        {
            return returnedList;
        }
        else if(n.getLeft() != null)
        {
            getPostorderHelper(returnedList, n.getLeft());
        }
        else if(n.getRight() != null)
        {
            getPostorderHelper(returnedList, n.getRight());
        }
        returnedList.add(n);
        return returnedList;
    }


    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        if(!search(val))
        {
            BSTNode newValue = new BSTNode(val);
            BSTNode compareValue = root;
            BSTNode previousValue = null;
            while(compareValue != null)
            {
                previousValue = compareValue;
                compareValue = getNextNode(previousValue, newValue);
            }
            if(previousValue.getVal() < newValue.getVal())
            {
                previousValue.setRight(newValue);
            }
            else
            {
                previousValue.setLeft(newValue);
            }
        }
    }

    // Returns next node in the tree
    public BSTNode getNextNode(BSTNode treeValue, BSTNode newValue)
    {
        if(treeValue == null)
        {
            return treeValue;
        }
        else if(treeValue.getVal() > newValue.getVal())
        {
            return treeValue.getLeft();
        }
        else if(treeValue.getVal() < newValue.getVal())
        {
            return treeValue.getRight();
        }
        else if(treeValue.getVal() == newValue.getVal())
        {
            return treeValue;
        }
        return null;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
