/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import model.interfaces.IShapeList;
import model.interfaces.IShapeSubject;

/**
 *
 * @author sanja
 */
public class ListModel {

    public static IShapeSubject subjectList;
    public static IShapeList selectedList;
    public static IShapeList clipBoardList;
    public static IShapeList groupList;

    public static IShapeList getGroupList() {
        return groupList;
    }

    public static void setGroupList(IShapeList groupList) {
        ListModel.groupList = groupList;
    }

    public static ListModel getModel() {
        return model;
    }

    public static void setModel(ListModel model) {
        ListModel.model = model;
    }

    static ListModel model;


    public static IShapeSubject getSubjectList() {
        return subjectList;
    }

    public static IShapeList getSelectedList() {
        return selectedList;
    }

    public static IShapeList getClipBoardList() {
        return clipBoardList;
    }

    public static void getModel(ListModel thisManager) {
        model = thisManager;
    }
}
