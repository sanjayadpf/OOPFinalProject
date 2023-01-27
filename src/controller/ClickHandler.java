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
        startPoint = new Point();
        startPoint.x=me.getX();
        startPoint.y=me.getY();
        
        
        // compiled code
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // compiled code
        endPoint = new Point();
        endPoint.x=me.getX();
        endPoint.y=me.getY();
        
        int strX = Math.min(startPoint.x, endPoint.x);
	int strY = Math.min(startPoint.y, endPoint.y);
	int width = Math.abs(startPoint.x - endPoint.x);
	int height = Math.abs(startPoint.y - endPoint.y);
        
        new GenerateShape(strX,strY,width,height,paintCanvas).run();//for test
        
        //paintCanvas.getGraphics().drawRect(strX, strY, width, height);
    }
}


