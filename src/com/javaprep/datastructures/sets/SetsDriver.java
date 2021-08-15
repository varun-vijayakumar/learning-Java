package com.javaprep.datastructures.sets;

import javax.print.DocFlavor;
import java.util.*;

/**
 * Sets Vs Arrays :
 * Sets   : unordered, no duplicates allowed, lookup - O(1)
 * Arrays : ordered, duplicates allowed, lookup - O(n)
 * https://www.freecodecamp.org/news/learn-your-coding-fundamentals-the-main-differences-between-sets-and-arrays-4a9ed29bfb2f/
 *
 * The following methods are present in the Set Interface:
 *
 * METHOD	DESCRIPTION
 * add(element)
 *      This method is used to add a specific element to the set. The function adds the element only if the
 *      specified element is not already present in the set else the function returns False if the element is already
 *      present in the Set.
 * addAll(collection)
 *      This method is used to append all of the elements from the mentioned collection to the existing set.
 *      The elements are added randomly without following any specific order.
 * clear()
 *      This method is used to remove all the elements from the set but not delete the set.
 *      The reference for the set still exists.
 * contains(element)
 *      This method is used to check whether a specific element is present in the Set or not.
 * containsAll(collection)
 *      This method is used to check whether the set contains all the elements present in the given collection or not.
 *      Returns true if the set contains all the elements and returns false if any of the elements are missing.
 * hashCode()
 *      This method is used to get the hashCode value for this instance of the Set.
 *      It returns an integer value which is the hashCode value for this instance of the Set.
 * isEmpty()
 *      This method is used to check whether the set is empty or not.
 * iterator()
 *      This method is used to return the iterator of the set. The elements from the set are returned in a random order.
 * remove(element)
 *      This method is used to remove the given element from the set.
 *      This method returns True if the specified element is present in the Set otherwise it returns False.
 * removeAll(collection)
 *      This method is used to remove all the elements from the collection which are present in the set.
 *      This method returns true if this set changed as a result of the call.
 * retainAll(collection)
 *      This method is used to retain all the elements from the set which are mentioned in the given collection.
 *      This method returns true if this set changed as a result of the call.
 * size()
 *      This method is used to get the size of the set. Returns an integer value which signifies the number of elements.
 * toArray()
 *      This method is used to form an array of the same elements as that of the Set.
 */

public class SetsDriver {
    enum enumValues {
        THIS,
        IS,
        AN,
        EXAMPLE,
    };

