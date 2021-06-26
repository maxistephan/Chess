package de.hsa.maxist.chess.core;

import de.hsa.maxist.chess.engine.GameType;
import de.hsa.maxist.chess.engine.ui.Window;
import de.hsa.maxist.chess.engine.ui.fx.FxUi;
import de.hsa.maxist.chess.engine.ui.fx.FxWindow;
import de.hsa.maxist.chess.engine.ui.swing.SwingUi;
import de.hsa.maxist.chess.engine.ui.UI;
import de.hsa.maxist.chess.engine.ui.swing.SwingWindow;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

import javax.swing.*;

public class Launcher extends Application {

    public static final GameType GAME_TYPE = GameType.FX;

    @Override
    public void start(Stage primaryStage) {

        UI ui = null;
        Window window = null;

        switch (GAME_TYPE) {
            case FX -> {
                ui = new FxUi();
                window = new FxWindow((FxUi) ui);
            }
            case SWING -> {
                ui = new SwingUi();
                window = new SwingWindow((SwingUi) ui);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
