/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsp.arq.ads.poo.interfaceGrafica;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JDesktopPane;

/**
 *
 * @author Bruno Siqueira
 */
public class BackGround extends JDesktopPane {

    private Image img;

   private static final long serialVersionUID = 1L;  
   Image imagem;  
   public BackGround(String caminho) {  
      imagem = Toolkit.getDefaultToolkit().getImage(getClass().getResource(caminho));
   }
   
    @Override
   public void paintComponent(Graphics g) {  
      super.paintComponent(g);  
      if(imagem != null)   {  
         g.drawImage(imagem, 0, 0, this.getWidth(), this.getHeight(), this);   
      }  
   }  
}
