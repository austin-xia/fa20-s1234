public class ArrayDeque<T> {
    private T[] array;
    private int size;

    public ArrayDeque(){
        array = (T[]) new Object[8];
        size = 0;
    }

    public void check_resize (){
        if (size == array.length) {
            T[] helper = (T[]) new Object[this.size * 2];
            System.arraycopy(this.array, 0, helper, 0, size);
            array = helper;
        }
    }

    public void addFirst(T item){
        this.check_resize();
        T[] helper = (T[]) new Object[array.length];
        helper[0] = item;
        System.arraycopy(this.array, 0, helper, 1, size);
        array = helper;
        size += 1;
    }

    public void addLast(T item){
        this.check_resize();
        array [size] = item;
        size += 1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int i = 0;
        while (i < size - 1){
            System.out.print(array[i]);
            i += 1;
        }
        System.out.println(array[size - 1]);
    }

    public T removeFirst(){
        size -= 1;
        T back = this.array[0];
        T[] helper = (T[]) new Object[array.length];
        System.arraycopy(this.array, 1, helper, 0, size);
        array = helper;
        return back;
    }

    public T removeLast(){
        size -= 1;
        return array [size];
    }

    public T get(int index){
        if (index < size) {
            return array[index];
        }
        return null;
    }


}
