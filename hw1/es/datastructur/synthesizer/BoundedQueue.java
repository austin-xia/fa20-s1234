package es.datastructur.synthesizer;

public interface BoundedQueue<T> extends Iterable<T>{
    int capacity();
    int fillcount();
    void enqueue (T X);
    T dequeue();
    T peek();
    default boolean isEmpty(){
        return this.fillcount() == 0;
    }
    default boolean isFull(){
        return this.fillcount() == this.capacity();
    }
}
