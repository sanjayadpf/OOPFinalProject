/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import model.shapeUtility.ListModel;

/**
 *
 * @author sanja
 */
public class GroupCommand implements ICommand{

    @Override
    public void run() {
        ListModel.selectedList=ListModel.groupList;
       // ListModel.getGroupList().getList().clear();
        System.out.println("Group");
    }
    
}
