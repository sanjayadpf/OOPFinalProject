/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import java.util.ArrayList;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.JPaintManager;

/**
 *
 * @author sanja
 */
public class DeleteCommand implements ICommand, IUndoable{
    
    private static GenerateShape deleteShape;
    private static ArrayList<GenerateShape> deleteShapeList = new ArrayList<GenerateShape>();

    @Override
    public void run() {
        deleteShapeList.clear();
        for (GenerateShape shape : JPaintManager.getSelectedList().getList()) {
            deleteShape = shape;
            JPaintManager.getSubjectList().removeShape(deleteShape);
            deleteShapeList.add(deleteShape);

            CommandHistory.add(this);
        }
    }

    @Override
    public void undo() {
        for (GenerateShape shape : deleteShapeList) {
            JPaintManager.getSubjectList().addShape(shape);
        }
    }

    @Override
    public void redo() {
        for (GenerateShape shape : deleteShapeList) {
            JPaintManager.getSubjectList().removeShape(shape);
        }
    }
}
