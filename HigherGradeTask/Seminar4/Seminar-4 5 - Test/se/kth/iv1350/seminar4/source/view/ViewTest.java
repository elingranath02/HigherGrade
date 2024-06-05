package se.kth.iv1350.seminar4.source.view;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import se.kth.iv1350.seminar4.source.controller.Controller;
import se.kth.iv1350.seminar4.source.integration.InventoryFailureException;
import se.kth.iv1350.seminar4.source.integration.ItemDTO;
import se.kth.iv1350.seminar4.source.integration.ItemNotFoundInInventoryException;
import se.kth.iv1350.seminar4.source.view.View;
import se.kth.iv1350.seminar4.source.model.NotEligibleForDiscountException;

public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;
    private Controller contr;

    @BeforeEach
    public void setUp() throws IOException{
        contr = new Controller();
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream(0);
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        
    }

    @AfterEach
    public void tearDown() {
        instanceToTest = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Before
    public void settingUp() throws IOException {
        contr = new Controller();
        instanceToTest = new View(contr);

        printoutBuffer = new ByteArrayOutputStream(0);
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut); }


    @Test
    public void testRunFakeExecution() throws InventoryFailureException, ItemNotFoundInInventoryException, NotEligibleForDiscountException{
        
        instanceToTest.runFakeExecution();
        
        String printout = printoutBuffer.toString();

        contr.startSale();

        ItemDTO itemInfo = contr.enterItemIdentifier(111);
        String s = contr.showTotalPriceAndVAT();
        ItemDTO itemInfo2 = contr.enterItemIdentifier(111);
        String s2 = contr.showTotalPriceAndVAT();
        ItemDTO itemInfo3 = contr.enterItemIdentifier(333);
        String s3 = contr.showTotalPriceAndVAT();
        double totalPrice = contr.endSale();
        totalPrice = contr.checkDiscount(19201110);
        contr.pay(totalPrice,100);


        String[] expectedOutputs = {
            "A new sale has been started.",
            "add 1 item with ID 111",
            "Item ID: " + itemInfo.getCodeOfItem(),
            "Item name: " + itemInfo.getItemName(),
            "Item cost: " + itemInfo.getPrice(),
            "VAT: " + itemInfo.getVAT(),
            "Item description: " + itemInfo.getDescription(),
            s,
            "add 1 item with ID 111",
            "Item ID: " + itemInfo2.getCodeOfItem(),
            "Item name: " + itemInfo2.getItemName(),
            "Item cost: " + itemInfo2.getPrice(),
            "VAT: " + itemInfo2.getVAT(),
            "Item description: " + itemInfo2.getDescription(),
            s2,
            "add 1 item with ID 333",
            "add 1 item with ID 111",
            "Item ID: " + itemInfo3.getCodeOfItem(),
            "Item name: " + itemInfo3.getItemName(),
            "Item cost: " + itemInfo3.getPrice(),
            "VAT: " + itemInfo3.getVAT(),
            "Item description: " + itemInfo3.getDescription(),
            s3,
            "Customer wants discount",
            "Discount has been applied",
            "End Sale:",
            "Total cost ( incl VAT ): "+ String.format("%.2f",totalPrice) + " SEK",
            "Customer pays: "+ 100 + " SEK",



            











        };

        for (String expectedOutput : expectedOutputs) {
            assertTrue(printout.contains(expectedOutput), "Expected output not found: " + expectedOutput);
        }
    }
}