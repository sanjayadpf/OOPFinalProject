package model.dialogs;

import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.MouseMode;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import model.shapeUtility.ColorInfo;
import view.interfaces.IDialogChoice;

public class DialogProvider implements IDialogProvider {
    private final IDialogChoice<ShapeType> chooseShapeDialog;
    private final IDialogChoice<ColorInfo> choosePrimaryColorDialog;
    private final IDialogChoice<ColorInfo> chooseSecondaryColorDialog;
    private final IDialogChoice<ShapeShadingType> chooseShadingTypeDialog;
    private final IDialogChoice<MouseMode> chooseStartAndEndPointModeDialog;
    private final IApplicationState applicationState;

    public DialogProvider(IApplicationState applicationState) {
        this.applicationState = applicationState;
        chooseShapeDialog = new ChooseShapeDialog(this.applicationState);
        choosePrimaryColorDialog = new ChoosePrimaryColorDialog(this.applicationState);
        chooseSecondaryColorDialog = new ChooseSecondaryColorDialog(this.applicationState);
        chooseShadingTypeDialog = new ChooseShadingTypeDialog(this.applicationState);
        chooseStartAndEndPointModeDialog = new ChooseStartAndEndPointModeDialog(this.applicationState);
    }

    @Override
    public IDialogChoice<ShapeType> getChooseShapeDialog() {
        return chooseShapeDialog;
    }

    @Override
    public IDialogChoice<ColorInfo> getChoosePrimaryColorDialog() {
        return choosePrimaryColorDialog;
    }

    @Override
    public IDialogChoice<ColorInfo> getChooseSecondaryColorDialog() {
        return chooseSecondaryColorDialog;
    }

    @Override
    public IDialogChoice<ShapeShadingType> getChooseShadingTypeDialog() {
        return chooseShadingTypeDialog;
    }

    @Override
    public IDialogChoice<MouseMode> getChooseStartAndEndPointModeDialog() {
        return chooseStartAndEndPointModeDialog;
    }
}
