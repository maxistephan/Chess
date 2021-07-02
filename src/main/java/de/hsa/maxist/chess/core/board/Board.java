package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.Field;

public class Board {

    private Field[][] board = new Field[8][8];
    private final FlatBoard flatBoard;

    public Board(BoardCfg cfg) {
        addPieces(cfg.getForsythEdwards());
        flatBoard = new FlatBoard(board);
    }

    /*******************************************************************************************************************
     * Converts a FE-Noatation String into 2-Dimensional chess Field array
     * @param fen Forsyth Edward Notation of wanted board
     ******************************************************************************************************************/
    public void addPieces(String fen) {
        board = FenInterpreter.decode(fen);
    }

    /*******************************************************************************************************************
     * Get Board for Unit testing
     * @return 2-Dimansional Board Array
     ******************************************************************************************************************/
    public Field[][] getBoard() {
        return this.board;
    }

    /*******************************************************************************************************************
     * Converts the current Board array into a FlatBoard
     * @return FlatBoard of current board Array
     ******************************************************************************************************************/
    public FlatBoard flatten() {
        return flatBoard;
    }

}
