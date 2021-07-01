package de.hsa.maxist.chess.core;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.board.BoardCfg;
import de.hsa.maxist.chess.engine.Game;
import de.hsa.maxist.chess.engine.ui.UI;
import de.hsa.maxist.chess.engine.ui.FxUi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static final boolean FXMODE = true;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        UI ui = FxUi.createInstance();
        Game chessGame = new Game(new Board(new BoardCfg(null)), ui);

        primaryStage.setScene((Scene) ui);
        ((Scene)ui).getWindow().setOnCloseRequest(event -> System.exit(1));
        primaryStage.setFullScreen(false);
        primaryStage.show();

        chessGame.run();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
