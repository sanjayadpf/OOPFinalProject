/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.GenerateShape;

/**
 *
 * @author sanja
 */
public class RedoCommand implements ICommand {

    @Override
    public void run() {
        CommandHistory.redo();

        int stackSize = CommandHistory.redoStack.size();

        if (stackSize != 0) {
            GenerateShape gstemp = (GenerateShape) CommandHistory.redoStack.peek();

            //gstemp.getCanvas().repaint();
            //
            // gstemp.getCanvas().removeAll();
            // CommandHistory.undoStack
            for (IUndoable iu : CommandHistory.redoStack) {

                GenerateShape gs = (GenerateShape) iu;

                gs.getCanvas().getGraphics2D().drawRect(gs.getStrX() + 400, gs.getStrY(), gs.getWidth(), gs.getHeight());
                System.out.println("run");
                //
            }
            //  gstemp.getCanvas().paint(gstemp.getGraphics());
        }
        //for Test
        System.out.println("Redo- from Redo command class" + stackSize);
    }
}
