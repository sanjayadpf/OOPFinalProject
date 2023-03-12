/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import java.util.ArrayList;
import java.util.List;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.JPaintManager;

/**
 *
 * @author sanja
 */
public class MoveCommand implements ICommand, IUndoable {

    private Point targetPoint;

    static GenerateShape currentShape;
    static GenerateShape previousShape;

    static List<GenerateShape> currentShapeList = new ArrayList<GenerateShape>();
    static List<GenerateShape> previousShapeList = new ArrayList<GenerateShape>();

    public MoveCommand(Point targetPoint) {
        this.targetPoint = targetPoint;
    }

    public static void move(Point targetPoint) {

        MoveCommand move = new MoveCommand(targetPoint);

        for (GenerateShape shape : (JPaintManager.getSelectedList().getList())) {
            previousShape = shape;

            SelectCommand selection = SelectCommand.getSelection();
            Point selectionStart = selection.upperLeftPoint;

            JPaintManager.getSubjectList().removeShape(previousShape);
            previousShapeList.add(previousShape);

            int xLength = Math.abs(selectionStart.getX() - shape.startPoint.getX());
            int yLength = Math.abs(selectionStart.getY() - shape.endPoint.getY());

            int x1 = move.targetPoint.getX() + xLength;
            int x2 = move.targetPoint.getX() + xLength + shape.width;
            int y1 = move.targetPoint.getY() + yLength;
            int y2 = move.targetPoint.getY() + yLength + shape.height;

            Point startPoint = new Point(x1, y1);
            Point endPoint = new Point(x2, y2);

            int minX = Math.min(x1, x2);
            int minY = Math.min(y1, y2);
            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

           
            
            currentShape = new GenerateShape(minX, minY, startPoint, endPoint, height, width, shape.shapeType,shape.primaryColor,shape.secondaryColor,shape.shadingType);
            
             //check for Arc and RoundRectangle
            if(previousShape.isArc){
                currentShape.startAngle=previousShape.startAngle;
                currentShape.endAngle=previousShape.endAngle;
                currentShape.isArc=true;
            }
            if(previousShape.isRoundRec){
                currentShape.arcWidth=previousShape.arcWidth;
                currentShape.arcHeight=previousShape.arcHeight;
                currentShape.isRoundRec=true;
            }
            
            
            JPaintManager.getSubjectList().addShape(currentShape);
            currentShapeList.add(currentShape);
        }
    }

    @Override
    public void run() {

        move(targetPoint);
        CommandHistory.add(this);
        JPaintManager.getSelectedList().getList().clear();

    }

    @Override
    public void undo() {

        for (GenerateShape shape : currentShapeList) {
            currentShape = shape;
            JPaintManager.getSubjectList().removeShape(currentShape);
        }
        for (GenerateShape shape : previousShapeList) {
            previousShape = shape;
            JPaintManager.getSubjectList().addShape(previousShape);
        }
    }

    @Override
    public void redo() {

        for (GenerateShape shape : currentShapeList) {
            currentShape = shape;
            JPaintManager.getSubjectList().addShape(currentShape);
        }
        for (GenerateShape shape : previousShapeList) {
            previousShape = shape;
            JPaintManager.getSubjectList().removeShape(previousShape);
        }
    }

}
