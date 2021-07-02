package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.*;

import java.util.*;
import java.util.function.Consumer;

public class FlatBoard implements BoardView, PieceContext {

    private Field[] flatboard = new Field[64];
    private List<XY> possibleMoves = new ArrayList<>();
    private Field selectedField = null;
    private List<Piece> removed = new ArrayList<>();

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
        if(fieldAt(field).getContent().isPresent()) {
            return fieldAt(field).getContent().get();
        } else {
            return null;
        }
    }

    @Override
    public Field fieldAt(XY xy) {
        return flatboard[xy.x + xy.y * 8];
    }

    @Override
    public boolean isEmpty(XY xy) {
        return getFieldAt(xy).getContent().isEmpty();
    }

    @Override
    public void clickOn(XY field) {
        Field clicked = fieldAt(field);

        // if none selected
        if(selectedField == null) {
            if(clicked.getContent().isPresent())
                selectedField = clicked;
        } else {
            // wanting to move
            if(possibleMoves.contains(field) || true) {
                move(selectedField, clicked);
                selectedField = null;
            // wanting to select another piece
            } else if(clicked.getContent().isPresent()) {
                selectedField = selectedField == clicked
                        ? null // deselect piece
                        : clicked; // select piece
            // wanting to deselect piece
            } else {
                selectedField = null; // deselect Piece
            }
        }

        // configure possible moves
        if(selectedField != null)
            selectedField.getContent().ifPresent(
                    current -> possibleMoves = Arrays.asList(current.getPossibleMoves(this))
            );
    }

    /*******************************************************************************************************************
     * Move a piece on the chess board
     * @param start Field with the Piece to move
     * @param field the field to move the piece to
     ******************************************************************************************************************/
    private void move(Field start, Field field) {
        start.getContent().ifPresent(piece -> {
            if (field.getContent().isPresent())
                remove(start.getContent().get());
            start.reset();
            field.setContent(piece);
        });
    }

    /*******************************************************************************************************************
     * Remove a piece from board
     * @param piece the Piece to remove
     ******************************************************************************************************************/
    private void remove(Piece piece) {
        removed.add(piece);
    }
}
