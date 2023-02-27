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

  	public static IShapeSubject  subjectList;
	public static IShapeList selectedList;
	public static IShapeList clipBoardList;
	
	static ListModel model;

	public ListModel(IShapeSubject masterList, IShapeList selectedList, IShapeList clipBoard) {
		ListModel.subjectList = masterList;
		ListModel.selectedList = selectedList;
		ListModel.clipBoardList = clipBoard;
	}
	
	public static IShapeSubject  getSubjectList() {
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
