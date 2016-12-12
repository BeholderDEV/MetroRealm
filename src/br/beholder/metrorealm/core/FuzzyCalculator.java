/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.metrorealm.core;

import br.beholder.csvparser.CSVParser;
import br.beholder.dataparser.DataParser;
import br.beholder.filecontrol.SimpleFileReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

/**
 *
 * @author Alisson
 */
public class FuzzyCalculator {
    
    public Double calculate(File rules, File input,File custo){
        return calculate(rules, input, custo, false);
    }
    public Double calculate(File rules, File input,File custo, boolean full){
        String data = DataParser.getInstance().efficienceTransform(input);
        List<String> csv = CSVParser.getInstance().getList(data, ",");
        List<Double> values = new ArrayList<>();
        Double valorPreco = Double.parseDouble(SimpleFileReader.getInstance().fileToString(custo));
        FIS fis = FIS.load(rules.getPath(),true);
        
        if (fis == null){
            System.err.println("Eitaaa");
        }
        
        FunctionBlock fb = fis.getFunctionBlock(null);
        for (String dado : csv) {
            fb.setVariable("custo", valorPreco);
            fb.setVariable("eficiencia", Integer.parseInt(dado));
            fb.evaluate();
            fb.getVariable("valeapena").defuzzify();
            values.add(fb.getVariable("valeapena").getValue());
            System.out.println(dado);
        }
        Double media=0.0;
        for (Double value: values) {
            media+=value;
        }
        media = media/(double)values.size();
        System.out.println("media: "+media);
        fb.getVariable("valeapena").setValue(media);
        if(full){
            JFuzzyChart.get().chart(fb);
        }else{
            JFuzzyChart.get().chart(fb.getVariable("valeapena"),true);
        }
        
        return media;
    }
}
