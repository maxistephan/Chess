package de.hsa.maxist.chess.engine.ui;

import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.engine.ui.UI;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

public class FxUi extends Scene implements UI {

    public FxUi(Parent parent) {
        super(parent);
    }

    @Override
    public void draw() {

    }

    @Override
    public Command getInput() {
        return null;
    }
}
