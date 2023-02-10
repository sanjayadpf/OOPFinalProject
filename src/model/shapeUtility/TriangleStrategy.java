package model.shapeUtility;

import model.interfaces.IDrawShape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;

public class TriangleStrategy implements IDrawShape {

    @Override
    public void draw(GenerateShape shape, Graphics2D graphics2d) {

        int[] x_coordinate = new int[3];
        x_coordinate[0] = shape.startPoint.getX();
        x_coordinate[1] = shape.startPoint.getX();
        x_coordinate[2] = shape.endPoint.getX();

        int[] y_coordinate = new int[3];
        y_coordinate[0] = shape.startPoint.getY();
        y_coordinate[1] = shape.endPoint.getY();
        y_coordinate[2] = shape.endPoint.getY();

        if (shape.shadingType == ShapeShadingType.OUTLINE) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.fillPolygon(x_coordinate, y_coordinate, 3);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.primaryColor);
            graphics2d.drawPolygon(x_coordinate, y_coordinate, 3);
        } else if (shape.shadingType == ShapeShadingType.FILLED_IN) {
            graphics2d.setColor(shape.primaryColor);
            graphics2d.fillPolygon(x_coordinate, y_coordinate, 3);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.primaryColor);
            graphics2d.fillPolygon(x_coordinate, y_coordinate, 3);
        } else if (shape.shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            graphics2d.setColor(shape.primaryColor);
            graphics2d.fillPolygon(x_coordinate, y_coordinate, 3);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.secondaryColor);
            graphics2d.drawPolygon(x_coordinate, y_coordinate, 3);

        }

    }
}
