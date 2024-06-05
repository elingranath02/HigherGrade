package se.kth.iv1350.seminar4.source.task2;

import java.util.Random;

public class AdaptedRandomInheritance extends Random {
    
    @Override
    public int nextInt(int bound) {
        return super.nextInt(bound)*2;
    }
}
