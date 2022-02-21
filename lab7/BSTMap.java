import java.util.Iterator;
import java.util.Set;

public class BSTMap <K extends Comparable<K>, V> implements Map61B <K, V> {

    public K Key;
    public V Value;
    public BSTMap left;
    public BSTMap right;

    /* constructor **/
    public BSTMap (){
        this.left = null;
        this.right = null;
    }

    /* constructor#2 **/
    public BSTMap (K key, V value){
        this.left = null;
        this.right = null;
        this.Key = key;
        this.Value = value;
    }

    /** Removes all of the mappings from this map. */
    @Override
    public void clear(){
        this.Key = null;
        this.Value = null;
        this.left = null;
        this.right = null;
    }

    /* Returns true if this map contains a mapping for the specified key. */
    @Override
    public boolean containsKey(K key){
        if (this.Key.compareTo(key) == 0){
            return true;
        } else if (this.Key.compareTo(key) == 1 && this.left != null){
            return this.left.containsKey(key);
        } else if (this.Key.compareTo(key) == -1 && this.right != null){
            return this.right.containsKey(key);
        } else{
            return false;
        }
    }

    /* Returns the value to which the specified key is mapped, or null if this
     * map contains no mapping for the key.
     */
    @Override
    public V get(K key){
        if (this.Key.compareTo(key) == 0){
            return this.Value;
        } else if (this.Key.compareTo(key) == 1 && this.left != null){
            return (V) (this.left.get(key));
        } else if (this.Key.compareTo(key) == -1 && this.right != null){
            return (V) (this.right.get(key));
        } else{
            return null;
        }
    }

    /* Returns the number of key-value mappings in this map. */
    @Override
    public int size(){
        int size = 1;
        if (is_end()){
            return 1;
        } else if (this.left != null){
            size += this.left.size();
        }
        if (this.right != null) {
            size += this.right.size();
        }
        return size;
    }

    /* Associates the specified value with the specified key in this map. */
    @Override
    public void put(K key, V value){
        if (this.Key == null){
            this.Key = key;
            this.Value = value;
        }
        if (this.Key.compareTo(key) == 1){
            if (this.left == null){
                this.left = new BSTMap(key , value);
            } else {
                this.left.put(key , value);
            }
        } else if (this.Key.compareTo(key) == -1) {
            if (this.right == null) {
                this.right = new BSTMap(key, value);
            } else {
                this.right.put(key, value);
            }
        }
    }

    /* Returns a Set view of the keys contained in this map. Not required for Lab 7.
     * If you don't implement this, throw an UnsupportedOperationException. */
    @Override
    public Set<K> keySet(){
        throw new UnsupportedOperationException("Invalid operation.");
    }

    /* Removes the mapping for the specified key from this map if present.
     * Not required for Lab 7. If you don't implement this, throw an
     * UnsupportedOperationException. */
    @Override
    public V remove(K key){
        throw new UnsupportedOperationException("Invalid operation.");
    }

    /* Removes the entry for the specified key only if it is currently mapped to
     * the specified value. Not required for Lab 7. If you don't implement this,
     * throw an UnsupportedOperationException.*/
    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("Invalid operation.");
    }

    /* return true if the map has no subtrees **/
    public boolean is_end(){
        return this.left == null && this.right == null;
    }

    /* print the tree keys in order **/
    public void printInOrder() {
        if (is_end()) {
            System.out.print(this.Key + " ");
        } else {
            if (this.left != null) {
                this.left.printInOrder();
            }
            System.out.print(this.Key + " ");
            if (this.right != null) {
                this.right.printInOrder();
            }
        }
    }


}
