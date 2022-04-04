package bearmaps.proj2ab;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> implements ExtrinsicMinPQ<T>{

    private MinHeap<Node<T>,T> root;
    private HashMap<T, Double> items;

    public ArrayHeapMinPQ(){
        root = new MinHeap<>();
        items = new HashMap<>();
    }

    @Override
    /* Adds an item with the given priority value. Throws an
     * IllegalArgumentExceptionb if item is already present.
     * You may assume that item is never null. */
    public void add(T item, double priority){
        items.put(item, priority);
        Node<T> add = new Node<>(item, priority);
        root.add(add);
    }

    @Override
    /* Returns true if the PQ contains the given item. */
    public boolean contains(T item){
        return items.containsKey(item);
    }

    @Override
    /* Returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    public T getSmallest(){
        return root.getSmallest().getItem();
    }

    @Override
    /* Removes and returns the minimum item. Throws NoSuchElementException if the PQ is empty. */
    public T removeSmallest(){
        Node returned = root.removeSmallest();
        return (T) returned.getItem();
    }

    @Override
    /* Returns the number of items in the PQ. */
    public int size(){
        return root.size();
    }

    @Override
    /* Changes the priority of the given item. Throws NoSuchElementException if the item
     * doesn't exist. */
    public void changePriority(T item, double priority){
        if (! contains(item)){
            throw new NoSuchElementException("there is no such a item");
        }
        double originalP = items.get(item);
        items.replace(item, priority);
        root.changePriority(item, originalP, priority);
    }

    public double getpriority (T item){
        return items.get(item);
    }

}
