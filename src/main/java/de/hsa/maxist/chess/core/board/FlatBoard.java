package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.*;

import java.util.*;
import java.util.function.Consumer;

public class FlatBoard implements BoardView, PieceContext {

    private Field[] flatboard = new Field[64];
    private final Board board;
    private List<Field> possibleMoves = new ArrayList<>();
    private Field selectedField = null;
    private List<Piece> removed = new ArrayList<>();

    boolean[] check = new boolean[]{false, false};

    public FlatBoard(Board board) {
        this.board = board;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                flatboard[i + 8 * j] = board.getBoard()[j][i];
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
            if(possibleMoves.contains(clicked) || true) {
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
            selectedField.getContent().ifPresentOrElse(
                    current -> possibleMoves = current.possibleMoves(this, clicked, 2), // if
                    () -> possibleMoves = new ArrayList<>()                                         // else
            );
    }

    @Override
    public List<Field> possibleMoves(King king, XY position, int depth) {
        if(depth == 0)
            return new ArrayList<>();
        return new ArrayList<>();
    }

    @Override
    public List<Field> possibleMoves(Queen queen, XY position, int depth) {

        ArrayList<Field> moves = new ArrayList<>();
        if(depth == 0)
            return moves;

        if(check[queen.getTeam()])

        // upper half
        for(int j = 7; j < 10; j++) {
            for (int i = position.x + 8 * position.y; i < 64; i += j) {
                if (flatboard[i].getContent().isPresent()) {
                    if (flatboard[i].getContent().get().getTeam() != queen.getTeam())
                        moves.add(flatboard[i]);
                    break;
                }
            }
        }

        // lower half
        for(int j = 7; j < 10; j++) {
            for (int i = position.x + 8 * position.y; i > 0; i -= j) {
                if (flatboard[i].getContent().isPresent()) {
                    if (flatboard[i].getContent().get().getTeam() != queen.getTeam())
                        moves.add(flatboard[i]);
                    break;
                }
            }
        }

        return moves;
    }

    @Override
    public List<Field> possibleMoves(Bishop bishop, XY position, int depth) {
        if(depth == 0)
            return new ArrayList<>();
        return new ArrayList<>();
    }

    @Override
    public List<Field> possibleMoves(Knight knight, XY position, int depth) {
        if(depth == 0)
            return new ArrayList<>();
        return new ArrayList<>();
    }

    @Override
    public List<Field> possibleMoves(Rook rook, XY position, int depth) {
        if(depth == 0)
            return new ArrayList<>();
        return new ArrayList<>();
    }

    @Override
    public List<Field> possibleMoves(Pawn pawn, XY position, int depth) {
        int dir = pawn.getTeam() == Piece.WHITE ? 1 : -1;
        if(depth == 0)
            return new ArrayList<>();
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
