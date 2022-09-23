package Main.src.java;

import java.util.ArrayList;
import java.util.function.ToIntFunction;

public class Main {

    public static void main(String[] args) {
        BloomFilterImpl objectBuilder = new Builder().withInitial(0).withHashFunctions(new ArrayList<ToIntFunction>(3)).build();

        for(int i=0;i<1000;i++) {
            objectBuilder.add(i);
            System.out.println(objectBuilder.bitmap);
        }
        for(int i=0;i<1000;i++)
        {
            Boolean success=objectBuilder.mightContain(i);
            System.out.println(success);
        }



    }
}
