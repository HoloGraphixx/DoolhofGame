/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maze.game;

import javax.swing.ImageIcon;

/**
 *
 * @author Thomas
 */
public class ItemObject {
   
    public int x = 0;
    public int y = 0;
    
    private String image = "";
    private ImageIcon imageIcon;
    
    public ImageIcon getImageIcon() {
        return new ImageIcon(this.image);
    }
    
    public void setImage(String url) {
       this.image = "/com/maze/images/" + url;
    }  
}
