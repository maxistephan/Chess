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

    public FlatBoard flatten() {
        return new FlatBoard(board);
    }

}
