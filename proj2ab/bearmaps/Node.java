package bearmaps;

public class Node<T> implements Comparable<Node<T>> {
    public T item;
    public double priority;

    public Node (){
        item = null;
    }

    public Node (T item, double priority){
        this.item = item;
        this.priority = priority;
    }

    @Override
    public int compareTo(Node comparator){
        if (this.priority == comparator.priority){
            return 0;
        } else if (this.priority > comparator.priority){
            return 1;
        } else {
            return -1;
        }
    }

    public T getItem (){
        return this.item;
    }

    public double getPriority (){
        return this.priority;
    }

    public void changePriority(double priority){
        this.priority = priority;
    }


}
