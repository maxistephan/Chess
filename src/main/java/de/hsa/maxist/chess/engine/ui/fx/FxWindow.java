package de.hsa.maxist.chess.engine.ui.fx;

import de.hsa.maxist.chess.engine.ui.Window;
import javafx.scene.canvas.Canvas;

import javax.swing.*;

public class FxWindow extends JPanel implements Window {

    private final Canvas canvas;

    public FxWindow(FxUi canvas) {
        this.canvas = canvas;
    }

    @Override
    public void show() {

    }

}
