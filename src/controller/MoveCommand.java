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

/**
 *
 * @author sanja
 */
public class MoveCommand implements ICommand, IUndoable {

    private Point targetPoint;
    static GenerateShape previous;
    static GenerateShape current;

    static List<GenerateShape> previousList = new ArrayList<GenerateShape>();
    static List<GenerateShape> currentList = new ArrayList<GenerateShape>();

    public MoveCommand(Point targetPoint) {
        this.targetPoint = targetPoint;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
