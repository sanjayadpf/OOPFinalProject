/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.interfaces.IShapeList;
import model.shapeUtility.GenerateShape;

/**
 *
 * @author sanja
 */
public class GroupedList implements IShapeList{

    public List<GenerateShape> groupList;

    public GroupedList(List<GenerateShape> shapeList) {
        this.groupList = shapeList;
    }

    @Override
    public void addShape(GenerateShape shape) {
        groupList.add(shape);
    }

    @Override
    public void removeShape(GenerateShape shape) {
        groupList.remove(shape);
    }

    @Override
    public List<GenerateShape> getList() {
        return groupList;
    }
    
}
