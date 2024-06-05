package se.kth.iv1350.seminar4.source.task2;
import java.util.Random;

public class AdaptedRandomComposition {
    private Random random;

    public AdaptedRandomComposition() {
        this.random = new Random();
    }

    public int nextPositiveInt(int bound) {
        return this.random.nextInt(bound)*2;
    }
}