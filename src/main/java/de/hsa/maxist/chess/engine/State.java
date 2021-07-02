package de.hsa.maxist.chess.engine;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.board.FlatBoard;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.core.command.GameCommandType;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.engine.ui.UI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class State {

    private final FlatBoard flatBoard;
    private final UI ui;

    public State(UI ui, Board board) {
        this.ui = ui;
        this.flatBoard = board.flatten();
    }

    /*******************************************************************************************************************
     * Updates State, hence Flatboard, BoardView and PieceContext
     ******************************************************************************************************************/
    public void update(Command command) {
        GameCommandType commandType = command.getCommandType();
        System.out.println(commandType);
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
     * Get Flattened Board
     * @return Flatboard
     ******************************************************************************************************************/
    public FlatBoard flatBoard() {
        return flatBoard;
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
        ui.message("Moved");
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
