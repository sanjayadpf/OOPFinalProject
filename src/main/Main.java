package main;

import controller.AppMode;
import controller.ClickHandler;
import controller.interfaces.IJPaintController;
import controller.JPaintController;
import model.ShapeColor;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import model.interfaces.IShapeList;
import model.shapeUtility.DrawObserver;
import model.shapeUtility.GenerateShape;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;
import model.shapeUtility.JPaintManager;
import model.shapeUtility.ManageObservers;
import model.shapeUtility.SelectedList;

public class Main {

    public static void main(String[] args) {
        final java.util.List<GenerateShape> selectedShapes = new ArrayList<GenerateShape>();
        IShapeList selectedList = new SelectedList(selectedShapes);
        JPaintManager.getInstance().setSelectedList(selectedList);
        //ListModel.selectedList = selectedList; //setting selected lists

        final java.util.List<GenerateShape> clipBoardShapes = new ArrayList<GenerateShape>();
        IShapeList clipBoardList = new SelectedList(clipBoardShapes);
        JPaintManager.getInstance().setClipBoardList(clipBoardList);
        //ListModel.clipBoardList = clipBoardList; //setting clipBoardList

        //for grouping
        final java.util.List<GenerateShape> groupedShapes = new ArrayList<GenerateShape>();
        IShapeList groupedList = new SelectedList(groupedShapes);
       // JPaintManager.groupList = groupedList; //setting selected lists
        
        JPaintManager.getInstance().setGroupList(groupedList);
        //for save
        
        final java.util.List<GenerateShape> savedShapes = new ArrayList<GenerateShape>();
        IShapeList savedList = new SelectedList(savedShapes);
        JPaintManager.getInstance().setSaveList(groupedList);
//        final java.util.List<GenerateShape> generateShapes = new ArrayList<GenerateShape>();
//        IShapeSubject subject = new ManageObservers(generateShapes);        
//        IShapeObserver observer = new DrawObserver(paintCanvas);
//        subject.registerObserver(observer);
//        JPaintManager.subjectList=subject;
//        
//        final java.util.List<GenerateShape> selectedShapes = new ArrayList<GenerateShape>();
//        IShapeList selectedList = new SelectedList(selectedShapes);
//        JPaintManager.selectedList=selectedList; //adding selectedShapes List
    }
}
