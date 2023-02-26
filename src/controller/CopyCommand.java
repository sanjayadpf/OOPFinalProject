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

        ListModel.getClipBoard().getList().clear();

        for (GenerateShape shape : ListModel.getSelectedList().getList()) {

            
            Point newStartPoint = new Point(shape.startPoint.getX() + 100,shape.endPoint.getY() + 100);

            Point newEndPair = new Point(shape.endPoint.getX() + 100, shape.endPoint.getY() + 100);

            int newHeight = shape.height;
            int newWidth = shape.width;

            int newX = Math.min(shape.startPoint.getX() + 100, shape.endPoint.getX() + 100);
            int newY = Math.min(shape.endPoint.getY() + 100, shape.endPoint.getY() + 100);

           
        }
    }

}
