package xycabcd.util;
//An Wrapper class for arrays
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
    public String toString() {
        String result = "{";
        for(int i = 0;i <= data.length-2;i++) {
            T a = data[i];
            result = result + a.toString();
            result = result + ",";
        }
        result = result + data[data.length-2];
        result = result + "}";
        return result;
    }
}
