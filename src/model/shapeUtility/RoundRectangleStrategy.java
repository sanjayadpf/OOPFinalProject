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
public class RoundRectangleStrategy implements IDrawShape {

    @Override
    public void draw(GenerateShape shape, Graphics2D graphics2d) {
        if (shape.shadingType == ShapeShadingType.OUTLINE) {

            if (shape.isRoundRec == false) {
                shape.arcWidth = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Corner Arc Width"));
                shape.arcHeight = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Corener Arc Height"));
                shape.isRoundRec = true;
            }
            graphics2d.setColor(Color.WHITE);
            graphics2d.fillRoundRect(shape.x, shape.y, shape.width, shape.height, shape.arcWidth, shape.arcHeight);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.secondaryColor);
            graphics2d.drawRoundRect(shape.x, shape.y, shape.width, shape.height, shape.arcWidth, shape.arcHeight);
            System.out.println("Draw-Rectangle3D-Outline");
        } else if (shape.shadingType == ShapeShadingType.FILLED_IN) {
            if (shape.isRoundRec == false) {
                shape.arcWidth = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Corner Arc Width"));
                shape.arcHeight = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Corener Arc Height"));
                shape.isRoundRec = true;
            }
            graphics2d.setColor(shape.primaryColor);
            graphics2d.fillRoundRect(shape.x, shape.y, shape.width, shape.height, shape.arcWidth, shape.arcHeight);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.primaryColor);
            graphics2d.drawRoundRect(shape.x, shape.y, shape.width, shape.height, shape.arcWidth, shape.arcHeight);
            System.out.println("Draw-Rectangle3D-Filledin");
        } else if (shape.shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            if (shape.isRoundRec == false) {
                shape.arcWidth = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Corner Arc Width"));
                shape.arcHeight = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Corener Arc Height"));
                shape.isRoundRec = true;
            }
            graphics2d.setColor(shape.primaryColor);
            graphics2d.fillRoundRect(shape.x, shape.y, shape.width, shape.height, shape.arcWidth, shape.arcHeight);
            graphics2d.setStroke(new BasicStroke(5));
            graphics2d.setColor(shape.secondaryColor);
            graphics2d.drawRoundRect(shape.x, shape.y, shape.width, shape.height, shape.arcWidth, shape.arcHeight);
            System.out.println("Draw-Rectangle3D-Outline_Filledin");
        }
    }

}
