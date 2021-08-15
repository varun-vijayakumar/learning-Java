package com.javaprep.datastructures.trees;

public class BinaryTreeBasic<X extends Comparable<X>> {


    private Node root;
    private int size;

    public BinaryTreeBasic() {
        this.root = null;
    }

    public int getSize() {
        return size;
    }
    public Node getRoot() {
        return root;
    }
    public void add(X item) {
        Node newNode = new Node(item);

        if (this.root == null) {
            this.root = newNode;
            this.size++;
            System.out.println("Root : " + newNode.getData());
        } else {
            insert(this.root, newNode);
        }
    }

    public boolean delete(X item) {
        boolean deleted = false;

        //return false if tree is empty.
        if (this.root == null) {
            return false;
        }

        //get node to be deleted.
        Node current = getNode(item);

        //if node found.
        if (current != null) {
            if (current.getLeft() == null && current.getRight() == null) {
                //if this is a leaf node, then just link .
                unlink(current, null);
                deleted = true;
            } else if (current.getLeft() == null && current.getRight() != null) {
                //if the node doesnt have left child, replace node with it right child
                unlink(current, current.getRight());
                deleted = true;
            } else if (current.getLeft() != null && current.getRight() == null) {
                //if the node doesnt have right child, replace node with it left child
                unlink(current, current.getLeft());
                deleted = true;
            } else {
                //if node has both left and right child, then find the right most child on the left
                // side of this node.
                Node child = current.getLeft();
                while (child.getRight() != null && child.getLeft() != null) {
                    child = child.getRight();
                }

                Node right = child.getParent().getRight();

                //unlink this child from its parent.
                child.getParent().setRight(null);

                //move the node' right node to child's right.
                child.setRight(right);

                //move the node's left node to child's left if it not the child itself;
                if (current.getLeft().getData().compareTo(child.getData()) != 0) {
                    child.setLeft(current.getLeft());
                } else {
                    child.setLeft(null);
                }

                //replace node with this child node.
                unlink(current, child);
                deleted = true;
            }
        }

        if(deleted == true) {
            this.size--;
        }

        return deleted;
    }

    private void insert(Node parent, Node child) {
        if (child.getData().compareTo(parent.getData()) <= 0) {
            if (parent.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getLeft(), child);
            }
        } else if (child.getData().compareTo(parent.getData()) > 0) {
            if (parent.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                this.size++;
            } else {
                insert(parent.getRight(), child);
            }
        }
    }

    private void unlink(Node predecessor, Node successor) {
        if (predecessor == this.root) {
            successor.setRight(predecessor.getRight());
            successor.setLeft(predecessor.getLeft());
            this.root = successor;
        } else if (predecessor.getParent().getRight() == predecessor) {
            // Check if this node is the right node of its parent.
            predecessor.getParent().setRight(successor);
        } else {
            predecessor.getParent().setLeft(successor);
        }
    }
    public boolean contains(X item) {
        //return lookUp(this.root, item);
        return getNode(item) != null;
    }

    public boolean lookUp(Node current, X item) {
        if (current == null) {
            return false;
        }
        /*
        if (current.getData().compareTo(item) == 0) {
            return true;
        } else if (current.getData().compareTo(item) < 0) {
            return lookUp(current.getRight(), item);
        } else {
            return lookUp(current.getLeft(), item);
        }*/
        return (current.getData() == item || lookUp(current.getLeft(), item) || lookUp(current.getRight(), item));
    }


    private Node getNode(X item) {
        System.out.println("Searching item : " + item);
        Node currentNode = this.root;
        while(currentNode != null) {

            if (currentNode.getData().compareTo(item) == 0) {
                return currentNode;
            } else if (currentNode.getData().compareTo(item) < 0) {
                currentNode = currentNode.getRight();
            } else {
                currentNode = currentNode.getLeft();
            }
        }
        return null;
    }

    public String inOrderToString() {
        StringBuffer contents = new StringBuffer();
        contents.append("InOrder : [");
        inOrderGetNode(this.root, contents);
        contents.deleteCharAt(contents.length()-1);
        contents.append("]");
        return contents.toString();
    }

    private void inOrderGetNode(Node current, StringBuffer contents) {
        if (current == null) {
            return;
        }

        inOrderGetNode(current.getLeft(), contents);
        contents.append(current.getData()+ ",");
        inOrderGetNode(current.getRight(), contents);
    }

    public String preOrderToString() {
        StringBuffer contents = new StringBuffer();
        contents.append("PreOrder : [");
        preOrderGetNode(this.root, contents);
        contents.deleteCharAt(contents.length()-1);
        contents.append("]");
        return contents.toString();
    }

    private void preOrderGetNode(Node current, StringBuffer contents) {
        if (current == null) {
            return;
        }

        contents.append(current.getData()+ ",");
        preOrderGetNode(current.getLeft(), contents);
        preOrderGetNode(current.getRight(), contents);
    }

    public String postOrderToString() {
        StringBuffer contents = new StringBuffer();
        contents.append("PostOrder : [");
        postOrderGetNode(this.root, contents);
        contents.deleteCharAt(contents.length()-1);
        contents.append("]");
        return contents.toString();
    }

    private void postOrderGetNode(Node current, StringBuffer contents) {
        if (current == null) {
            return;
        }
        postOrderGetNode(current.getLeft(), contents);
        postOrderGetNode(current.getRight(), contents);
        contents.append(current.getData()+ ",");
    }

    private class Node {
        private Node left;
        private Node right;
        private Node parent;
        private X data;

        public Node(X item) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.data = item;
        }


        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public X getData() {
            return data;
        }

        public void setData(X data) {
            this.data = data;
        }
    }
}
