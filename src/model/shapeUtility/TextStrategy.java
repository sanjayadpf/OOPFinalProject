/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import model.ShapeShadingType;
import model.interfaces.IDrawShape;

/**
 *
 * @author sanja
 */
public class TextStrategy implements IDrawShape {

    @Override
    public void draw(GenerateShape shape, Graphics2D graphics2d) {
        if (shape.shadingType == ShapeShadingType.OUTLINE) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.setColor(shape.primaryColor);
            graphics2d.setFont(new Font("Arial Bold", 30, 30));
            if (shape.isText == false) {
                shape.text = JOptionPane.showInputDialog(null, "Enter Text");
                shape.isText=true;
            }
            graphics2d.drawString(shape.text, shape.x, shape.y);
            System.out.println("Draw-Line-Outline");
        } else if (shape.shadingType == ShapeShadingType.FILLED_IN) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.setColor(shape.primaryColor);
            graphics2d.setFont(new Font("Arial Bold", 30, 30));
            if (shape.isText == false) {
                shape.text = JOptionPane.showInputDialog(null, "Enter Text");
                shape.isText=true;
            }
            graphics2d.drawString(shape.text, shape.x, shape.y);
            System.out.println("Draw-Line-Outline");
        } else if (shape.shadingType == ShapeShadingType.OUTLINE_AND_FILLED_IN) {
            graphics2d.setColor(Color.WHITE);
            graphics2d.setColor(shape.primaryColor);
            graphics2d.setFont(new Font("Arial Bold", 30, 30));
            if (shape.isText == false) {
                shape.text = JOptionPane.showInputDialog(null, "Enter Text");
                shape.isText=true;
            }
            graphics2d.drawString(shape.text, shape.x, shape.y);
            System.out.println("Draw-Line-Outline");
        }
    }

}
