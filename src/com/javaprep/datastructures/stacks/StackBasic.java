package com.javaprep.datastructures.stacks;

public class StackBasic {
    private int[] data;
    private int stackPointer;
    private int size;


    public StackBasic() {
        this(10);
    }
    public StackBasic(int size) {
        this.data = new int[size];
        this.size = size;
        this.stackPointer = 0;
    }

    public void push(int data) {
        if (this.stackPointer == this.size) {
            throw new IndexOutOfBoundsException("Stack is Full, push failed");
        }
        this.data[this.stackPointer] = data;
        this.stackPointer++;
    }

    public int pop() {
        if (this.stackPointer == 0) {
            throw new IndexOutOfBoundsException("Stack is Empty, pop failed");
        }
        int poppedValue = this.data[--this.stackPointer];
        return poppedValue;
    }

    public int top() {
        return this.data[this.stackPointer - 1];
    }

    public boolean isEmpty() {
        return this.stackPointer == 0;
    }

    public boolean contains(int item) {
        if (this.isEmpty()) {
            return false;
        }
        for (int i = 0; i < this.stackPointer; i++) {
            if (this.data[i] == item) {
                return true;
            }
        }
        return false;
    }

    public int access(int item) {
        if (this.isEmpty()) {
            return -1;
        }
        int size = this.stackPointer;
        for (int i = 0; i < size; i++) {
            if (this.data[i] == item) {
                return i;
            }
            pop();
        }
        return -1;
    }

    public int currentSize() {
        return this.stackPointer;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        contents.append("STACK => [");
        for(int i = 0; i < this.stackPointer; i++) {
           contents.append(data[i]);
           if(i != this.stackPointer-1) {
               contents.append(",");
           }
        }
        contents.append("]");
        return contents.toString();
    }
}
