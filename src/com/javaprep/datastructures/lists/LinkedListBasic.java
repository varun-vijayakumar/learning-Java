package com.javaprep.datastructures.lists;

public class   LinkedListBasic {
    private Node head;
    private Node tail;
    private int  nodeCount;

    public LinkedListBasic() {
        this.head = null;
        this.tail = null;
        nodeCount = 0;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getTail() {
        return this.tail;
    }

    public int size() {
        return this.nodeCount;
    }

    public void makeEmpty() {
        setHead(null);
    }

    public void add(int item) {
        if (this.head == null) {
            Node newNode = new Node(item);
            this.head = newNode;
            this.tail = this.head;
        } else {
            Node newTailNode = new Node(item);
            this.tail.setNextNode(newTailNode);
            this.tail = newTailNode;
        }
        nodeCount++;
    }

    public int remove() {
        if (this.head == null) {
            throw new IllegalStateException("Linked List is empty, cannot perform remove operation");
        }
        int deletedData = this.head.getNodeData();
        this.head = this.head.getNextNode();
        this.nodeCount--;
        if (this.nodeCount == 0) {
            this.head = null;
            this.tail = null;
        }
        return deletedData;
    }

    public void insertAt(int data, int position) {

        if (this.size() < position) {
            throw new IllegalStateException("The Linked List size "+ size() +" is smaller that position " + position +
                    " requested to insert");
        }

        if (position == 0) {
            Node newNode = new Node(data);
            newNode.setNextNode(this.head);
            this.head = newNode;
            this.nodeCount++;
            return;
        }

        Node current = this.head;
        int pos = 0;

        while(current.getNextNode() != null) {
            if (pos == position-1) {
                break;
            }
            current = current.getNextNode();
            pos++;
        }
        Node newNode = new Node(data);
        newNode.setNextNode(current.getNextNode());
        current.setNextNode(newNode);
        this.nodeCount++;
    }

    public int removeAt(int position) {
        if (this.size() < position) {
            throw new IllegalStateException("The Linked List size "+ size() +" is smaller that position " + position +
                    " requsted to remove");
        }

        int pos = 0;
        Node current = this.head;

        while(current.getNextNode() != null) {
            if (pos == position-1) {
                break;
            }
            current = current.getNextNode();
            pos++;
        }
        Node deletingNode = current.getNextNode();
        current.setNextNode(deletingNode.getNextNode());
        this.nodeCount--;

        if(position == this.size()-1) {
            this.tail = current.getNextNode();
        }

        return deletingNode.getNodeData();
    }

    public int getDataAt(int position) {
        if (this.size() < position) {
            throw new IllegalStateException("The Linked List size "+ size() +" is smaller that position " + position +
                    " requsted to get");
        }

        int pos = 0;
        Node current = this.head;
        while(current != null) {
            if (pos == position) {
                return current.getNodeData();
            }
            current = current.getNextNode();
            pos++;
        }
        return -1;
    }

    public int findPosition(int data) {
        if (this.head == null) {
            throw new IllegalStateException("The Linked List size is empty to find the data " + data + " requested");
        }

        Node current = this.head;
        int pos = 0;
        while(current != null) {
            if (current.getNodeData() == data) {
                return pos;
            }
            pos++;
            current = current.getNextNode();
        }
        return -1;
    }

    public boolean isEmpty() {
        return (this.head == null && this.tail == null && this.size() == 0);
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node current = this.head;

        while(current != null) {
            contents.append(current.getNodeData());
            current = current.getNextNode();
            if (current != null) {
                contents.append("->");
            }
        }
        return contents.toString();
    }

    public void printList() {
        Node current = this.head;

        while(current != null) {
            System.out.print(current.getNodeData());
            current = current.getNextNode();
            if (current != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public void reversePrint(Node head) {
        if (head == null) return;
        reversePrint(head.next);
        System.out.print(head.data+ " ");
    }

    private class Node {
        private Node next;
        private int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public void setNextNode(Node nextNode) {
            this.next = nextNode;
        }

        public int getNodeData() {
            return this.data;
        }

        public Node getNextNode() {
            return this.next;
        }
    }
}
