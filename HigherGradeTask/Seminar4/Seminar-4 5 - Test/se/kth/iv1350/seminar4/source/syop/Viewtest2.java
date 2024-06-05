package se.kth.iv1350.seminar4.source.syop;

import se.kth.iv1350.seminar4.source.controller.Controller;
import se.kth.iv1350.seminar4.source.view.View;
import se.kth.iv1350.seminar4.source.model.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Viewtest2 {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private View view;
    private Controller contr;
    private Sale sale;

    @BeforeEach
    public void setUp() throws IOException {
        System.setOut(new PrintStream(output));
        this.contr = new Controller();
        this.view = new View(contr);
        contr.startSale();
    }

    @Before
    public void settingUp() throws IOException {
        System.setOut(new PrintStream(output));
        this.contr = new Controller();
        this.view = new View(contr);
        contr.startSale();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
        contr = null;
        view = null;
    }

    @Test
    public void testRunFakeExecution() {
        view.runFakeExecution();

        String expectedOutput = "A new sale has been started.\n" +
                                "add 1 item with ID 111\n" +
                                "Item ID: 111\n" +
                                "Item name: Big Wheel Oatmeal\n" +
                                "Item cost: 29.0 SEK \n" +
                                "VAT: 6.0 %\n" +
                                "Item description: BigWheel Oatmeal 500 g, whole grain oats,\n" +
                                "high fiber, gluten free\n" +
                                "\n" +
                                "Total cost (incl VAT):29,00 SEK\n" +
                                "Total VAT:1,64 SEK\n" +
                                "\n" +
                                "add 1 item with ID 111\n" +
                                "Item ID: 111\n" +
                                "Item name: Big Wheel Oatmeal\n" +
                                "Item cost: 29.0 SEK \n" +
                                "VAT: 6.0 %\n" +
                                "Item description: BigWheel Oatmeal 500 g, whole grain oats,\n" +
                                "high fiber, gluten free\n" +
                                "\n" +
                                "Total cost (incl VAT):58,00 SEK\n" +
                                "Total VAT:3,28 SEK\n" +
                                "\n" +
                                "add 1 item with ID 333\n" +
                                "Item ID: 333\n" +
                                "Item name: YouGoGo Blueberry\n" +
                                "Item cost: 14.0 SEK \n" +
                                "VAT: 5.0 %\n" +
                                "Item description: YouGoGo Blueberry 240 g, low sugar youghurt,\n" +
                                "blueberry flavour\n" +
                                "\n" +
                                "Total cost (incl VAT):72,00 SEK\n" +
                                "Total VAT:3,95 SEK\n" +
                                "\n" +
                                "Customer wants discount\n" +
                                "Discount has been applied\n" +
                                "End Sale: \n" +
                                "Total cost ( incl VAT ): 65,16 SEK\n" +
                                "Customer pays: 100 SEK\n" +
                                "Total Revenue: 65,16\n" +
                                "Time of sale:" + sale.getTimeOfSale() + "\n" +
                                "------------- Begin receipt ---------------\n" +
                                "\n" +
                                "Big Wheel Oatmeal 2 x 29,00 SEK: 58,00 SEK\n" +
                                "\n" +
                                "YouGoGo Blueberry 1 x 14,00 SEK: 14,00 SEK\n" +
                                "\n" +
                                "\n" +
                                "Total : 72,00 SEK\n" +
                                "VAT : 3,95 SEK\n" +
                                "\n" +
                                "------------- End receipt ---------------\n" +
                                "Amount in Register:165,16\n" +
                                "Updated accountingSystem\n" +
                                "Told external inventory system to decrease inventory quantity\n" +
                                "Change to give the customer:34,84 SEK\n";

        assertTrue(output.toString().trim().contains(expectedOutput.trim()), "Unexpected output");
    }
}
