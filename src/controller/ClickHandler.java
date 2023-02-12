/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.persistence.ApplicationState;
import model.shapeUtility.GenerateShape;

/**
 *
 * @author sanja
 */
public class ClickHandler extends MouseAdapter {

    private Point startPoint;
    private Point endPoint;
    private int height;
    private int width;
    private int minX;
    private int minY;
    private static ApplicationState applicationState;

    public void mousePressed(MouseEvent me) {

        startPoint = new Point(me.getX(), me.getY());

    }

    public void mouseReleased(MouseEvent me) {

        endPoint = new Point(me.getX(), me.getY());

        minX = Math.min(startPoint.getX(), endPoint.getY());
        minY = Math.min(startPoint.getY(), endPoint.getY());
        width = Math.abs(startPoint.getX() - endPoint.getX());
        height = Math.abs(startPoint.getY() - endPoint.getY());
        //lets draw
        new GenerateShape(minX, minY, startPoint, endPoint, height, width, applicationState.getActiveShapeType(), applicationState.getActivePrimaryColor().getColor(), applicationState.getActiveSecondaryColor().getColor(), applicationState.getActiveShapeShadingType()).run(); // only in Draw mode

    }

    public static void getAppState(ApplicationState state) {
        applicationState = state;
    }
}
