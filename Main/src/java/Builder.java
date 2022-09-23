package Main.src.java;

import java.util.List;
import java.util.function.ToIntFunction;

//hashBuilder
public class Builder {
    private long intial;
    List<ToIntFunction> hashFunction;

    public Builder withInitial(long intial)
    {
        assert Long.bitCount(intial)==1;
        this.intial=intial;
        return this;
    }
    public Builder withHashFunctions(List<ToIntFunction> hash)
    {
        this.hashFunction = hash;
        return this;

    }

    public BloomFilterImpl build() {

        return new BloomFilterImpl(intial);
    }





}
