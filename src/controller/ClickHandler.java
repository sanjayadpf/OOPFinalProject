/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.GenerateShape;
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
        startPoint = new Point(me.getX(),me.getY());
        // compiled code
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // compiled code
        endPoint =  new Point(me.getX(),me.getY());
        
        int strX = Math.min(startPoint.getX(), endPoint.getX());
	int strY = Math.min(startPoint.getY(), endPoint.getY());
	int width = Math.abs(startPoint.getX() - endPoint.getX());
	int height = Math.abs(startPoint.getY() - endPoint.getY());
        
        new GenerateShape(strX,strY,width,height,paintCanvas).run();//for test
        
        //paintCanvas.getGraphics().drawRect(strX, strY, width, height);
    }
}


