/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.gui.PaintCanvas;

/**
 *
 * @author sanja
 */
public class ClickHandler extends MouseAdapter{
    
    public Point startPoint;
    public Point endPoint;
    public PaintCanvas paintCanvas;

    
    public ClickHandler(PaintCanvas paintCanvas) {
        this.paintCanvas=paintCanvas;
    }
    
    @Override
    
    
    public void mousePressed(MouseEvent me) {
        startPoint = new Point();
        startPoint.x=me.getX();
        startPoint.y=me.getY();
        
        paintCanvas.getGraphics().drawRect(120, 130, 200, 400);
        // compiled code
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // compiled code
        endPoint = new Point();
        startPoint.x=me.getX();
        startPoint.y=me.getY();
    }
}


