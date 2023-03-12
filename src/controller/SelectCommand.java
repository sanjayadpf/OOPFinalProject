/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import model.interfaces.IShapeList;
import model.shapeUtility.BoundingBox;
import model.shapeUtility.DrawObserver;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.JPaintManager;
import model.shapeUtility.ManageObservers;

/**
 *
 * @author sanja
 */
public class SelectCommand implements ICommand {

    Point upperLeftPoint;
    Point lowerRightPoint;
    static SelectCommand selection;

    public SelectCommand(Point boundStart, Point boundEnd) {
        this.upperLeftPoint = boundStart;
        this.lowerRightPoint = boundEnd;
    }

    public static void select(Point boundStart, Point boundEnd) {
        // normal selection
        JPaintManager.getSelectedList().getList().clear();

        selection = new SelectCommand(boundStart, boundEnd);
        //Selection box logic upper left and lower right checking
        for (GenerateShape shape : ((ManageObservers) JPaintManager.getSubjectList()).getList()) {
            if (selection.upperLeftPoint.getX() < shape.startPoint.getX() && selection.lowerRightPoint.getX() > shape.endPoint.getX()
                    && selection.upperLeftPoint.getY() < shape.startPoint.getY() && selection.lowerRightPoint.getY() > shape.endPoint.getY()) {
                JPaintManager.getSelectedList().addShape(shape);
                JPaintManager.getGroupList().addShape(shape);
            }
        }
        
        for (GenerateShape shape : JPaintManager.getSelectedList().getList()) {
            BoundingBox.drawBoundingbox(shape, DrawObserver.graphics2d);
        }
    }

    @Override
    public void run() {
        select(upperLeftPoint, lowerRightPoint);
    }

    public static SelectCommand getSelection() {

        return selection;
    }

}
