public class LinkedLisDeque<T> implements Deque<T> {
    public int size = 0;
    public node<T> sentinel = new node<>();

    public LinkedLisDeque (){
        sentinel.before = sentinel;
        sentinel.after = sentinel;
        sentinel.content = null;
    }

    @Override
    public void addFirst(T item){
        node <T> First = new node<> (this.sentinel, item, null);
        node <T> helper = this.sentinel.after;
        this.sentinel.after = First;
        First.after = helper;
        helper.before = First;
        size += 1;
    }

    @Override
    public void addLast(T item){
        node <T> Last= new node<> (null, item, this.sentinel);
        node <T> helper = this.sentinel.before;
        this.sentinel.before = Last;
        Last.before = helper;
        helper.after = Last;
        size += 1;
    }

    /* implement isEmpty in subclass Deque
    @Override
    public boolean isEmpty(){
        return this.sentinel.after == sentinel;
    }
     **/

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque(){
        node<T> index = this.sentinel.after;
        while (index.after != this.sentinel){
            System.out.print(index.content);
            index = index.after;
        }
        System.out.println(index.content);

    }

    @Override
    public T removeFirst(){
        T willlost = this.sentinel.after.content;
        if (this.size != 0) {
            this.sentinel.after.after.before = this.sentinel;
            this.sentinel.after = this.sentinel.after.after;
            size -= 1;
        }
        return willlost;
    }

    @Override
    public T removeLast(){
        T willlost = this.sentinel.before.content;
        if (this.size != 0) {
            this.sentinel.before.before.after = this.sentinel;
            this.sentinel.before = this.sentinel.before.before;
            size -= 1;
        }
        return willlost;
    }

    @Override
    public T get(int index){
        int i = 0;
        node<T> pointer = this.sentinel.after;
        T target = pointer.content;
        while (i < index && target != null ){
            pointer = pointer.after;
            i += 1;
            target = pointer.content;
        }
        return target;
    }
/**
    public T getRecursive(int index){
        if (index == 0){
            return this.sentinel.after.content;
        }
        return

    }
**/
}
