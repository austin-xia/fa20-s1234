public class node <T> {
    public node<T> before;
    public node<T> after;
    public T content;

    public node (node<T> before, T content, node<T> after){
        this.before = before;
        this.content = content;
        this.after = after;
    }

    public node (){
        this.before = null;
        this.content = null;
        this.after = null;
    }
}
