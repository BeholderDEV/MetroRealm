/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.beholder.metrorealm.ui.utils;

import java.awt.Color;

/**
 *
 * @author LITE
 */
public final class ColorController {
    static int alpha = 240;
    private static Color[] getDefaultTheme(){
        return new Color[]{
                new Color(51,51,51),
                new Color(243,243,243),
                new Color(255,255,255),
                new Color(49,104,146),
                new Color(210,231,252),
                new Color(228,241,254),
                new Color(255,194,0)
            };
    }
    private static Color[] getDarkTheme(){
        return new Color[]{
                new Color(251,251,251),
                new Color(100,100,100),
                new Color(51,51,51),
                new Color(30,30,30),
                new Color(80,80,80),
                new Color(90,90,90),
                new Color(255,194,0)
            };
    }
    private static Color[] getASHTheme(){
        return new Color[]{
                new Color(251,251,251, alpha),
                new Color(58,70,76, alpha),
                new Color(38,50,56, alpha),
                new Color(18,30,36, alpha),
                new Color(38,50,56, alpha),
                new Color(68,80,86, alpha),
                new Color(241,67,60, alpha),
            };
    }
    private static Color[] getFlatTheme(){
        return new Color[]{
                new Color(251,251,251, alpha),
                
                new Color(107,128,255, alpha), 
                
                               
                new Color(114,232,194, alpha),
                new Color(232,116,92, alpha),
                
                
                new Color(255,215,109, alpha),
                new Color(241,67,60, alpha)
            };
    }
    
    private static final Color[] THEME= getASHTheme();
    public static final Color COR_LETRA = THEME[0];
    public static final Color COR_DESTAQUE = THEME[1];
    public static final Color COR_PRINCIPAL = THEME[2];
    public static final Color FUNDO_ESCURO = THEME[3];
    public static final Color FUNDO_MEDIO = THEME[4];
    public static final Color FUNDO_CLARO = THEME[5];
    public static final Color PROGRESS_BAR = THEME[6];
}
