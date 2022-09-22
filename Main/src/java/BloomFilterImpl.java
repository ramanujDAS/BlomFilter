package Main.src.java;

import java.util.List;
import java.util.function.ToIntFunction;

public class BloomFilterImpl<T> implements IBloomFilter{

    private final long[] array;
    private final int size;
    private final List<ToIntFunction<T>> hashFunctions;

    public BloomFilterImpl(long[] array, int logicalSize, List<ToIntFunction<T>> hashFunctions) {
        this.array = array;
        this.size = logicalSize;
        this.hashFunctions = hashFunctions;
    }

    private int mapHash(int hash) {
        return hash & (size - 1);
    }

    @Override
    public void add(Object value) {
        for(ToIntFunction<T> function : hashFunctions)
        {
            int hash = mapHash(function.applyAsInt((T)value));
            array[hash >>> 6] |= 1L << hash;
        }
    }

    @Override
    public boolean mightContain(Object value) {
        for(ToIntFunction<T> function : hashFunctions)
        {
            int hash=mapHash(function.applyAsInt((T)value));
            if ((array[hash >>> 6] & (1L << hash)) == 0) {
                return false;
            }
        }
        return true;
    }
}
