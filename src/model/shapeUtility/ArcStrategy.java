/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import model.ShapeShadingType;
import model.interfaces.IDrawShape;

/**
 *
 * @author sanja
 */
public class ArcStrategy implements IDrawShape {

    @Override
    public void draw(GenerateShape shape, Graphics2D graphics2d) {
        if (shape.shadingType == ShapeShadingType.OUTLINE) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.primaryColor);

            if (shape.isArc == false) {
                shape.startAngle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Start Angle"));
                shape.endAngle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter End Angle"));
                shape.isArc = true;
            }
            graphics2d.drawArc(shape.x, shape.y, shape.width, shape.height, shape.startAngle, shape.endAngle);
            System.out.println("Draw-Arc-Outline");
        } else if (shape.shadingType == ShapeShadingType.FILLED_IN) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.primaryColor);

            if (shape.isArc == false) {
                shape.startAngle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Start Angle"));
                shape.endAngle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter End Angle"));
                shape.isArc = true;
            }
            graphics2d.drawArc(shape.x, shape.y, shape.width, shape.height, shape.startAngle, shape.endAngle);
            System.out.println("Draw-Arc-Outline");
        } else if (shape.shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.primaryColor);
            
            if (shape.isArc == false) {
                shape.startAngle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Start Angle"));
                shape.endAngle = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter End Angle"));
                shape.isArc = true;
            }
            graphics2d.drawArc(shape.x, shape.y, shape.width, shape.height, shape.startAngle, shape.endAngle);
            System.out.println("Draw-Arc-Outline");
        }
    }

}
