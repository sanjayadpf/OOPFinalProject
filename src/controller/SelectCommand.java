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
	static SelectCommand selection;	
	
	public SelectCommand(Point boundStart, Point boundEnd) {
		this.upperLeftPoint = boundStart;
		this.lowerRightPoint = boundEnd;
	}
	
	public static void select(Point boundStart, Point boundEnd) {
		
		ListModel.getSelectedList().getList().clear();
		
		 selection = new SelectCommand(boundStart, boundEnd);
		//Selection box logic upper left and lower right checking
		for (GenerateShape shape : ((ManageObservers) ListModel.getSubjectList()).getList()) {
				if (selection.upperLeftPoint.getX() < shape.startPoint.getX() && selection.lowerRightPoint.getX() > shape.endPoint.getX()
						&& selection.upperLeftPoint.getY() < shape.startPoint.getY() && selection.lowerRightPoint.getY() > shape.endPoint.getY()) {
					ListModel.getSelectedList().addShape(shape);					
				}				
			}
		}	

	@Override
	public void run(){
		select(upperLeftPoint, lowerRightPoint);
	}
	public static SelectCommand getSelection() {
		
		return selection;
	}	

}
