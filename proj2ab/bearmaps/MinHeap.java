package bearmaps;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MinHeap<Y extends Comparable<Y>,T> {

    private Y[] root;
    private int size;
    private int resizeFactor;
    private int searchResult; //the result of search function, return the index of target node from root

    public MinHeap (){
        root = (Y[]) Array.newInstance(Comparable.class, 4);
        root [0] = null;
        size = 0;
        resizeFactor = 3;
    }

    public MinHeap (Y item){
        root = (Y[]) Array.newInstance(Comparable.class, 4);
        //root = (Y[]) new Comparable[4];
        root [0] = null;
        root [1] = item;
        size = 1;
        resizeFactor = 3;
    }

    public void add (Y item){
        root [size + 1] = item;
        size += 1;
        swapup(size);
        if (size == root.length - 1){
            this.resize();
        }
    }

    public int size () {
        return this.size;
    }

    public Y getSmallest() {
        if (root[1] == null){
            throw new NoSuchElementException("PQ is empty");
        }
        return root[1];
    }

    public Y removeSmallest(){
        if (root[1] == null){
            throw new NoSuchElementException("PQ is empty");
        }
        Y returned = root [1];
        root[1] = root[size];
        root[size] = null;
        swapdown(1);
        size -= 1;
        return returned;
    }

    private void resize(){
        Y[] helper =  (Y[]) Array.newInstance(Comparable.class, this.size * resizeFactor + 1);
        for (int i = 1; i <= this.size; i += 1){
            helper[i] = root[i];
        }
        root = helper;
    }

    private void swapup(int n){
        if (n != 1 && root[n].compareTo(root[n/2]) < 0) {
            Y helper = root[n/2];
            root[n/2] = root [n];
            root[n] = helper;
            swapup (n/2);
        }
    }

    private void swapdown(int n){
        if (root[2 * n] == null && root[2 * n + 1] == null){
            return;
        } else if (root[2 * n + 1] == null){
            if (root[n].compareTo(root[2 * n]) > 0){
                Y helper = root[2 * n];
                root[2 * n] = root [n];
                root[n] = helper;
            }
        } else if (root[n].compareTo(root[2 * n]) > 0 || root[n].compareTo(root[2 * n + 1]) > 0) {
            if (root[2 * n].compareTo(root[2 * n + 1]) < 0){
                Y helper = root[2 * n];
                root[2 * n] = root [n];
                root[n] = helper;
                swapdown (2 * n);
            } else if (root[2 * n].compareTo(root[2 * n + 1]) > 0){
                Y helper = root[2 * n + 1];
                root[2 * n + 1] = root [n];
                root[n] = helper;
                swapdown (2 * n + 1);
            } else if (root[2 * n].compareTo(root[2 * n + 1]) == 0){
                int R = (int)(Math.random() + 0.5 );
                Y helper = root[2 * n + R];
                root[2 * n + R] = root [n];
                root[n] = helper;
                swapdown (2 * n + R);
            }
        }
    }

    public void changePriority (T item, double originalP, double newP){
        Node<T> comparator = new Node<> (item, originalP);
        search(1,comparator);
        ((Node)root[searchResult]).changePriority(newP);
        swapup(searchResult);
        swapdown(searchResult);
    }

    private void search (int starter, Node comparator){
        if (((Node)root[starter]).item == comparator.item) {
            searchResult = starter;
            return;
        } else {
            if (root[2 * starter] != null &&
                    comparator.compareTo((Node)root[2 * starter]) >= 0){
                search (2 * starter, comparator);
            }
            if (root[2 * starter + 1] != null &&
                    comparator.compareTo((Node)root[2 * starter + 1]) >= 0) {
                search(2 * starter + 1, comparator);
            }
        }
    }


}
