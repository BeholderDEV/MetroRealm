/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.metrorealm.ui.swing.webLaf;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Alisson
 */
public class ImageJPanel extends JPanel{
    Image image=null;

    public void setImage(Image image) {
        this.image = image;
    }
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
    }
}
