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
//        String data = DataParser.getInstance().efficienceTransform(input);
        String data = SimpleFileReader.getInstance().fileToString(input);
        List<String> csv = CSVParser.getInstance().getList(data, ",");
        List<Double> values = new ArrayList<>();
        Double valorPreco = Double.parseDouble(SimpleFileReader.getInstance().fileToString(custo));
        FIS fis = FIS.load(rules.getPath(),true);
        
        if (fis == null){
            System.err.println("Eitaaa");
        }
        
        FunctionBlock fb = fis.getFunctionBlock(null);
//        for (String dado : csv) {
//            fb.setVariable("custo", valorPreco);
//            fb.setVariable("eficiencia", Integer.parseInt(dado));
//            fb.evaluate();
//            fb.getVariable("valeapena").defuzzify();
//            values.add(fb.getVariable("valeapena").getValue());
//            System.out.println(dado);
//        }
        
        double porcaoLivre  = Double.parseDouble(csv.get(3));
        double porcaoLLivre = Double.parseDouble(csv.get(2));
        double porcaoLLenta = Double.parseDouble(csv.get(1));
        double porcaoLenta  = Double.parseDouble(csv.get(0));

        //mediaponderada é igual a cada porcentagem multiplicada pelo seu valor nas regras fuzzy, depois dividido pelo total.
        double mediaPonderada = porcaoLLivre+porcaoLLenta*2+porcaoLenta*3;
        mediaPonderada = mediaPonderada/100;
        
        fb.setVariable("custo", valorPreco);
        fb.setVariable("eficiencia", mediaPonderada);
        fb.evaluate();
        fb.getVariable("valeapena").defuzzify();
//        values.add(fb.getVariable("valeapena").getValue());
//        System.out.println(mediaPonderada);

//        Double media=0.0;
//        for (Double value: values) {
//            media+=value;
//        }
//        media = media/(double)values.size
        System.out.println("media ponderada: "+mediaPonderada);
        System.out.println("valeapena: "+fb.getVariable("valeapena").getValue());
//        fb.getVariable("valeapena").setValue(media);
        if(full){
            JFuzzyChart.get().chart(fb);
        }else{
            JFuzzyChart.get().chart(fb.getVariable("valeapena"),true);
        }
        
        return fb.getVariable("valeapena").getValue();
    }
}
