/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import java.awt.Color;
import java.io.IOException;
import model.MouseMode;
import static model.MouseMode.DRAW;
import static model.MouseMode.MOVE;
import static model.MouseMode.SELECT;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;

/**
 *
 * @author sanja
 */
public class AppMode {

    private static ApplicationState appState;
    private static ICommand command;

    public static void executeCommand(int X, int Y, Point startPoint,
            Point endPoint, int height, int width,
            ShapeType shapeType, Color primaryColor, Color secondaryColor, ShapeShadingType shadingType)
            throws IOException {

        
        MouseMode mode = appState.getActiveMouseMode();
        
        if(mode==DRAW){
            command = CommandFactory.draw(X, Y, startPoint, endPoint, height, width, shapeType,primaryColor,secondaryColor,shadingType);
        }else if(mode == SELECT){
            command = CommandFactory.select(startPoint, endPoint);
        }else if(mode==MOVE){
            command = CommandFactory.move(startPoint);
        }
        command.run();
    }

    public static void getEndpoint(ApplicationState state) {
        appState = state;
    }

}
