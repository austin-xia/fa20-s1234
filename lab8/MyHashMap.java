import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class MyHashMap<K,V> implements Map61B<K,V> {

    /* parameters **/
    private double loadFactor;
    //private double loadFactor_RT;
    private int initialSize;
    private int currentSize;
    private int tempSize;
    private int resizeFactor;
    //private ArrayList<K> rootList;
    public int load;
    private Node[] hashArray;

    /* constructor **/
    public MyHashMap(){
        loadFactor = 0.75;
        //loadFactor_RT = 0;
        initialSize = 16;
        currentSize = initialSize;
        resizeFactor = 2;
        load = 0;
        hashArray = new Node[initialSize];
    }

    public MyHashMap(int initialSize){
        loadFactor = 0.75;
        //loadFactor_RT = 0;
        this.initialSize = initialSize;
        currentSize = initialSize;
        resizeFactor = 2;
        load = 0;
        hashArray = new Node[initialSize];
    }

    public MyHashMap(int initialSize, double loadFactor){
        this.loadFactor = loadFactor;
        //loadFactor_RT = 0;
        this.initialSize = initialSize;
        currentSize = initialSize;
        resizeFactor = 2;
        load = 0;
        hashArray = new Node[initialSize];
    }

    @Override
    /** Removes all of the mappings from this map. */
    public void clear(){
        hashArray = new Node[currentSize];
        load = 0;
    }


    @Override
    /** Returns true if this map contains a mapping for the specified key. */
    public boolean containsKey(K key){
        int reduced_hashCode = reduced_hashCode(key, 31, currentSize);
        if (hashArray[reduced_hashCode] == null){
            return false;
        } else {
            return hashArray[reduced_hashCode].contains(key) != null;
        }
    }

    @Override
    /**
     * Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    public V get(K key){
        int reduced_hashCode = reduced_hashCode(key, 31, currentSize);
        if (hashArray[reduced_hashCode] == null){
            return null;
        } else {
            return (V)hashArray[reduced_hashCode].contains(key);
        }
    }

    @Override
    /** Returns the number of key-value mappings in this map. */
    public int size(){
        return this.load;
    }

    @Override
    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key,
     * the old value is replaced.
     */
    public void put(K key, V value){

        int reduced_hashCode = reduced_hashCode(key, 31, currentSize);

        if (hashArray[reduced_hashCode] == null){
            Node<K,V> Node = new Node<>(key, value);
            hashArray[reduced_hashCode] = Node;
            load += 1;
        } else if (hashArray[reduced_hashCode].contains(key) != null){
            hashArray[reduced_hashCode].overwrite(key, value);
        } else {
            hashArray[reduced_hashCode].add(key, value);
            load += 1;
        }
        if ((double)load/currentSize > loadFactor){
            this.resize();
        }
    }

    @Override
    /** Returns a Set view of the keys contained in this map. */
    public Set<K> keySet(){
        HashSet<K> keySet = new HashSet<>();
        for (K i: this){
            keySet.add(i);
        }
        return keySet;
    }

    @Override
    /**
     * Removes the mapping for the specified key from this map if present.
     * Not required for Lab 8. If you don't implement this, throw an
     * UnsupportedOperationException.
     */
    public V remove(K key){
        throw new UnsupportedOperationException("unsupported operation");
    }

    @Override
    /**
     * Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 8. If you don't implement this,
     * throw an UnsupportedOperationException.
     */
    public V remove(K key, V value){
        throw new UnsupportedOperationException("unsupported operation");
    }

    private int hashCode(K Key, int base){
        String helper = (String)Key;
        int hashCode = 0;
        for (int i = 0; i < helper.length(); i += 1){
            hashCode = hashCode * base + helper.charAt(i);
        }
        return hashCode;
    }

    private int reduced_hashCode(K Key, int base, int currentSize){
        int hashCode = hashCode(Key, base);
        int reduced_hashCode = Math.floorMod(hashCode, currentSize);
        return reduced_hashCode;
    }

    private void resize(){
        tempSize = currentSize * resizeFactor;
        Node[] hashArray2 = new Node[tempSize];
        for (K i : this){
            resize_put(i, this.get(i), hashArray2);
        }
        this.hashArray = hashArray2;
        currentSize = tempSize;
    }


    public void resize_put(K key, V value, Node[] hashArray){

        int reduced_hashCode = reduced_hashCode(key, 31, tempSize);

        if (hashArray[reduced_hashCode] == null){
            Node<K,V> Node = new Node<>(key, value);
            hashArray[reduced_hashCode] = Node;
        } else {
            hashArray[reduced_hashCode].add(key, value);
        }
    }



    @Override
    public Iterator<K> iterator() {
        return new hashMap_iterator();
    }

    private class hashMap_iterator implements Iterator<K> {
        Node Pos;

        private hashMap_iterator() {
            Pos = null;
            for (int i = 0; i < currentSize; i += 1){
                if (hashArray[i] != null){
                    Pos = hashArray[i];
                    break;
                }
            }
        }

        //return if this is the last elements in the hashmap
        @Override
        public boolean hasNext() {
            return Pos != null;
        }

        // return the next key in hashArray
        // return null if there is no next
        @Override
        public K next() {
            Node returned = Pos;
            if (Pos.hasNext(Pos)) {
                Pos = Pos.next;
                return (K) returned.Key;
            } else {
                int reduced_hashCode = reduced_hashCode((K) (Pos.Key), 31, currentSize);
                for (int i = reduced_hashCode + 1; i < currentSize; i += 1) {
                    if (hashArray[i] != null) {
                        Pos = hashArray[i];
                        return (K) returned.Key;
                    }
                }
            }
            Pos = null;
            return (K) returned.Key;
        }
    }


}
