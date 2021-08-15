package com.javaprep.concurrency;

/**
 * Subclass Thread. The Thread class itself implements Runnable, though its run method does nothing.
 * An application can subclass Thread, providing its own implementation of run
 */
public class HelloThread extends Thread {
    public void run () {
        System.out.println("Hello this is extending Thread");
    }
}
