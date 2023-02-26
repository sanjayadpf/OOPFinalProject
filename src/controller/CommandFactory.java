/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import java.awt.Color;
import model.ShapeShadingType;
import model.ShapeType;
import model.shapeUtility.GenerateShape;

/**
 *
 * @author sanja
 */
public class CommandFactory {

    public static ICommand draw(int x, int y, Point startPoint, Point endPoint,
            int height, int width,ShapeType shapeType, Color primaryColor, Color secondaryColor, ShapeShadingType shadingType) {
        return new GenerateShape(x, y, startPoint, endPoint, height, width,shapeType, primaryColor, secondaryColor, shadingType);
    }

    public static ICommand select(Point startPoint, Point endPoint) {
        return new SelectCommand(startPoint, endPoint);
    }

   /* public static ICommand move(CustomPair startingPair) {
        return new MoveShape(startingPair);
    }*/
}
