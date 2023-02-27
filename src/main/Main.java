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
import model.shapeUtility.ListModel;
import model.shapeUtility.ManageObservers;
import model.shapeUtility.SelectedList;

public class Main {

    public static void main(String[] args) {
        PaintCanvas paintCanvas = new PaintCanvas();
        paintCanvas.addMouseListener(new ClickHandler());

        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);

        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);

        controller.setup();

        ClickHandler.getAppState(appState);//passing the app state to the ClickHandler
        AppMode.getEndpoint(appState);//setting the AppMode with current state

//        final java.util.List<GenerateShape> generateShapes = new ArrayList<GenerateShape>();
//        IShapeSubject subject = new ManageObservers(generateShapes);        
//        IShapeObserver observer = new DrawObserver(paintCanvas);
//        subject.registerObserver(observer);
//        ListModel.subjectList=subject;
//        
//        final java.util.List<GenerateShape> selectedShapes = new ArrayList<GenerateShape>();
//        IShapeList selectedList = new SelectedList(selectedShapes);
//        ListModel.selectedList=selectedList; //adding selectedShapes List
        final java.util.List<GenerateShape> generateShapes = new ArrayList<GenerateShape>();
        IShapeSubject subject = new ManageObservers(generateShapes);
        IShapeObserver observer = new DrawObserver(paintCanvas);
        subject.registerObserver(observer);
        ListModel.subjectList=subject;//adding selectedShapes List

        final java.util.List<GenerateShape> selectedShapes = new ArrayList<GenerateShape>();
        IShapeList selectedList = new SelectedList(selectedShapes);
        ListModel.selectedList=selectedList; //setting selected lists

        final java.util.List<GenerateShape> clipBoardShapes = new ArrayList<GenerateShape>();
        IShapeList clipBoardList = new SelectedList(clipBoardShapes);
        ListModel.clipBoardList=clipBoardList; //setting clipBoardList 
    }
}
