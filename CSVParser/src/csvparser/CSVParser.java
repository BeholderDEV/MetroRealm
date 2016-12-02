/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csvparser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    
    private List<String> getList(File f, String separator){
        List<String> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String[] everything = sb.toString().split(separator);
            for (String string : everything) {
                list.add(string);
            }
        } catch (Exception ex) {
            Logger.getLogger(CSVParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
