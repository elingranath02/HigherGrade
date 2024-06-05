package se.kth.iv1350.seminar4.source.syop;

import se.kth.iv1350.seminar4.source.task2.AdaptedRandomComposition;
import se.kth.iv1350.seminar4.source.task2.AdaptedRandomInheritance;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdaptedRandomTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    public void testAdaptedRandomInheritance() {
        AdaptedRandomInheritance adaptedRandomInheritance = new AdaptedRandomInheritance();
        System.out.println("AdaptedRandomInheritance: " + adaptedRandomInheritance.nextInt(100));

        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.matches("AdaptedRandomInheritance: \\d+"), "Output did not match the expected: " + output);
    }

    @Test
    public void testAdaptedRandomComposition() {
        AdaptedRandomComposition adaptedRandomComposition = new AdaptedRandomComposition();
        System.out.println("AdaptedRandomComposition: " + adaptedRandomComposition.nextPositiveInt(100));

        String output = outputStreamCaptor.toString().trim();
        assertTrue(output.matches("AdaptedRandomComposition: \\d+"), "Output did not match the expected: " + output);
    }
}
