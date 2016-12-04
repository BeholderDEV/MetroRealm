/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder;

import br.beholder.metrorealm.ui.MainWindow;
import br.beholder.metrorealm.ui.swing.webLaf.WeblafUtils;
import com.alee.laf.WebLookAndFeel;
import javax.swing.plaf.basic.BasicFileChooserUI;

/**
 *
 * @author Alisson
 */
public class Launcher {
    public static MainWindow mainWindow;
    public static void main(String[] args) {
        try {
            final WebLookAndFeel webLookAndFeel = new WebLookAndFeel();
            //Field defaultsTable = WebLookAndFeel.class.getField("table");
            //webLookAndFeel.getDefaults().remove("FileChooserUI");
            webLookAndFeel.getDefaults().put("FileChooserUI", BasicFileChooserUI.class);
            javax.swing.UIManager.setLookAndFeel(webLookAndFeel);
        } catch (Exception ex) {
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }
}
