/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.ListModel;

/**
 *
 * @author sanja
 */
public class CopyCommand implements ICommand {

    @Override
    public void run() {

        ListModel.getClipBoard().grabList().clear();

        for (GenerateShape shape : ListModel.getSelected().getList()) {

            int newStartX = shape.startPoint.getX() + 100;
            int newStartY = shape.endPoint.getY() + 100;
            Point newStartPoint = new Point(newStartX, newStartY);

            int newEndX = shape.endPoint.getX() + 100;
            int newEndY = shape.endPoint.getY() + 100;
            Point newEndPair = new Point(newEndX, newEndY);

            int newHeight = shape.height;
            int newWidth = shape.width;

            int newX = Math.min(newStartX, newEndX);
            int newY = Math.min(newStartY, newEndY);

           
        }
    }

}
