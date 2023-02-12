/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

/**
 *
 * @author sanja
 */
import java.awt.Color;
import model.ShapeColor;

public class ColorInfo {

    Color color;
    ShapeColor shapeColorName;

    public ColorInfo(Color color, ShapeColor shapeColorName) {
        this.color = color;
        this.shapeColorName = shapeColorName;
    }

    @Override
    public String toString() { // overriding the toString method to display in the combo box.
        return shapeColorName.toString();
    }

    public Color getColor() {
        return color;
    }
}
