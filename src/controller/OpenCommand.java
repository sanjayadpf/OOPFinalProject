/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import controller.interfaces.ICommand;
import controller.interfaces.IUndoable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

import model.shapeUtility.GenerateShape;
import model.shapeUtility.JPaintManager;

/**
 *
 * @author sanja
 */
public class OpenCommand implements ICommand, IUndoable {

    public static GenerateShape openShape;

    private static ArrayList<GenerateShape> openList = new ArrayList<GenerateShape>();

    @Override
    public void run() {
        readJson();

    }

    public void readJson() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            Reader inputFile = null;
            Gson gson = new Gson();//GSOn object

            try {
                inputFile = new FileReader(selectedFile.getAbsolutePath());
                Type typeFormat = new TypeToken<List<GenerateShape>>() {
                }.getType();

                List<GenerateShape> shapeList = gson.fromJson(inputFile, typeFormat);

                for (GenerateShape shape : shapeList) {

                    openShape = shape;
                    openList.add(shape);
                    JPaintManager.getSubjectList().addShape(openShape);
                    CommandHistory.add(this);
                }
                JPaintManager.getSaveList().getList().clear();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(OpenCommand.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    inputFile.close(); // closing the file
                } catch (IOException ex) {
                    Logger.getLogger(OpenCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    public void undo() {
        for (GenerateShape shapeToOpen : openList) {
            JPaintManager.getSubjectList().removeShape(shapeToOpen);
        }
    }

    @Override
    public void redo() {
        for (GenerateShape shapeToOpen : openList) {
            JPaintManager.getSubjectList().addShape(shapeToOpen);
        }
    }
}
