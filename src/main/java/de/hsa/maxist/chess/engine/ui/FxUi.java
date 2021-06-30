package de.hsa.maxist.chess.engine.ui;

import de.hsa.maxist.chess.core.board.BoardView;
import de.hsa.maxist.chess.core.command.Command;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class FxUi extends Scene implements UI {

    private final Canvas boardCanvas;
    private final ListView<Label> messages;

    private FxUi(Parent parent, Canvas boardCanvas, ListView<Label> messages) {
        super(parent);
        this.boardCanvas = boardCanvas;
        this.messages = messages;
    }

    public static FxUi createInstance() {
        BorderPane root = new BorderPane();

        Canvas canvas = new Canvas();
        ListView<Label> listView = new ListView<>();

        root.setCenter(canvas);
        root.setRight(listView);

        FxUi instance = new FxUi(root, canvas, listView);
        return instance;
    }

    @Override
    public void draw(final BoardView view) {
        Platform.runLater(() -> redrawBoardCanvas(view));
    }

    private void redrawBoardCanvas(BoardView view) {

    }

    @Override
    public Command getInput() {
        return null;
    }
}
