package de.hsa.maxist.chess.engine.ui;

import com.sun.javafx.scene.input.DragboardHelper;
import de.hsa.maxist.chess.core.board.BoardView;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.core.command.GameCommandType;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.Piece;
import de.hsa.maxist.chess.engine.Game;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;


public class FxUi extends Scene implements UI {

    private static int CELL_SIZE;
    private static int OFFSET;
    private static final Color BLACK = Color.rgb(243, 212, 183);
    private static final Color WHITE = Color.rgb(238, 156, 73);

    private XY dragging = null;
    private XY cursorPos = null;
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

        // --Keyboard events
        instance.setOnKeyPressed(e -> instance.lastCmd = new Command(GameCommandType.NONE));
        instance.setOnKeyReleased(e -> instance.lastCmd = new Command(GameCommandType.NONE));

        // --Mouse events
        // Drag start
        instance.setOnDragDetected(e -> {
            instance.lastCmd = new Command(
                    GameCommandType.CLICK,
                    XY.getBoardSpot(new XY((int) e.getX(), (int) e.getY()),
                            CELL_SIZE,
                            OFFSET));
            instance.dragging = XY.getBoardSpot(new XY((int) e.getX(), (int) e.getY()),
                    CELL_SIZE,
                    OFFSET);
            Dragboard dragBoard = instance.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("Wiilkommen zu meiner Schnitzeljagt! Sie haben das Erste Stück gefunden. Das nächste erwartet Sie schon!");
            dragBoard.setContent(content);
            instance.setCursor(Cursor.CLOSED_HAND);
        });
        // drag over
        instance.setOnDragOver(e -> {
            e.acceptTransferModes(TransferMode.ANY);
            instance.setCursor(Cursor.CLOSED_HAND);
            instance.cursorPos = new XY((int) e.getX(), (int)e.getY());
        });
        // drop
        instance.setOnDragDropped(e -> {
            instance.lastCmd = new Command(GameCommandType.CLICK, XY.getBoardSpot(
                    new XY((int)e.getX(), (int)e.getY()),
                    CELL_SIZE,
                    OFFSET));
            instance.dragging = null;
            instance.setCursor(Cursor.DEFAULT);
            e.consume();
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
                if(piece != null) {
                    if(dragging != null && cursorPos != null && i == dragging.x && j == dragging.y) {
                        gc.setFill(Color.rgb(50, 50, 50, 0.5));
                        gc.fillText(String.valueOf(piece.getChar()), cursorPos.x + 5, cursorPos.y - 5); // Shadow
                        gc.setFill(Color.rgb(0, 0, 0, 1));
                        gc.fillText(String.valueOf(piece.getChar()), cursorPos.x, cursorPos.y); // Dragged Piece
                    } else
                        gc.fillText(String.valueOf(piece.getChar()), i * CELL_SIZE + OFFSET, (j + 1) * CELL_SIZE + OFFSET); // Other Pieces
                }
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
        Command returnedCmd = lastCmd;
        lastCmd = new Command(GameCommandType.NONE);
        return returnedCmd;
    }
}
