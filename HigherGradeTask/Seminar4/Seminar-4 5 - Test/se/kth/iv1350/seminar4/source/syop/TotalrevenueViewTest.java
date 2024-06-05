package se.kth.iv1350.seminar4.source.syop;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.kth.iv1350.seminar4.source.view.TotalRevenueView;


    public class TotalrevenueViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream(); //the output is what is originally sent to syop as a bytearrayoutputstream
    private final PrintStream originalOut = System.out; // final so it doesnt change the original code 

    @Before
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    public void settingUp() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void tearDown () {
        System.setOut(originalOut);
    }

    @AfterEach
    public void tearingDown () {
        System.setOut(originalOut);
    }

    @Test
    public void testUpdtadeTotalrevenue () {
        TotalRevenueView totalRevenueView = new TotalRevenueView();
        double newrevenue = 1234.50;
        totalRevenueView.updateTotalRevenue(newrevenue);
        String excpectedoOutput = "Total Revenue: 1234,50";
        assertEquals(excpectedoOutput, output.toString().trim()); //checking to see if the thing I wrote in the output is same as the excpected in our method
    }
}
    
