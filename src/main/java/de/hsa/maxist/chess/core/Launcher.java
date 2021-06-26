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

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();

        UI ui = new FxUi(root);
        Game chessGame = new Game(new Board(new BoardCfg()), ui);

        primaryStage.setScene((Scene) ui);
        primaryStage.sizeToScene();
        primaryStage.show();
        chessGame.run();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
