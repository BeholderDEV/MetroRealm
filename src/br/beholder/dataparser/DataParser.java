/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.dataparser;

import br.beholder.csvparser.CSVParser;
import br.beholder.filecontrol.SimpleFileReader;
import java.io.File;
import java.util.List;

/**
 *
 * @author Alisson
 */
public class DataParser {
    private static DataParser dataParser;

    private DataParser() {
    }
    
    public static DataParser getInstance(){
        if(dataParser == null){
            dataParser = new DataParser();
        }
        return dataParser;
    }
    
    public static void main(String[] args) {
        
    }
    
    public String efficienceTransform(File f){
        return efficienceTransform(SimpleFileReader.getInstance().fileToString(f));
    }
    public String efficienceTransform(String f){
        f = f.replace("levemente lento", "1");
        f = f.replace("lento", "2");
        f = f.replace("livre", "0");
        f = f.replace("parado", "3");
        return f;
    }
}
