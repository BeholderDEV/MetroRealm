/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplication;

import java.io.File;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author Alisson
 */
public class Aplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File file = new File("src/aplication/tipper.flc");
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
