package model.shapeUtility;

import java.awt.Color;

import controller.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import controller.Point;
import model.ShapeShadingType;
import model.ShapeType;

public class GenerateShape implements ICommand, IUndoable {

    public GenerateShape shape;
    public int x;
    public int y;
    public Point startPoint;
    public Point endPoint;
    public int height;
    public int width;
    public ShapeType shapeType;
    public Color primaryColor;
    public Color secondaryColor;
    public ShapeShadingType shadingType;
    
    //for arc included flag
    public int startAngle;
    public int endAngle;
    public boolean isArc=false;
    
    //for Round Rectangle
    public int arcWidth;
    public int arcHeight;
    public boolean isRoundRec=false;
    
    //for Text
    public String text;
    public boolean isText=false;

    public GenerateShape(int x, int y, Point startPoint, Point endPoint,
            int height, int width, ShapeType shapeType, Color primaryColor, Color secondaryColor, ShapeShadingType shadingType) {
        this.x = x;
        this.y = y;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.height = height;
        this.width = width;
        this.shapeType = shapeType;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
    }
    
    //overide for Arc


    @Override
    public void run() {
        shape = new GenerateShape(x, y, startPoint, endPoint, height, width, shapeType, primaryColor, secondaryColor, shadingType);
        JPaintManager.getSubjectList().addShape(shape);
        CommandHistory.add(this);
    }

    @Override
    public void undo() {
        JPaintManager.getSubjectList().removeShape(shape);
    }

    @Override
    public void redo() {
        JPaintManager.getSubjectList().addShape(shape);
    }
    
    //arc check

   
    
}
