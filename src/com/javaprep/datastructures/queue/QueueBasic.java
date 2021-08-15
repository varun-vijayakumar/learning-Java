package com.javaprep.datastructures.queue;

public class QueueBasic {
    private int[] data;
    private int queueFront;
    private int queueEnd;
    private int size;

    public QueueBasic() {
       // this(10);
    }

    public QueueBasic(int size) {
        this.data = new int[size];
        this.queueFront = -1;
        this.queueEnd = -1;
        this.size = size;
    }

    public boolean isEmpty() {
        return this.queueFront == -1 && this.queueEnd == -1;
    }

    public boolean isFull() {
        return ((this.queueEnd + 1) % this.size == this.queueFront);
    }

    public int currentSize() {
        if (isEmpty()) {
            return 0;
        } else {
            return Math.abs(this.queueEnd - this.queueFront + 1);
        }
    }

    public void enQueue(int item) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Queue is Full");
        }
        if(isEmpty()) {
            this.queueFront = (this.queueFront + 1) % this.size;
        }

        this.queueEnd = (this.queueEnd + 1) % this.size;
        this.data[this.queueEnd] = item;

    }

    public int deQueue() {
        int item;
        if(currentSize() == 0) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        } else if (this.queueEnd == this.queueFront) {
            item = this.data[this.queueFront];
            this.queueEnd = -1;
            this.queueFront = -1;
        } else {
            item = this.data[this.queueFront];
            this.queueFront = (this.queueFront + 1) % size;
        }
        return item;
    }

    public int getFront() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        return this.data[this.queueFront];
    }

    public int getEnd() {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is Empty");
        }
        return this.data[this.queueEnd];
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        contents.append("Queue ==> [");
        int i = this.queueFront;
        int j = currentSize();
        while(j != 0) {
            contents.append(this.data[i]);
            i = (i + 1) % this.size;
            j --;
            if (j != 0) {
                contents.append(",");
            } else {
                break;
            }
        }
        contents.append("]");
        return contents.toString();
    }
}
