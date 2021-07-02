package de.hsa.maxist.chess.engine;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.core.command.GameCommandType;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.Piece;
import de.hsa.maxist.chess.engine.ui.UI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private final UI ui;
    private final long FPS = 25;
    private final State state;

    private Piece selectedPiece = null;

    public Game(Board board, UI ui){
        this.ui = ui;
        this.state = new State(ui, board);
    }

    public void run() {
        new Timer("GameThread").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                draw();
                processInput();
                update();
            }
        }, 100, (long) (1000f / FPS));
    }

    private void draw() {
        ui.draw(state.flatBoard());
    }

    /*******************************************************************************************************************
     * Processes User-Input
     ******************************************************************************************************************/
    private void processInput() {
        Command command = ui.getInput();
        GameCommandType commandType = command.getCommandType();
        if(commandType == GameCommandType.NONE) return;

        Object[] params = command.getParams();
        Class<?>[] paramTypes = new Class[params.length];
        for(int i = 0; i < params.length; i++) {
            paramTypes[i] = params[i].getClass();
        }

        try {
            Method m = getClass().getDeclaredMethod(commandType.name().toLowerCase(Locale.ENGLISH), paramTypes);
            m.invoke(this, params);
        } catch(NoSuchMethodException | SecurityException | InvocationTargetException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /*******************************************************************************************************************
     * Update State
     ******************************************************************************************************************/
    private void update() {
        state.update();
    }

    /*******************************************************************************************************************
     * Drag the Piece on the field with given coordinates
     * @param field Coordinates of the dragged field
     ******************************************************************************************************************/
    private void drag(XY field) {

    }

    /*******************************************************************************************************************
     * Drop the currently dragged Piece off at current location
     * @param field Coordinates of the end field
     ******************************************************************************************************************/
    private void drop(XY field) {

    }

    /*******************************************************************************************************************
     * Choose a Piece to select, or drop off a selected field
     * @param field Coordinates of the clicked field
     ******************************************************************************************************************/
    private void click(XY field) {

    }

    /*******************************************************************************************************************
     * Open the pause menu
     ******************************************************************************************************************/
    private void pause() {

    }

}
