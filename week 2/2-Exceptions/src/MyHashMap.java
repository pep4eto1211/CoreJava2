import java.util.HashMap;
import java.util.Map;

public class MyHashMap<T, E> extends HashMap<T, E> {
    private boolean allowNullKey = false;

    public MyHashMap() {
        super();
    }

    public MyHashMap(boolean allowNullKey) {
        this.allowNullKey = allowNullKey;
    }

    public MyHashMap(int initialCapacity, float loadFactor, boolean allowNullKey) {
        super(initialCapacity, loadFactor);
        this.allowNullKey = allowNullKey;
    }

    public MyHashMap(int initialCapacity, boolean allowNullKey) {
        super(initialCapacity);
        this.allowNullKey = allowNullKey;
    }

    public MyHashMap(Map<? extends T, ? extends E> m, boolean allowNullKey) {
        super(m);
        this.allowNullKey = allowNullKey;
    }

    public void allowNullKeys(){
        allowNullKey = true;
    }

    @Override
    public E put(T key, E value) {
        if (!allowNullKey){
            if (key == null){
                throw new NullKeyException();
            }
            else{
                return super.put(key, value);
            }
        }
        else {
            return super.put(key, value);
        }
    }

    @Override
    public E get(Object key) {
        if (!allowNullKey){
            if (key == null){
                throw new NullKeyException();
            }
            else{
                return super.get(key);
            }
        }
        else{
            return super.get(key);
        }
    }
}
