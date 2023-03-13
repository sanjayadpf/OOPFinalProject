/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author sanja
 */
public class BoundingBox {

    public static void drawBoundingbox(GenerateShape shape, Graphics2D graphics2d) {
        
               
        graphics2d.setStroke(new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0));
        graphics2d.setColor(Color.BLACK);
        graphics2d.drawRect(shape.x-10, shape.y-10, shape.width+20, shape.height+20);
        System.out.println("Bounding Box");
    }

}
