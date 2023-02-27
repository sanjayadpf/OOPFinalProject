/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.interfaces.ICommand;

/**
 *
 * @author sanja
 */
public class NullCommand implements ICommand{

    @Override
    public void run() {
        System.out.println("Command is not working Something is Wrong");
    }
    
}
