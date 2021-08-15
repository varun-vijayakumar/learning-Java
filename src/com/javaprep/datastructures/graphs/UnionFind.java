package com.javaprep.datastructures.graphs;
public class UnionFind {
    // The number of elements in this union find
    private int size;

    // To tract the root of each element;
    private int[] roots;

    // To track size of each component/disjoint set
    private int[] disjointSets; // if disjointSets[id] == id ==> id is the root node

    // Track the number of components/disjoint sets in the union find
    private int numOfDisjointSets;


    public UnionFind (int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size should be >= 0");
        }
        this.size = size;
        this.roots = new int[this.size];
        this.disjointSets = new int[this.size];

        for (int i = 0; i < this.size; i++) {
            this.roots[i] = i; // initially all elements are a root of itself - points to itself
            this.disjointSets[i] = 1; // intially all elements are in a disjoint set containing just itself.
        }
    }

    // Return the number of elements in this UnionFind/Disjoint set
    public int getSize() {
        return this.size;
    }

    //checks if two elements are connected.
    public boolean isConnected(int source, int target) {
        return findRoot(source) == findRoot(target);
    }
    //returns size of the set/group that the element belongs to.
    public int disjointSetSize(int element) {
        return disjointSets[roots[element]];
    }

    // find root/groupId of an element.
    private int findRoot(int element) {
        int root = element;

        //root of parent until an element is reached who is the root of itself
        while (root != this.roots[root]) {
            root = roots[root

                    ];
        }

        //perform path compression - make all parents point to the root of the group/set
        // optimization - this is what gives amortized time complexity.
        while (root != element) {
            int parent = roots[element];
            roots[element] = root;
            element = parent;
        }
        return root;
    }
    // TODO : This is an alternative recursive formulation for the find method
    // public int find(int p) {
    //   if (p == roots[p]) return p;
    //   return roots[p] = findRoot(id[p]);
    // }

    private void unify(int source, int target) {
        int rootOfSource = findRoot(source);
        int rootOfTarget = findRoot(target);

        //if roots are same --> means same group --> skip
        if (rootOfSource == rootOfTarget) {
            return;
        }

        //merge smaller component/set to larger component/set
        if (disjointSets[rootOfSource] < disjointSets[rootOfTarget]) {
            disjointSets[rootOfTarget] += disjointSets[rootOfSource];
            disjointSets[rootOfSource] = rootOfTarget;
        } else {
            disjointSets[rootOfSource] += disjointSets[rootOfTarget];
            disjointSets[rootOfTarget] = rootOfSource;
        }

        //reduce the number of disjoints sets/componets as two sets have merged now.
        this.numOfDisjointSets--;
    }
}
