package com.javaprep.concurrency;

/**
 * Provide a Runnable object. The Runnable interface defines a single method, run,
 * meant to contain the code executed in the thread.
 * The Runnable object is passed to the Thread constructor
 */
public class HelloRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello this is extending Runnable");
    }
}
