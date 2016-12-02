/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.metrorealm.core;

import java.io.File;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author Alisson
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("src/br/beholder/metrorealm/resources/tipper.flc");
        System.out.println(file.getAbsolutePath());
        FIS fis = FIS.load(file.getPath(),true);
        
        if (fis == null){
            System.err.println("Eitaaa");
        }
        
        JFuzzyChart.get().chart(fis);
//
//        // Set inputs
//        fis.setVariable("service", 3);
//        fis.setVariable("food", 7);
//
//        // Evaluate
//        fis.evaluate();
//
//        // Show output variable's chart
//        Variable tip = functionBlock.getVariable("tip");
//        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);
    }
    
}
