package model.shapeUtility;

import java.awt.Color;

import controller.CommandHistory;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import controller.Point;
import model.shapeUtility.ShapeConfiguration;
import model.ShapeShadingType;
import model.ShapeType;


public class GenerateShape implements ICommand, IUndoable {
	
	public GenerateShape shape;
	public Color primaryColor;
	public Color secondaryColor;
	public ShapeType shapeType;	
	public ShapeShadingType shadingType;
	public ShapeConfiguration shapeConfig;
	public Point startPoint;
	public Point endPoint;
	public int height;
	public int width;	
	int x;
	int y;		
	
	public GenerateShape(int x, int y, Point startingPair, Point endingPair,
						int height, int width, ShapeConfiguration shapeConfig){
		this.x = x;
		this.y = y;
		this.startPoint = startingPair;
		this.endPoint = endingPair;
		this.height = height;
		this.width = width;
		this.shapeConfig = shapeConfig;		
		this.shapeType = shapeConfig.shapeType;
		this.primaryColor = shapeConfig.primaryColor.getColor();
		this.secondaryColor = shapeConfig.secondaryColor.getColor();
		this.shadingType = shapeConfig.shadingType;		}

	@Override
	public void run()  {
		shape = new GenerateShape(x, y, startPoint, endPoint, height, width, shapeConfig);		
		ListManager.getMaster().addShape(shape);		
		CommandHistory.add(this);		
		}		

	@Override
	public void undo() {		
		ListManager.getMaster().removeShape(shape);	
	}

	@Override
	public void redo() {
		ListManager.getMaster().addShape(shape);			
	}
}

