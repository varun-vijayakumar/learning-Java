package com.javaprep.datastructures.hash;

import java.util.HashMap;

public class HashDriver {
    public static void hashBasicDriver() {
        System.out.println("hashBasicExample");
        HashBasic hash = new HashBasic(6);
        String keys[] = {"key1", "key2", "key3", "key4", "key5", "keys6"};
        String values [] = {"this","is","a","new", "world", "!!!"};

        System.out.println("+++++++++++++++++++++");
        System.out.println("Hash Add tests");
        System.out.println("Hash Size : " + hash.getSize());
        for (int i = 0; i < 5; i++) {
            if (hash.get(keys[i]) == null) {
                hash.put(keys[i], values[i]);
            }
            System.out.println("Hash Size : " + hash.getSize());
        }

        System.out.println("HASH READ");
        for(int i = 0; i< 6; i++) {
            System.out.println("key : " + keys[i]+ " value : " + hash.get(keys[i]));
        }

        System.out.println("Hash Size : " + hash.getSize());
        System.out.println("HASH ADD AGAIN ");
        for (int i = 0; i < 5; i++) {
            if (!hash.get(keys[i]).equals(values[i])) {
                hash.put(keys[i], values[i]);
            } else {
                System.out.println("Entry exists");
            }
        }

        System.out.println("+++++++++++++++++++++");
        System.out.println("HashDelete Tests");
        System.out.println("Hash Size : " + hash.getSize());
        for(int i = 0; i < 3; i++) {
            System.out.println("Hash Size : " + hash.getSize());
            System.out.println("Removing entry  key : " + keys[i] +" value : "+ hash.get(keys[i]) + ", from hash");
            System.out.println("Removed entry  key : " + keys[i] +" value : "+ hash.delete(keys[i]) + ". from hash");
        }

        System.out.println("Trying to removed entry  key - invalid  value : "+ hash.delete("invalid") + ", from hash");
        System.out.println("+++++++++++++++++++++");
        System.out.println("HasValue & HasKey tests");
        System.out.println("Hash Size    : " + hash.getSize());

        for (int i = 0; i < 5; i++) {
            System.out.println("----------");
            System.out.println("has key   : " + keys[i] + ", in hash : " + hash.hasKey(keys[i]));
            System.out.println("has value : " + values[i] + ", in hash : " + hash.hasValue(values[i]));
        }
        System.out.println("+++++++++++++++++++++");
    }


    public static void javaHashDriver() {
        System.out.println("javaHashExample");

        /**
         * Java provides Map<K,V> interface.
         * Two implemenations.
         * Hashtable<K,V> - Legacy implementatin, Synchronized like vectors, doesn't allow null.
         * HashMap<K,V> - Newer implementation, Not Synchronized, allows null. Most used.
         */
        HashMap<String, String> hash = new HashMap<String, String>();


        String keys[] = {"key1", "key2", "key3", "key4", "key5", "keys6"};
        String values [] = {"this","is","a","new", "world", "!!!"};

        System.out.println("+++++++++++++++++++++");
        System.out.println("Hash Add tests");
        System.out.println("Hash Size : " + hash.size());

        for (int i = 0; i < 5; i++) {
            if (hash.get(keys[i]) == null) {
                hash.put(keys[i], values[i]);
            }
            System.out.println("Hash Size : " + hash.size());
        }


        System.out.println("HASH READ");
        for(int i = 0; i< 6; i++) {
            System.out.println("key : " + keys[i]+ " value : " + hash.get(keys[i]));
        }

        System.out.println("Hash Size : " + hash.size());
        System.out.println("HASH ADD AGAIN ");
        for (int i = 0; i < 5; i++) {
            if (!hash.get(keys[i]).equals(values[i])) {
                hash.put(keys[i], values[i]);
            } else {
                System.out.println("Entry exists");
            }
        }


        System.out.println("+++++++++++++++++++++");
        System.out.println("HashDelete Tests");
        System.out.println("Hash Size : " + hash.size());
        for(int i = 0; i < 3; i++) {
            System.out.println("Hash Size : " + hash.size());
            System.out.println("Removing entry  key : " + keys[i] +" value : "+ hash.get(keys[i]) + ", from hash");
            System.out.println("Removed entry  key : " + keys[i] +" value : "+ hash.remove(keys[i]) + ". from hash");
        }

        System.out.println("Trying to removed entry  key - invalid  value : "+ hash.remove("invalid") + ", from hash");
        System.out.println("+++++++++++++++++++++");
        System.out.println("HasValue & HasKey tests");
        System.out.println("Hash Size    : " + hash.size());


        for (int i = 0; i < 5; i++) {
            System.out.println("----------");
            System.out.println("has key   : " + keys[i] + ", in hash : " + hash.containsKey(keys[i]));
            System.out.println("has value : " + values[i] + ", in hash : " + hash.containsValue(values[i]));
        }
        System.out.println("+++++++++++++++++++++");

        System.out.println("+++++++++++++++++++++");
        System.out.println("Replace Tests");
        System.out.println("OLD key : " + keys[4] + " value : " + hash.get(keys[4]));
        hash.replace(keys[4], "REPLACED");
        System.out.println("NEW key : " + keys[4] + " value : " + hash.get(keys[4]));
        System.out.println("+++++++++++++++++++++");




    }
}
