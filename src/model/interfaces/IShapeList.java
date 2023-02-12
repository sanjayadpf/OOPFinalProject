/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.interfaces;

/**
 *
 * @author sanja
 */
import java.util.List;
import model.shapeUtility.GenerateShape;

public interface IShapeList {

    public void addShape(GenerateShape shape);

    public void removeShape(GenerateShape shape);

    public List<GenerateShape> getList();
}
