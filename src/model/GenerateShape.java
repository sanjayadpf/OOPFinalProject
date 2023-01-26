/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.CommandHistory;
import controller.ICommand;
import controller.IUndoable;

/**
 *
 * @author sanja
 */
public class GenerateShape implements ICommand,IUndoable{

    public GenerateShape() {
        
        
    }
    
    

    @Override
    public void run() {
        CommandHistory.add(this);
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
