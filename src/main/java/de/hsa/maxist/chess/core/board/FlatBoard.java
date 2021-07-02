package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FlatBoard implements BoardView, PieceContext {

    private Field[] flatboard = new Field[64];
    private List<XY> possibleMoves = new ArrayList<>();
    private Piece selectedPiece = null;

    public FlatBoard(Field[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                flatboard[i + board[0].length * j] = board[j][i];
            }
        }
    }

    public Field[] getFlatboard() {
        return this.flatboard;
    }

    /*******************************************************************************************************************
     * Compute matching field in chess flatboard to coordinate
     * @param at Coordinate of Field
     * @return Field at given position
     ******************************************************************************************************************/
    private Field getFieldAt(XY at) {
        return flatboard[at.x + 8 * at.y];
    }

    @Override
    public Piece getPieceAt(XY field) {
        if(flatboard[field.x + 8 * field.y].getContent().isPresent()) {
            return flatboard[field.x + 8 * field.y].getContent().get();
        } else {
            return null;
        }
    }

    @Override
    public void tryMove(King king, XY dest) {

    }

    @Override
    public void tryMove(Queen queen, XY dest) {

    }

    @Override
    public void tryMove(Bishop bishop, XY dest) {

    }

    @Override
    public void tryMove(Knight knight, XY dest) {

    }

    @Override
    public void tryMove(Rook rook, XY dest) {

    }

    @Override
    public void tryMove(Pawn pawn, XY dest) {

    }

    @Override
    public void clickOn(XY field) {
        Field clicked = flatboard[field.x + 8 * field.y];

        // if none selected
        if(selectedPiece == null) {
            if(clicked.getContent().isPresent())
                selectedPiece = clicked.getContent().get();
        } else {
            // if wanting to move
            if(possibleMoves.contains(field)) {
                selectedPiece.move(this, field); // move
            // if wanting to select another piece
            } else if(clicked.getContent().isPresent()) {
                selectedPiece = selectedPiece == clicked.getContent().get()
                        ? null // deselect piece
                        : clicked.getContent().get(); // select piece
            } else {
                selectedPiece = null; // deselect Piece
            }
        }

        possibleMoves = selectedPiece == null
                ? new ArrayList<>()
                : Arrays.asList(selectedPiece.getPossibleMoves(this));
    }
}
