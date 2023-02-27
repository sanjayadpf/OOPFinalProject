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
    public static IShapeList clipBoard;
    
    static ListModel model;


    public static IShapeSubject getSubjectList() {
        return subjectList;
    }

    public static void setSubjectList(IShapeSubject subjectList) {
        ListModel.subjectList = subjectList;
    }

    public static IShapeList getSelectedList() {
        return selectedList;
    }

    public static void setSelectedList(IShapeList selectedList) {
        ListModel.selectedList = selectedList;
    }

    public static IShapeList getClipBoard() {
        return clipBoard;
    }

    public static void setClipBoard(IShapeList clipBoard) {
        ListModel.clipBoard = clipBoard;
    }

    public static ListModel getModel() {
        return model;
    }

    public static void setModel(ListModel model) {
        ListModel.model = model;
    }
 
}
