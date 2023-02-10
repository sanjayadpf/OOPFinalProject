package model.interfaces;

import java.awt.Graphics2D;
import model.shapeUtility.GenerateShape;

public interface IDrawShape {
	
	public void draw(GenerateShape shape, Graphics2D graphics2d);
}
