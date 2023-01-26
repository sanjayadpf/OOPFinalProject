/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author sanja
 */
public class ClickHandler extends MouseAdapter{
    
    Point startPoint;
    @Override
    public void mousePressed(MouseEvent me) {
        startPoint = new Point();
        startPoint.x=me.getX();
        startPoint.y=me.getY();
        
        // compiled code
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // compiled code
    }
}


class Point{
    public int x;
    public int y;


}