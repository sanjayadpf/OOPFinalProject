/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CommandHistory;
import controller.ICommand;
import controller.IUndoable;
import java.awt.Graphics;
import view.gui.PaintCanvas;

/**
 *
 * @author sanja
 */
public class GenerateShape implements ICommand,IUndoable{
    
    int strX;
    int strY;
    int width;
    int height;
    
    PaintCanvas paintCanvas;
    Graphics graphics;
    

    public GenerateShape() {
        
        
    }

    public GenerateShape(int strX, int strY, int width, int height, PaintCanvas paintCanvas) {
        this.strX = strX;
        this.strY = strY;
        this.width = width;
        this.height = height;
        this.paintCanvas = paintCanvas;
    }

    public void drawShape(){
        this.paintCanvas.getGraphics2D().drawRect(strX, strY, width, height);
        
       
    }
    public PaintCanvas getCanvas(){
        return paintCanvas;
    }
    
    public Graphics getGraphics(){
        return graphics;
    }

    public int getStrX() {
        return strX;
    }

    public int getStrY() {
        return strY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PaintCanvas getPaintCanvas() {
        return paintCanvas;
    }
    
    
    @Override
    public void run() {
        graphics=paintCanvas.getGraphics();
        CommandHistory.add(this);
        drawShape();
        //for test
        System.out.println("generate shape run method");
    }

    @Override
    public void undo() {

        System.out.println("undo");
        
    }

    @Override
    public void redo() {
       
        System.out.println("redo");
    }
    
}