    public static void javaSets() {
        /**
         * HashSet is a widely used implemenation of Set Interface.
         * No order is maintained.
         * Hash of the values are calculated and stored.
         * Allows null values as well.
         */
        Set<String> hashSet = new HashSet<String>();
        hashSet.add("this");
        hashSet.add("is");
        hashSet.add("a");
        hashSet.add("test");
        System.out.println(hashSet);
        hashSet.add("test2");
        hashSet.add("test");
        hashSet.add(null);
        hashSet.add("");
        System.out.println(hashSet);


        System.out.println("Contains : this -> " + hashSet.contains("this"));
        System.out.println("Contains : set --> " + hashSet.contains("set"));
        System.out.println("Contains : test2 -> " + hashSet.contains("test2"));
        hashSet.remove("test2");
        System.out.println(hashSet);
        System.out.println("Contains : test2 -> " + hashSet.contains("test2"));

        for (String element : hashSet) {
            System.out.print(element + " ");
        }
        System.out.println();

        Set<Integer> a = new HashSet<>();
        Set<Integer> hashSet2 = new HashSet<>();
        a.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));
        hashSet2.addAll(Arrays.asList(new Integer[] {1, 3, 7, 5, 4, 0, 7, 5}));

        /**
         * UNION, INTERSECTION, DIFFERENCE
         */
        Set<Integer> union = new HashSet<>(a);
        Set<Integer> intersection = new HashSet<>(a);
        Set<Integer> difference = new HashSet<>(a);

        union.addAll(hashSet2); //union a U b
        intersection.retainAll(hashSet); //intersection a n b
        difference.removeAll(hashSet); //difference a - b

        System.out.println(" a     : " + a);
        System.out.println(" b     : " + hashSet2);
        System.out.println(" a U b : " + union);
        System.out.println(" a n b : " + intersection);
        System.out.println(" a - b : " + difference);

        for (Integer element : union) {
            System.out.print(element + " ");
        }
        System.out.println();

        /**
         * EnumSet : A special implemenation of Set Interface for
         * Enum Types.
         * High performace enum type, much faster than HashSet.
         * All of the elements in an enum set must come from a single enumeration type that
         * is specified when the set is created either explicitly or implicitly.
         */
         Set<enumValues> enumSet = EnumSet.of(enumValues.EXAMPLE,
                 enumValues.IS, enumValues.AN, enumValues.THIS);
         System.out.println("EnumSet : " + enumSet);

        /**
         * LinkedHashSet : An ordered version of HashSet that used doubly linked list across
         * all the elements.
         * HashSet iteration doesn't give ordered(inserted order) output.
         * LinkedHashSet gives ordered output.
         */
         Set<String> hashSetEx = new HashSet<String>();
         hashSetEx.add("This");
         hashSetEx.add("is");
         hashSetEx.add("an");
         hashSetEx.add("example");
         hashSetEx.add("of");
         hashSetEx.add("LinkedHashSet");

         Set<String> linkedHashSet = new LinkedHashSet<String>();
         linkedHashSet.add("This");
         linkedHashSet.add("is");
         linkedHashSet.add("an");
         linkedHashSet.add("example");
         linkedHashSet.add("of");
         linkedHashSet.add("LinkedHashSet");


         System.out.println("Hash Set         : " + hashSetEx); //not ordered.
         System.out.println("Linked Hash Set  : " + linkedHashSet); //ordered.

        //Iterator example
        System.out.print("iterator LinkedHashSet : " );
        Iterator linkedHashSetItem = linkedHashSet.iterator();
        while(linkedHashSetItem.hasNext()) {
            System.out.print(linkedHashSetItem.next()+ " ");
        }
        System.out.println();

        System.out.print("iterator HashSet : " );
        Iterator hashSetItem = hashSetEx.iterator();
        while(hashSetItem.hasNext()) {
            System.out.print(hashSetItem.next()+ " ");
        }
        System.out.println();

        System.out.print("iterator EnumSet : " );
        Iterator enumSetIterator = enumSet.iterator();

        while(enumSetIterator.hasNext()) {
            System.out.print(enumSetIterator.next()+ " ");
        }
        System.out.println();

        /**
         * TreeSet : An implementation of SortedSet Interface.
         * Elements are added in a sorted order - ascending.
         * Can fetch the desceding order using TreeSet.descendingIterator().
         * An implementation of Self Balancing Tree.
         */
        Set<String> treeSet = new TreeSet<String>();
        treeSet.add("ZZ");
        treeSet.add("CC");
        treeSet.add("AA");
        treeSet.add("BB");
        System.out.println("TreeSet : " + treeSet);

        /**
         * to use desceding iterator, should treeSet should be TreeSet, not Set as Set cannot
         * inherit descedingIterator.
         */
        TreeSet<String> treeSet1 = new TreeSet<String>();
        treeSet1.add("1.0.1");
        treeSet1.add("1.0.2");
        treeSet1.add("1.0.3");
        treeSet1.add("1.0.4");
        treeSet1.add("1.0.5");
        System.out.println("Tree Set1  : " + treeSet1);

        System.out.print("iteration TreeSet descending : " );
        Iterator treeSetItem = treeSet1.descendingIterator();
        while(treeSetItem.hasNext()) {
            System.out.print(treeSetItem.next() + " ");
        }
        System.out.println();

        System.out.print("iteration TreeSet default/ascending: " );
        treeSetItem = treeSet1.iterator();
        while(treeSetItem.hasNext()) {
            System.out.print(treeSetItem.next() + " ");
        }
        System.out.println();
        System.out.println("smallest in Tree Set : " + ((TreeSet<String>) treeSet1).first());
        System.out.println("largest in Tree Set : " + ((TreeSet<String>) treeSet1).last());

        System.out.println("--------------");
        System.out.println("hash set iteration without Iterator");
        for(String item : hashSetEx) {
            System.out.println(item);
        }
    }
}
