package Main.src.java;

interface IBloomFilter<T> {

    public void add(T value) ;


   public boolean mightContain(T value);

}
