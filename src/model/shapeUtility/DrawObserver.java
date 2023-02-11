/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

/**
 *
 * @author sanja
 */
import model.interfaces.IDrawShape;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeType;
import view.gui.PaintCanvas;

public class DrawObserver implements IShapeObserver {

    public PaintCanvas canvas;
    public static Graphics2D graphics2d;
    public static DrawObserver drawShape;

    public DrawObserver(PaintCanvas canvas) {
        graphics2d = canvas.getGraphics2D();
    }

    public static void drawShapeStrategy(GenerateShape shape, DrawObserver drawShape) {
        IDrawShape shapeStrategy=null;
        
        if(shape.shapeType==ShapeType.RECTANGLE){
            shapeStrategy = new RectangleStrategy();
        }else if(shape.shapeType==ShapeType.ELLIPSE){
            shapeStrategy = new EllipseStrategy();
        }else if(shape.shapeType==ShapeType.TRIANGLE){
            shapeStrategy = new TriangleStrategy();
        }
       
        shapeStrategy.draw(shape, graphics2d);

    }

    @Override
    public void update() {
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, 1200, 800);

        for (GenerateShape shape : ((ManageObservers) ListModel.getMaster()).getList()) {
            drawShapeStrategy(shape, drawShape);
        }
    }
}