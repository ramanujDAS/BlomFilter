package Main.src.java;

import java.util.List;
import java.util.function.ToIntFunction;

public class BloomFilterImpl implements IBloomFilter{

    public long bitmap=0L;


    public BloomFilterImpl(long bitmap) {
      this.bitmap=bitmap;
    }

    private int mapHash(int hash) {
        return hash & (hash - 1);
    }

    @Override
    public void add(int value) {
        bitmap = bitmap|value ;
    }

    @Override
    public boolean mightContain(int value) {

        if((bitmap&value) == bitmap)
        return true;

        return false;
    }
}
