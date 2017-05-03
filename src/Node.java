/**
 * Created by yf_zh on 5/1/2017.
 */
public class Node<K,V> implements Cloneable {
    private K str;
    private V value;

    public K getStr() {
        return str;
    }

    public V getValue() {
        return value;
    }

    public Node(K str, V value) {
        this.str = str;
        this.value = value;
    }

    @Override
    public Node clone() {
        try {
            Node copy = (Node) super.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Unable to clone this note: ");
        }
    }

}
