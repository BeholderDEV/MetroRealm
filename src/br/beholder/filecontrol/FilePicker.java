/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.filecontrol;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Alisson
 */
public class FilePicker {
    static String current=".";
    public static File chooseFile(){
        JFileChooser chooser = new JFileChooser(current);
        File file= new File(".");
        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            current = file.getParentFile().getPath();
        } 
        return file;
    }
}
