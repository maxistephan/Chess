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
    public void clickOn(XY clicked) {
        Field field = fieldAt(clicked);

        // if none selected
        if(selectedField == null) {
            if(field.getContent().isPresent())
                selectedField = field;
        } else {
            // wanting to move
            if(possibleMoves.contains(clicked)) {
                move(selectedField, field);
                selectedField = null;
            // wanting to select another piece
            } else if(field.getContent().isPresent()) {
                selectedField = selectedField == field
                        ? null // deselect piece
                        : field; // select piece
            // wanting to deselect piece
            } else {
                selectedField = null; // deselect Piece
            }
        }

        // configure possible moves
        if(selectedField != null)
            selectedField.getContent().ifPresent(
                    current -> possibleMoves = current.possibleMoves(this, clicked)
            );
    }

    @Override
    public List<XY> possibleMoves(King king, XY position) {
        return new ArrayList<>();
    }

    @Override
    public List<XY> possibleMoves(Queen queen, XY position) {
        return new ArrayList<>();
    }

    @Override
    public List<XY> possibleMoves(Bishop bishop, XY position) {
        return new ArrayList<>();
    }

    @Override
    public List<XY> possibleMoves(Knight knight, XY position) {
        return new ArrayList<>();
    }

    @Override
    public List<XY> possibleMoves(Rook rook, XY position) {
        return new ArrayList<>();
    }

    @Override
    public List<XY> possibleMoves(Pawn pawn, XY position) {
        return new ArrayList<>();
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
            start.reset(); // remove piece from old Field
            field.setContent(piece); // set Piece at new Field
        });
    }

    /*******************************************************************************************************************
     * Add a chess piece to the removed ones
     * @param piece the Piece to remove
     ******************************************************************************************************************/
    private void remove(Piece piece) {
        removed.add(piece);
    }
}
