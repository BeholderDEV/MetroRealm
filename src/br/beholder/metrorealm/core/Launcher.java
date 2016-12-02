/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.metrorealm.core;

import br.beholder.csvparser.CSVParser;
import br.beholder.dataparser.DataParser;
import static br.beholder.dataparser.DataParser.getInstance;
import java.io.File;
import java.util.List;
import java.util.Stack;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.RuleBlock;

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
        File input = new File("src/br/beholder/resources/teste.txt");
        String data = DataParser.getInstance().efficienceTransform(input);
        List<String> csv = CSVParser.getInstance().getList(data, ",");
        
        FIS fis = FIS.load(file.getPath(),true);
        
        if (fis == null){
            System.err.println("Eitaaa");
        }
        
        FunctionBlock fb = fis.getFunctionBlock(null);
        for (String dado : csv) {
            fb.setVariable("custo", 7.66);
            fb.setVariable("eficiencia", Integer.parseInt(dado));
            fb.evaluate();
            JFuzzyChart.get().chart(fis);
        }
                
        JFuzzyChart.get().chart(fis);
        
    }
    
}
