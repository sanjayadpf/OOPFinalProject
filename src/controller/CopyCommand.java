/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import controller.interfaces.ICommand;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.JPaintManager;

/**
 *
 * @author sanja
 */
public class CopyCommand implements ICommand {

    @Override
    public void run() {

        JPaintManager.getClipBoardList().getList().clear();

        for (GenerateShape shape : JPaintManager.getSelectedList().getList()) {
            //shifted down 100 & 100
            Point newStartPoint = new Point(shape.startPoint.getX() + 100,shape.endPoint.getY() + 100);
            Point newEndPoint = new Point(shape.endPoint.getX() + 100, shape.endPoint.getY() + 100);

            int newHeight = shape.height;
            int newWidth = shape.width;

            int newX = Math.min(shape.startPoint.getX() + 100, shape.endPoint.getX() + 100);
            int newY = Math.min(shape.endPoint.getY() + 100, shape.endPoint.getY() + 100);
           
            GenerateShape copy = new GenerateShape(newX, newY, newStartPoint, newEndPoint,newHeight, newWidth,shape.shapeType,shape.primaryColor,shape.secondaryColor,shape.shadingType);
			
               //check for Arc and RoundRectangle
            if(shape.isArc){
                copy.startAngle=shape.startAngle;
                copy.endAngle=shape.endAngle;
                copy.isArc=true;
            }
            if(shape.isRoundRec){
                copy.arcWidth=shape.arcWidth;
                copy.arcHeight=shape.arcHeight;
                copy.isRoundRec=true;
            }
            if(shape.isText){
                copy.text=shape.text;
                copy.isText=true;
            }
            
            JPaintManager.getClipBoardList().addShape(copy);
            
        }
    }

}
