package bearmaps;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayHeapMinPQTest {

    @Test
    public void MinHeap_test(){
        Node<String> three = new Node<> ("three", 3);
        Node<String> nine = new Node<> ("nine", 9);
        Node<String> five = new Node<> ("five", 5);
        Node<String> four = new Node<> ("four", 4);
        Node<String> two = new Node<> ("two", 2);
        Node<String> eight = new Node<> ("eight", 8);
        Node<String> six = new Node<> ("six", 6);
        Node<String> seven = new Node<> ("seven", 7);
        Node<String> one = new Node<> ("one", 1);

        MinHeap<Node<String>,String> test = new MinHeap<>(three);
        test.add(nine);
        test.add(five);
        test.add(four);
        test.add(two);
        test.add(eight);
        test.add(six);
        test.add(seven);
        test.add(one);

        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();

    }

    @Test
    public void ArrayHeapMinPQ_test(){

        ArrayHeapMinPQ<String> test = new ArrayHeapMinPQ<>();
        test.add("three", 3);
        test.add("nine", 9);
        test.add("five", 5);
        test.add("four", 4);
        test.add("two", 2);
        test.add("eight", 8);
        test.add("six", 6);
        test.add("seven", 7);
        test.add("one", 1);

        test.changePriority("four", 0.5);
        test.changePriority("four", 10);
        test.changePriority("for", 10);
        /*
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        test.removeSmallest();
        */
    }




}
