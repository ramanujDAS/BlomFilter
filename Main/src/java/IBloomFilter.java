package Main.src.java;

interface IBloomFilter<T> {

    public void add(int value) ;


   public boolean mightContain(int value);

}
