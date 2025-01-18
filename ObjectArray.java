package xycabcd.util;
public class ObjectArray<T> implements Iterable<T> {
    private final T[] data;
    public ObjectArray(int length) {
        data = (T[]) new Object[length];
    }
    public ObjectArray(T[] initial) {
        data = initial.clone();
    }
    public void set(int i, T d) {
        data[i] = d;
    }
    public T get(int i) {
        return data[i];
    }
    public java.util.Iterator<T> iterator() {
        return new ObjectArrayIterator<T>(data);
    }
}