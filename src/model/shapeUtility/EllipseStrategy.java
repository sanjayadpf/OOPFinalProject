/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import model.interfaces.IDrawShape;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeShadingType;

/**
 *
 * @author sanja
 */
public class EllipseStrategy implements IDrawShape {

    @Override
    public void draw(GenerateShape shape, Graphics2D graphics2d) {

        if (shape.shadingType == ShapeShadingType.OUTLINE) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.fillOval(shape.x, shape.y, shape.width, shape.height);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.secondaryColor);
            graphics2d.drawOval(shape.x, shape.y, shape.width, shape.height);
            System.out.println("Draw-Ellipse-Outline");
        } else if (shape.shadingType == ShapeShadingType.FILLED_IN) {
            graphics2d.setColor(shape.primaryColor);
            graphics2d.fillOval(shape.x, shape.y, shape.width, shape.height);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.primaryColor);
            graphics2d.drawOval(shape.x, shape.y, shape.width, shape.height);
            System.out.println("Draw-Ellipse-Filledin");
        } else if (shape.shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            graphics2d.setColor(shape.primaryColor);
            graphics2d.fillOval(shape.x, shape.y, shape.width, shape.height);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.secondaryColor);
            graphics2d.drawOval(shape.x, shape.y, shape.width, shape.height);
            System.out.println("Draw-Ellipse-Outline_Filledin");

        }

    }
}
