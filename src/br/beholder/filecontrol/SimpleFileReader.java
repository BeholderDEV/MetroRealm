/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.filecontrol;

import br.beholder.csvparser.CSVParser;
import java.io.BufferedReader;
import java.io.File;
import static java.io.File.separator;
import java.io.FileReader;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alisson
 */
public class SimpleFileReader {
    private static SimpleFileReader fileReader;

    private SimpleFileReader() {
    }
    
    public static SimpleFileReader getInstance(){
        if(fileReader == null){
            fileReader=new SimpleFileReader();
        }
        return fileReader;
    }
    
    public String fileToString(File f){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
}
