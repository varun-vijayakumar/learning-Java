package com.javaprep.concurrency;

/**
 * An application that creates an instance of Thread must provide the code that will run in that thread.
 * There are 2 ways to doing this .
 * 1. Provide a Runnable object
 * 2. Subclass Thread.
 */
public class ThreadsDriver {
    //1. Provide a Runnable object
    public static void threadsRunnableDriver() {
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);
        thread.start();
        System.out.println("thread name :  " + thread.getName() + " id : " + thread.getId());
    }
    //2. Subclass Thread.
    public static void threadsThreadDriver() {
        HelloThread helloThread  = new HelloThread();
        helloThread.start();
        System.out.println("thread name :  " + helloThread.getName() + " id : " + helloThread.getId());
    }



}
