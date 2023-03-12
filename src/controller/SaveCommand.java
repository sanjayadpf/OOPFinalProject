/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import com.google.gson.Gson; //imports for JSON
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import static controller.SelectCommand.selection;
import java.util.List;
import model.shapeUtility.BoundingBox;
import model.shapeUtility.DrawObserver;
import model.shapeUtility.GenerateShape;
import model.shapeUtility.JPaintManager;
import model.shapeUtility.ManageObservers;
import model.shapeUtility.SaveList;

/**
 *
 * @author sanja
 */
public class SaveCommand implements ICommand {

    public static List<GenerateShape> save() {
        // normal selection
        JPaintManager.getSaveList().getList().clear();

        //Selection box logic upper left and lower right checking
        for (GenerateShape shape : ((ManageObservers) JPaintManager.getSubjectList()).getList()) {
            if (0 < shape.startPoint.getX() && 1250 > shape.endPoint.getX()
                    && 0 < shape.startPoint.getY() && 1250 > shape.endPoint.getY()) {
                JPaintManager.getSaveList().addShape(shape);

            }
        }
        return JPaintManager.getSaveList().getList();
    }

    @Override
    public void run() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select file path and give a name to file");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            Gson gson = new GsonBuilder().setPrettyPrinting().create(); // creating a GSONbuilder object

            //using a File Writer
            try (FileWriter writer = new FileWriter(fileToSave.getAbsolutePath() + "." + "json")) {
                gson.toJson(save(), writer); // adding to the json as an array
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
