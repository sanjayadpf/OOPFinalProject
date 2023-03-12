/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import model.shapeUtility.JPaintManager;

/**
 *
 * @author sanja
 */
public class GroupCommand implements ICommand{

    @Override
    public void run() {
        JPaintManager.setSelectedList(JPaintManager.getGroupList());
       // JPaintManager.selectedList=JPaintManager.groupList;
       // JPaintManager.getGroupList().getList().clear();
        System.out.println("Group");
    }
    
}
