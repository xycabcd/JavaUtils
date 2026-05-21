import java.util.Iterator;
import java.util.function.Supplier;
import java.util.NoSuchElementException;

// Wrapper of arrays in generics

public final class Array<T> implements Iterable<T>, Cloneable {
    protected final Object[] data;
    public Array(int length) {
        data = new Object[length];
    }
    public Array(T...d) {
        this(d.length);
        for (int i = 0; i <= d.length-1;i++) {
            data[i] = d[i];
        }
    }
    public int size() {
        return data.length;
    }
    public T get(int index) {
        return (T) data[index];
    }
    // so that multi-demension arrays can be made easily
    public T getSetDefault(int index, Supplier<T> d) {
        T original = get(index);
        if (original == null) {
            T newValue = d.get();
            set(index, newValue);
            return newValue;
        } else {
            return original;
        }
    }
    public void set(int index, T value) {
        data[index] = value;
    }
    public Object[] toObjectArray() {
        return data.clone();
    }
    public Iterator<T> iterator() {
        return new Iter();
    }
    private class Iter implements Iterator<T> {
        private int next = 0;
        
        @Override
        public boolean hasNext() {
            return next <= size()-1;
        }
        
        @Override
        public T next() {
            if (next > size()-1) throw new NoSuchElementException();
            T v = get(next);
            next++;
            return v;
        }
    }
}
