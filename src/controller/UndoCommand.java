/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.IUndoable;
import controller.interfaces.ICommand;
import javax.swing.JComponent;
import model.shapeUtility.GenerateShape;

/**
 *
 * @author sanja
 */
public class UndoCommand implements ICommand {

    int move = 200;

    @Override
    public void run() {
        CommandHistory.undo();

        /*   int stackSize = CommandHistory.undoStack.size();

        if (stackSize != 0) {
            GenerateShape gstemp = (GenerateShape) CommandHistory.undoStack.peek();

            //gstemp.getCanvas().repaint();
            //
            // gstemp.getCanvas().removeAll();
            // CommandHistory.undoStack
            for (IUndoable iu : CommandHistory.undoStack) {

                GenerateShape gs = (GenerateShape) iu;

                gs.getCanvas().getGraphics2D().drawRect(gs.getStrX() + move, gs.getStrY(), gs.getWidth(), gs.getHeight());

                //
            }
            //  gstemp.getCanvas().paint(gstemp.getGraphics());
        }
        //for test
        System.out.println("Undo- from UndoCommand Class" + stackSize);
        move += 200;*/
    }
}
