/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import model.ShapeType;
import model.interfaces.IDrawShape;
import static model.shapeUtility.DrawObserver.graphics2d;

/**
 *
 * @author sanja
 */
public class StrategySelection {
     public static void drawShapeStrategy(GenerateShape shape, DrawObserver drawShape) {
        IDrawShape shapeStrategy=null;
        
        if(shape.shapeType==ShapeType.RECTANGLE){
            shapeStrategy = new RectangleStrategy();
        }else if(shape.shapeType==ShapeType.ELLIPSE){
            shapeStrategy = new EllipseStrategy();
        }else if(shape.shapeType==ShapeType.TRIANGLE){
            shapeStrategy = new TriangleStrategy();
        }else if (shape.shapeType==ShapeType.CIRCLE){
            shapeStrategy=new CircleStrategy();
        }else if (shape.shapeType==ShapeType.LINE){
            shapeStrategy=new LineStrategy();
        }else if (shape.shapeType==ShapeType.ARC){
            shapeStrategy=new ArcStrategy();
        }
        
        
        if(shapeStrategy==null){ //Null object checker
            shapeStrategy=new NullStrategy();
        }
       
        shapeStrategy.draw(shape, graphics2d);

    }
}
