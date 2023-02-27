/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

/**
 *
 * @author sanja
 */
import model.interfaces.IShapeObserver;
import model.interfaces.IDrawShape;
import java.awt.Color;
import java.awt.Graphics2D;
import model.ShapeType;
import view.gui.PaintCanvas;

public class DrawObserver implements IShapeObserver {

    public PaintCanvas canvas;
    public static Graphics2D graphics2d;
    public static DrawObserver drawShape;

    public DrawObserver(PaintCanvas canvas) {
        graphics2d = canvas.getGraphics2D();
    }

    @Override
    public void update() {
        graphics2d.setColor(Color.WHITE);
        graphics2d.fillRect(0, 0, 1250, 800); //get height and width
        System.out.println("1observer running");
        for (GenerateShape shape : ((ManageObservers) ListModel.getSubjectList()).getList()) {
            StrategySelection.drawShapeStrategy(shape, drawShape);
            System.out.println("2observer running");
        }
    }
}
