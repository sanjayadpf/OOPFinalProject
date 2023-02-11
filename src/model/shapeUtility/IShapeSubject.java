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
public interface IShapeSubject {

    void registerObserver(IShapeObserver observer);

    void notifyObservers();//not required but kept it as in the theory

    void addShape(GenerateShape shape);

    void removeShape(GenerateShape shape);

}
