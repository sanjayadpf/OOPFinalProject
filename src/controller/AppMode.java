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
import model.shapeUtility.JPaintManager;

/**
 *
 * @author sanja
 */
public class AppMode {

    private static ApplicationState appState;
    private static ICommand command;

    public static void executeCommand(int x, int y, Point startPoint,
            Point endPoint, int height, int width,
            ShapeType shapeType, Color primaryColor, Color secondaryColor, ShapeShadingType shadingType)
            throws IOException {

        
        MouseMode mode = appState.getActiveMouseMode();
        
        if(mode==DRAW){
            command = CommandFactory.draw(x, y, startPoint, endPoint, height, width, shapeType,primaryColor,secondaryColor,shadingType);
            
        }else if(mode == SELECT){
            command = CommandFactory.select(startPoint, endPoint);
            
            System.out.println("select works");
        }else if(mode==MOVE){
            command = CommandFactory.move(startPoint);
            System.out.println("move works");
        }else if (command==null){
            command= new NullCommand();
        }
        command.run();
    }

    public static void getEndpoint(ApplicationState state) {
        appState = state;
    }

}
