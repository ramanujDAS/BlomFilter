package Main.src.java;

import java.util.List;
import java.util.function.ToIntFunction;

//hashBuilder
public class Builder<T> {
    private Integer size;
    private List<ToIntFunction<T>> hashFunction;

    public Builder<T> withSize(Integer size)
    {
        assert Integer.bitCount(size)==1;
        this.size=size;
        return this;
    }
    public Builder<T> withHashFunctions(List<ToIntFunction<T>> hash)
    {
        this.hashFunction = hash;
        return this;

    }

    public BloomFilterImpl<T> build() {
        return new BloomFilterImpl<T>(new long[size >>> 6], size, hashFunction);
    }





}
