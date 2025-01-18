package xycabcd.util;
public class ObjectArrayIterator<T> implements java.util.Iterator<T> {
    private final T[] data;
    private int index;
    private final int last;
    
    public ObjectArrayIterator(T[] d) {
        if(d == null) throw new NullPointerException();
        data = d.clone();
        index = 0;
        last = d.length-1;
    }
    public ObjectArrayIterator(T[] d, int firstIndex) {
        if(d == null) throw new NullPointerException();
        if(firstIndex < 0) throw new IllegalArgumentException();
        if(firstIndex > d.length-1) throw new IllegalArgumentException();
        data = d.clone();
        index = firstIndex;
        last = d.length-1;
    }
    public ObjectArrayIterator(T[] d, int firstIndex, int lastIndex) {
        if(d == null) throw new NullPointerException();
        if(firstIndex < 0) throw new IllegalArgumentException();
        if(firstIndex > d.length-1) throw new IllegalArgumentException();
        if(lastIndex < firstIndex) throw new IllegalArgumentException();
        if(lastIndex > d.length-1) throw new IllegalArgumentException();
        data = d.clone();
        index = firstIndex;
        last = lastIndex;
    }
    @Override
    public T next() {
        if(!hasNext()) throw new java.util.NoSuchElementException();
        index++;
        return data[index-1];
       
    }
    @Override
    public boolean hasNext() {
        if(index > last) return false;
        return true;
    }
}