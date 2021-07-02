package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.Field;

public class Board {

    private Field[][] board = new Field[8][8];

    public Board(BoardCfg cfg) {
        addPieces(cfg.getForsythEdwards());
    }

    public void addPieces(String fen) {
        board = FenInterpreter.decode(fen);
    }

    public Field[][] getBoard() {
        return this.board;
    }

    /*******************************************************************************************************************
     * Converts the current Board array into a FlatBoard
     * @return FlatBoard of current board Array
     ******************************************************************************************************************/
    public FlatBoard flatten() {
        return new FlatBoard(board);
    }

}
