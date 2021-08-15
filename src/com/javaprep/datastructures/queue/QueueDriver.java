package com.javaprep.datastructures.queue;

import java.sql.SQLSyntaxErrorException;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDriver {
    public static void queueBasicDriver() {
        QueueBasic queueBasic = new QueueBasic(5);

        System.out.println("-----------------------------");
        System.out.println("Empty : " + queueBasic.isEmpty());
        System.out.println("Full  : " + queueBasic.isFull());


        for (int i = 0; i < 5; i++) {
            queueBasic.enQueue(i+10);
        }

        System.out.println(queueBasic.toString());

        System.out.println("Empty : " + queueBasic.isEmpty());
        System.out.println("Full  : " + queueBasic.isFull());
        System.out.println("Front : " + queueBasic.getFront());
        System.out.println("End   : " + queueBasic.getEnd());
        System.out.println("CurrentSize : " + queueBasic.currentSize());

        System.out.println("-----------------------------");
        System.out.println("Dequeue Start : "+ queueBasic);
        for (int i = 0; i < 5; i++) {
            System.out.println("+++++++++++++++++++++++");
            System.out.println("Dequeue : i = " + i + " dequeued : " + queueBasic.deQueue());
            System.out.println(queueBasic);
            System.out.println("Empty : " + queueBasic.isEmpty());
            System.out.println("Full  : " + queueBasic.isFull());
            if (!queueBasic.isEmpty()) {
                System.out.println("Front : " + queueBasic.getFront());
                System.out.println("End   : " + queueBasic.getEnd());
            }
            System.out.println("CurrentSize : " + queueBasic.currentSize());
            System.out.println("+++++++++++++++++++++++");
        }

        System.out.println("Dequeue Complete : Enque Start : " + queueBasic);

        System.out.println("-----------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("+++++++++++++++++++++++");
            System.out.println("Enqueue : " + i);
            queueBasic.enQueue(i+20);
            System.out.println(queueBasic);
            System.out.println("Empty : " + queueBasic.isEmpty());
            System.out.println("Full  : " + queueBasic.isFull());
            System.out.println("Front : " + queueBasic.getFront());
            System.out.println("End   : " + queueBasic.getEnd());
            System.out.println("CurrentSize : " + queueBasic.currentSize());
            System.out.println("+++++++++++++++++++++++");
        }

        System.out.println("Enque Complete : " + queueBasic);
    }

    public static void javaQueueDriver() {
        /**
         * Java provides Queue<E> Interfaces
         * Various implemenations like LinkedList, SynchronousQueue,
         * PriorityBlockingQueue etc.
         */
        Queue<Integer> javaQueue = new LinkedList<Integer>();

        System.out.println("-----------------------------");
        System.out.println("Empty : " + javaQueue.isEmpty());


        for (int i = 0; i < 5; i++) {
            javaQueue.add(i+100);
        }


        System.out.println("JAVA QUEUE =>  " + javaQueue.toString());

        System.out.println("Empty : " + javaQueue.isEmpty());
        System.out.println("Front : " + javaQueue.peek());
        System.out.println("CurrentSize : " + javaQueue.size());

        System.out.println("-----------------------------");
        System.out.println("Dequeue Start : "+ javaQueue);
        for (int i = 0; i < 4; i++) {
            System.out.println("+++++++++++++++++++++++");
            System.out.println("Dequeue : i = " + i + " dequeued : " + javaQueue.remove());
            System.out.println(javaQueue);
            System.out.println("Empty : " + javaQueue.isEmpty());
            if (!javaQueue.isEmpty()) {
                System.out.println("Front : " + javaQueue.peek());
            }
            System.out.println("CurrentSize : " + javaQueue.size());
            System.out.println("+++++++++++++++++++++++");
        }

        System.out.println("Dequeue Complete : Enque Start : " + javaQueue);

        System.out.println("-----------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("+++++++++++++++++++++++");
            System.out.println("Dequeue : i = " + i + " dequeued : " + javaQueue.add(i+200));
            System.out.println(javaQueue);
            System.out.println("Empty : " + javaQueue.isEmpty());
            if (!javaQueue.isEmpty()) {
                System.out.println("Front : " + javaQueue.peek());
            }
            System.out.println("CurrentSize : " + javaQueue.size());
            System.out.println("+++++++++++++++++++++++");
        }

        System.out.println("Enque Complete : JAVA QUEUE ==> " + javaQueue);

        System.out.println("ELEMENT : "+ javaQueue.element()); //kinda like peek, returns Expception.
        System.out.println("POLL : "+ javaQueue.poll());

        System.out.println(javaQueue.toString());
        javaQueue.remove(javaQueue.peek());
        System.out.println(javaQueue.toString());


    }
}
