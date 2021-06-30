package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.*;

import java.util.Locale;

public class FlatBoard implements BoardView, PieceContext {

    private Field[] flatboard = new Field[64];

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

    @Override
    public PieceType getPieceTypeAt(XY field) {
        if(flatboard[field.x + 8 * field.y].getContent().isPresent()) {
            String type = flatboard[field.x + 8 * field.y].getContent().get().getClass().getSimpleName();
            return PieceType.valueOf(type.toUpperCase(Locale.ENGLISH));
        } else {
            return PieceType.NONE;
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
}
