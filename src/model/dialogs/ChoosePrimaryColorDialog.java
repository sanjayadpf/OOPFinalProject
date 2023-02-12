package model.dialogs;

import java.awt.Color;
import java.util.ArrayList;
import model.ShapeColor;
import model.interfaces.IApplicationState;
import model.shapeUtility.ColorInfo;
import view.interfaces.IDialogChoice;

public class ChoosePrimaryColorDialog implements IDialogChoice<ColorInfo> {

    private final IApplicationState applicationState;
    private final ArrayList<ColorInfo> colorList;

    public ChoosePrimaryColorDialog(IApplicationState applicationState) {
        this.applicationState = applicationState;
        colorList = new ArrayList<ColorInfo>();
        colorList.add(new ColorInfo(Color.BLUE, ShapeColor.BLUE));
        colorList.add(new ColorInfo(Color.RED, ShapeColor.RED));
        colorList.add(new ColorInfo(Color.BLACK, ShapeColor.BLACK));

    }

    @Override
    public String getDialogTitle() {
        return "Primary Color";
    }

    @Override
    public String getDialogText() {
        return "Select a primary color from the menu below:";
    }

    @Override
    public ColorInfo[] getDialogOptions() {
        return colorList.toArray(new ColorInfo[0]);
    }

    @Override
    public ColorInfo getCurrentSelection() {
        return applicationState.getActivePrimaryColor();
    }
}
