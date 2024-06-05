package se.kth.iv1350.seminar4.source.startup;

import java.io.IOException;

import se.kth.iv1350.seminar4.source.controller.Controller;
import se.kth.iv1350.seminar4.source.task2.AdaptedRandomComposition;
import se.kth.iv1350.seminar4.source.task2.AdaptedRandomInheritance;
import se.kth.iv1350.seminar4.source.view.View;

/**
 * Starts the whole system
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
		AdaptedRandomInheritance adaptedRandomInheritance = new AdaptedRandomInheritance();
        System.out.println("AdaptedRandomInheritance: " + adaptedRandomInheritance.nextInt(100));

        AdaptedRandomComposition adaptedRandomComposition = new AdaptedRandomComposition();
        System.out.println("AdaptedRandomComposition: " + adaptedRandomComposition.nextPositiveInt(100));
		
		Controller contr = new Controller();
		View view = new View(contr);
		view.runFakeExecution();
	}
	
}

