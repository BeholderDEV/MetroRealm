/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.csvparser;

import br.beholder.filecontrol.SimpleFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 */
public class CSVParser {
    private static CSVParser csvp;
    

    private CSVParser() {
    }
    
    public static CSVParser getInstance(){
        if(csvp ==null){
            csvp = new  CSVParser();
        }
        return csvp;
    }
    
    private List<String> getList(String f, String separator){
        List<String> list = new ArrayList<>();
        f = f.replaceAll("\n", separator);
        String[] everything = f.split(separator);
        for (String string : everything) {
            list.add(string);
        }
        
        return list;
    }
    private List<String> getList(File f, String separator){
        return getList(SimpleFileReader.getInstance().fileToString(f), separator);
    }
}
