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
public class GroupCommand implements ICommand,IUndoable{
    
   

    @Override
    public void run() {
        JPaintManager.setSelectedList(JPaintManager.getGroupList());
       // JPaintManager.selectedList=JPaintManager.groupList;
       // JPaintManager.getGroupList().getList().clear();
        System.out.println("Group");
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
