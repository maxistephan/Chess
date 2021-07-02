package de.hsa.maxist.chess.engine;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.board.FlatBoard;
import de.hsa.maxist.chess.engine.ui.UI;

public class State {

    private final FlatBoard flatBoard;
    private final UI ui;

    public State(UI ui, Board board) {
        this.ui = ui;
        this.flatBoard = board.flatten();
    }

    /*******************************************************************************************************************
     * Updates State, -> thus Flatboard, BoardView and PieceContext
     ******************************************************************************************************************/
    public void update() {

    }

    public FlatBoard flatBoard() {
        return flatBoard;
    }

}
