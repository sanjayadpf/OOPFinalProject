package model.interfaces;

import java.awt.Graphics2D;
import model.shapeUtility.CreateShape;

public interface IDrawShape {
	
	public void draw(CreateShape shape, Graphics2D graphics2d);
}
