/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.dataparser;

import br.beholder.csvparser.CSVParser;
import br.beholder.filecontrol.SimpleFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    private String efficienceTransform(File f){
        return efficienceTransform(SimpleFileReader.getInstance().fileToString(f));
    }
    private String efficienceTransform(String f){
        f = f.replace("levementelento", "1,");
        f = f.replace("lento", "2,");
        f = f.replace("livre", "0,");
        f = f.replace("parado", "3,");
        return f;
    }
}
