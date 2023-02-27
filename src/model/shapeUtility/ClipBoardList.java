/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.shapeUtility;

import java.util.List;
import model.interfaces.IShapeList;

/**
 *
 * @author sanja
 */
public class ClipBoardList  implements IShapeList{
    public List<GenerateShape> shapeList;

	public ClipBoardList(List<GenerateShape> shapeList) {
		this.shapeList = shapeList; }

	@Override
	public void addShape(GenerateShape shape) {
		shapeList.add(shape);		
	}

	@Override
	public void removeShape(GenerateShape shape) {
		shapeList.remove(shape);		
	}

	@Override
	public List<GenerateShape> getList() {
		return shapeList;
	}
}
