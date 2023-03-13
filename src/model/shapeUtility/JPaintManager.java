/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import controller.AppMode;
import controller.ClickHandler;
import controller.JPaintController;
import controller.interfaces.IJPaintController;
import java.sql.SQLException;
import java.util.ArrayList;
import model.interfaces.IShapeList;
import model.interfaces.IShapeObserver;
import model.interfaces.IShapeSubject;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

/**
 *
 * @author sanja
 */
public class JPaintManager {

    private static JPaintManager jPaintManager;

    private static IShapeSubject subjectList;
    private static IShapeList selectedList;
    private static IShapeList clipBoardList;
    private static IShapeList groupList;
    private static IShapeList saveList;

    PaintCanvas paintCanvas;
    IGuiWindow guiWindow;
    IUiModule uiModule;
    ApplicationState appState;
    IJPaintController controller;

    public JPaintManager() {
        //onetime process
        paintCanvas = new PaintCanvas();
        paintCanvas.addMouseListener(new ClickHandler());

        guiWindow = new GuiWindow(paintCanvas);
        uiModule = new Gui(guiWindow);

        appState = new ApplicationState(uiModule);
        controller = new JPaintController(uiModule, appState);

        controller.setup();



        ClickHandler.getAppState(appState);//passing the app state to the ClickHandler
        AppMode.getEndpoint(appState);//setting the AppMode with current state
        final java.util.List<GenerateShape> generateShapes = new ArrayList<GenerateShape>();
        IShapeSubject subject = new ManageObservers(generateShapes);
        IShapeObserver observer = new DrawObserver(paintCanvas);
        subject.registerObserver(observer);
        JPaintManager.subjectList = subject;//adding selectedShapes List

    }

    public IGuiWindow getGuiWindow() {
        return guiWindow;
    }

    public void setGuiWindow(IGuiWindow guiWindow) {
        this.guiWindow = guiWindow;
    }

    //singleton implementation
    public static JPaintManager getInstance() {
        if (jPaintManager == null) {
            jPaintManager = new JPaintManager();
        }
        return jPaintManager;
    }

    public static IShapeList getGroupList() {
        return groupList;
    }

    public static void setGroupList(IShapeList groupList) {
        JPaintManager.groupList = groupList;
    }

    public static JPaintManager getModel() {
        return model;
    }

    public static void setModel(JPaintManager model) {
        JPaintManager.model = model;
    }

    static JPaintManager model;

    public static IShapeSubject getSubjectList() {
        return subjectList;
    }

    public static IShapeList getSelectedList() {
        return selectedList;
    }

    public static IShapeList getClipBoardList() {
        return clipBoardList;
    }

    public static void getModel(JPaintManager thisManager) {
        model = thisManager;
    }

    public static void setSubjectList(IShapeSubject subjectList) {
        JPaintManager.subjectList = subjectList;
    }

    public static void setSelectedList(IShapeList selectedList) {
        JPaintManager.selectedList = selectedList;
    }

    public static void setClipBoardList(IShapeList clipBoardList) {
        JPaintManager.clipBoardList = clipBoardList;
    }

    public static IShapeList getSaveList() {
        return saveList;
    }

    public static void setSaveList(IShapeList saveList) {
        JPaintManager.saveList = saveList;
    }

    public ApplicationState getAppState() {
        return appState;
    }

    public void setAppState(ApplicationState appState) {
        this.appState = appState;
    }

}
