/* node class that will contain the key/value
and to be stored into the arraylist
 */

public class Node<K,V> {
    public K Key;
    public V Value;
    public Node next;

    public Node(K Key, V Value){
        this.Key = Key;
        this.Value = Value;
        next = null;
    }

    public K getKey(){
        return this.Key;
    }

    public V getValue(){
        return this.Value;
    }

    public void add (K Key, V Value){
        if (this.next == null){
            Node<K,V> next_node = new Node<>(Key, Value);
            this.next = next_node;
        } else {
            this.next.add(Key,Value);
        }

    }

    /* this function will return null if there is no key contained
    ,or it will return the value of the key if this key is contained
     */
    public V contains(K Key){
        if (this.Key == Key){
            return this.Value;
        } else if (this.next != null) {
            return (V)this.next.contains(Key);
        }
        return null;
    }

    public void overwrite(K Key, V Value){
        if (this.Key == Key){
            this.Value = Value;
        } else if (this.next != null) {
            this.next.overwrite(Key, Value);
        }
    }

    public boolean hasNext (Node Pos){
        return Pos.next != null;
    }



}
