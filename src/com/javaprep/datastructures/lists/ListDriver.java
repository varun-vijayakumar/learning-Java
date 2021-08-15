package com.javaprep.datastructures.lists;

import java.util.LinkedList;

public class ListDriver {
    public static void linkedListBasicDriver() {
        LinkedListBasic linkedList = new LinkedListBasic();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i+10);
        }

        System.out.println(linkedList.toString());
        System.out.println(linkedList.isEmpty());

        for (int i = 0; i < 6; i++) {
            if (!linkedList.isEmpty()) {
                System.out.println("Removing item at pos " + i + " of LL : " + linkedList);
                linkedList.remove();
            }
        }
        System.out.println(linkedList.isEmpty());

        LinkedListBasic linkedList2 = new LinkedListBasic();
        for (int i = 0; i < 5; i++) {
            linkedList2.insertAt(i+20, i);
        }

        System.out.println(linkedList2.toString());

        linkedList2.insertAt(100, 0);
        System.out.println(linkedList2.toString());
        linkedList2.insertAt(300, 3);
        System.out.println(linkedList2.toString());
        linkedList2.insertAt(400, 7);
        System.out.println(linkedList2.toString());
        linkedList2.insertAt(500, 2);
        System.out.println(linkedList2.toString());

        for (int i = 20; i < 25; i++) {
            System.out.println(i + " is at pos : " + linkedList2.findPosition(i));
        }
        System.out.println(linkedList2.toString());
        for (int i = 0; i < linkedList2.size(); i++) {
            System.out.println(i + " has data : " + linkedList2.getDataAt(i));
        }
        System.out.println("#####################");
        System.out.println(linkedList2.toString());
        boolean removed = false;
        while(!linkedList2.isEmpty()) {
            System.out.println(linkedList2);
            System.out.println("-----------------------");
            removed = false;
            for (int i = 0; i < linkedList2.size();i++) {

                if (linkedList2.getDataAt(i) < 30) {
                    System.out.println("removed data :  " + linkedList2.removeAt(i) + " which was at " + i + "position");
                    removed = true;
                }

            }
            if (removed == false) break;
        }
        System.out.println(linkedList2.toString());

        System.out.println("**********");
        linkedList2.removeAt(3);
        System.out.println(linkedList2.toString());

        System.out.println("Printing in Reverse Order");
        System.out.println(linkedList2.toString());
        linkedList2.reversePrint(linkedList2.getHead());

    }

    public static void javaLinkedListDriver() {
        /**
         * Java provides List<E> interface.
         * Two implementatins.
         * Vector<E> - Synchronous (Thread Safe).
         * ArrayList<E> - Asynchronous (Not Thread Safe).
         * Here we will use LinkedList which is an implementation of Queue<E> interface.
         */
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            linkedList.add(i, i+300);
        }
        System.out.println(linkedList);

        System.out.println(linkedList.get(3));

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println("Size : " + linkedList.size());
            linkedList.remove(i);
        }
        System.out.println(linkedList);
        linkedList.clear();
        System.out.println(linkedList);
    }

}
