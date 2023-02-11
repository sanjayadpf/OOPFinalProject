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

import java.util.ArrayList;
import java.util.List;

public class ManageObservers implements IShapeSubject, IShapeList {

    private List<IShapeObserver> observerList = new ArrayList<IShapeObserver>();

    public List<GenerateShape> shapeList;

    public ManageObservers(List<GenerateShape> shapeList) {
        this.shapeList = shapeList;
    }

    @Override
    public void addShape(GenerateShape shape) {
        shapeList.add(shape);
        notifyObservers();
    }

    @Override
    public void removeShape(GenerateShape shape) {
        shapeList.remove(shape);
        notifyObservers();
    }

    @Override
    public void registerObserver(IShapeObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (IShapeObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public List<GenerateShape> getList() {
        return shapeList;
    }
}
