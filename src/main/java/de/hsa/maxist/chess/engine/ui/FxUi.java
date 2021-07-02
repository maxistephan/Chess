package de.hsa.maxist.chess.engine.ui;

import de.hsa.maxist.chess.core.board.BoardView;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.core.command.GameCommandType;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.Piece;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.Dimension;
import java.awt.Toolkit;


public class FxUi extends Scene implements UI {

    private static int CELL_SIZE;
    private static int OFFSET;
    private static final Color BLACK = Color.rgb(243, 212, 183);
    private static final Color WHITE = Color.rgb(238, 156, 73);

    private final Canvas boardCanvas;
    private final ListView<Label> messageLabel;
    private Command lastCmd = new Command(GameCommandType.NONE);
    private ObservableList<Label> messages = FXCollections.observableArrayList();

    private FxUi(Parent parent, Canvas boardCanvas, ListView<Label> messageLabel) {
        super(parent);
        this.boardCanvas = boardCanvas;
        this.messageLabel = messageLabel;
        this.messageLabel.setItems(messages);
    }

    /*******************************************************************************************************************
     * Create a ui instance
     ******************************************************************************************************************/
    public static FxUi createInstance() {
        BorderPane root = new BorderPane();
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        CELL_SIZE = Math.min(size.height, size.width) / 10;

        Canvas canvas = new Canvas(CELL_SIZE * 9, CELL_SIZE * 9);
        ListView<Label> listView = new ListView<>();

        root.setCenter(canvas);
        root.setRight(listView);

        FxUi instance = new FxUi(root, canvas, listView);

        // Keyboard events
        instance.setOnKeyPressed(e -> instance.lastCmd = new Command(GameCommandType.NONE));
        instance.setOnKeyReleased(e -> instance.lastCmd = new Command(GameCommandType.NONE));

        // Mouse events
        instance.setOnDragDetected(e -> instance.lastCmd = new Command(GameCommandType.DRAG,  new XY((int)e.getX(), (int)e.getY())));
        instance.setOnMouseReleased(e -> {
            if(instance.lastCmd.getCommandType() == GameCommandType.DRAG)
                instance.lastCmd = new Command(GameCommandType.DROP,  new XY((int)e.getX(), (int)e.getY()));
            else
                instance.lastCmd = new Command(GameCommandType.CLICK, new XY((int)e.getX(), (int)e.getY()));
        });
        return instance;
    }

    @Override
    public void draw(final BoardView view) {
        Platform.runLater(() -> redrawBoardCanvas(view));
    }

    @Override
    public void message(String message) {
        Platform.runLater(() -> messages.add(new Label(message)));
    }

    /*******************************************************************************************************************
     * Redraws this board canvas
     * @param view Board view for reference
     ******************************************************************************************************************/
    private void redrawBoardCanvas(BoardView view) {
        OFFSET = CELL_SIZE / 2;

        GraphicsContext gc = boardCanvas.getGraphicsContext2D();
        drawBoard(gc);

        gc.setFill(Color.BLACK);
        gc.setFont(new Font("Times New Roman", CELL_SIZE));
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                Piece piece = view.getPieceAt(new XY(i, j));
                if(piece != null)
                    gc.fillText(String.valueOf(piece.getChar()), i * CELL_SIZE + OFFSET, (j + 1) * CELL_SIZE + OFFSET);
            }
        }
    }

    /*******************************************************************************************************************
     * Drawing the Chess Board onto a canvas
     * @param gc Graphics Context of the Canvas to draw on
     ******************************************************************************************************************/
    private void drawBoard(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, boardCanvas.getWidth(), boardCanvas.getHeight());
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                gc.setFill(((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) ? WHITE : BLACK);
                gc.fillRect(CELL_SIZE * i + OFFSET, CELL_SIZE * j + OFFSET, CELL_SIZE, CELL_SIZE);
            }
        }

        float textSize = (float) OFFSET / 2;
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("TimesRoman", textSize));

        for(int i = 1; i < 9; i++) {
            // Letters
            gc.fillText(String.valueOf((char) (i + 'a' - 1)), i * CELL_SIZE - textSize / 2, (float) OFFSET / 2 + textSize / 2); // up
            gc.fillText(String.valueOf((char) (i + 'a' - 1)), i * CELL_SIZE - textSize / 2, CELL_SIZE * 9 - (float) OFFSET / 2 + textSize / 2); // down

            // Numbers
            gc.fillText(String.valueOf(9 - i), (float) OFFSET / 2 - textSize / 2, i * CELL_SIZE + textSize / 2); // left
            gc.fillText(String.valueOf(9 - i), OFFSET + CELL_SIZE * 8 + (float) OFFSET / 2 - textSize / 2, i * CELL_SIZE + textSize / 2); // right
        }
    }

    @Override
    public Command getInput() {
        return interpretInput();
    }

    /*******************************************************************************************************************
     * Interpreting user input to generate command
     * @return interpreted command
     ******************************************************************************************************************/
    private Command interpretInput() {
//        System.out.print("GameCommandType " + lastCmd.getCommandType() + "\nParams: ");
//        for(Object o : lastCmd.getParams()) System.out.print(o + "; ");
//        System.out.println();

        return lastCmd;
    }
}
