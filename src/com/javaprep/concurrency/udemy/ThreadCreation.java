package com.javaprep.concurrency.udemy;





public class ThreadCreation {

    public void createThreadUsingRunnable() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running | threadName : "+ Thread.currentThread().getName() + " | id : " +
                        Thread.currentThread().getId());
                System.out.println("Running | threadName : "+ Thread.currentThread().getName() + " | prirority : " +
                        Thread.currentThread().getPriority());
                throw new RuntimeException("internal exception");
            }
        });
        thread.setName("New-Worker-Thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Error | A critical error occured within thread | threadName : "+ Thread.currentThread().getName() + " | id : " +
                        Thread.currentThread().getId());
            }
        });
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Before Starting | threadName : "+ Thread.currentThread().getName() + " | thread id : " + Thread.currentThread().getId()+
                " | prirority : " + Thread.currentThread().getPriority());
        thread.start();
        System.out.println("After Starting  | threadName : "+ Thread.currentThread().getName() + " | thread id : " + Thread.currentThread().getId()+
                " | prirority : " + Thread.currentThread().getPriority());

        Thread.sleep(1000);
    }

    public class NewThread extends Thread {
        @Override
        public void run() {
            this.setName(this.getClass().getSimpleName());
            System.out.println("Hello from "+ this.getName());
            super.run();
        }
    }

    public void createUsingThread() {
        NewThread newThread = new NewThread();
        newThread.start();
    }

}
