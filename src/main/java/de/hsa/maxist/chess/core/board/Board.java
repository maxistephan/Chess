package de.hsa.maxist.chess.core.board;

import com.sun.javafx.UnmodifiableArrayList;
import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.piece.Piece;

import java.util.ArrayList;

public class Board {

    private Field[][] board = new Field[8][8];
    private final FlatBoard flatBoard;
    private final ArrayList<Piece> whitePieces = new ArrayList<>(16);
    private final ArrayList<Piece> blackPieces = new ArrayList<>(16);

    public Board(BoardCfg cfg) {
        addPieces(cfg.getForsythEdwards());
        flatBoard = new FlatBoard(this);
    }

    /*******************************************************************************************************************
     * Converts a FE-Noatation String into 2-Dimensional chess Field array
     * @param fen Forsyth Edward Notation of wanted board
     ******************************************************************************************************************/
    public void addPieces(String fen) {
        board = FenInterpreter.decode(fen);
        for(Field[] row : board) {
            for(Field field : row) {
                if(field.getContent().isPresent()) {
                    switch(field.getContent().get().getTeam()) {
                        case Piece.WHITE: whitePieces.add(field.getContent().get());
                        case Piece.BLACK: blackPieces.add(field.getContent().get());
                    }
                }
            }
        }
    }

    /*******************************************************************************************************************
     * Get a list of either all white or all black pieces
     * @param team color of the pieces (0 = white, 1 = black)
     * @return desired List of Pieces
     ******************************************************************************************************************/
    public ArrayList<Piece> getPieces(int team) {
        return team == Piece.WHITE ? whitePieces : blackPieces;
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
