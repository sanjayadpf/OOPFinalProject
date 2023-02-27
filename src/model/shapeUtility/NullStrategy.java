/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import java.awt.Graphics2D;
import model.interfaces.IDrawShape;

/**
 *
 * @author sanja
 */
public class NullStrategy implements IDrawShape{

    @Override
    public void draw(GenerateShape shape, Graphics2D graphics2d) {
        System.out.println("No Shape is selected Something is wrong!");
    }
    
}
