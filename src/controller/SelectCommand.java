/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.ListModel;
import model.shapeUtility.ManageObservers;

/**
 *
 * @author sanja
 */
public class SelectCommand implements ICommand {

    Point upperLeftPoint;
    Point lowerRightPoint;
    public static SelectCommand selection;

    public SelectCommand(Point upperLeftPoint, Point lowerRightPoint) {
        this.upperLeftPoint = upperLeftPoint;
        this.lowerRightPoint = lowerRightPoint;
    }

    public static void selectCommand(Point upperLeft, Point lowerRight) {

        ListModel.getSelectedList().getList().clear();

        selection = new SelectCommand(upperLeft, lowerRight);
        //left upper and rightLower selection logic
        for (GenerateShape shape : ((ManageObservers) ListModel.getSubjectList()).getList()) {
            if (selection.upperLeftPoint.getX() < shape.startPoint.getX() && selection.lowerRightPoint.getX() > shape.endPoint.getX()
                    && selection.upperLeftPoint.getY() < shape.startPoint.getY() && selection.lowerRightPoint.getY() > shape.endPoint.getY()) {
                ListModel.getSelectedList().addShape(shape);
            }
        }
    }

    public static SelectCommand getSelectCommand() {
        return selection;
    }

    @Override
    public void run() {
        selectCommand(upperLeftPoint, lowerRightPoint);
    }

}
