/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import java.util.ArrayList;
import java.util.List;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.JPaintManager;
import model.shapeUtility.ManageObservers;

/**
 *
 * @author sanja
 */
public class PasteCommand implements ICommand, IUndoable {

    public static List<GenerateShape> clipBoardList;
    public static ManageObservers subjectList;
    public static GenerateShape pasteShape;

    private static ArrayList<GenerateShape> pastedShapeList = new ArrayList<GenerateShape>();

    @Override
    public void run() {
        for (GenerateShape shape : JPaintManager.getClipBoardList().getList()) {
            pasteShape = shape;
            pastedShapeList.add(shape);
            JPaintManager.getSubjectList().addShape(pasteShape);
            CommandHistory.add(this);
        }
        JPaintManager.getClipBoardList().getList().clear();
    }

    @Override
    public void undo() {
        for (GenerateShape shapeToPaste : pastedShapeList) {
            JPaintManager.getSubjectList().removeShape(shapeToPaste);
        }
    }

    @Override
    public void redo() {
        for (GenerateShape shapeToPaste : pastedShapeList) {
            JPaintManager.getSubjectList().addShape(shapeToPaste);
        }
    }

}
