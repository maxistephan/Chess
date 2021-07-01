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
    public void tryMove(King king, Field dest) {

    }

    @Override
    public void tryMove(Queen queen, Field dest) {

    }

    @Override
    public void tryMove(Bishop bishop, Field dest) {

    }

    @Override
    public void tryMove(Knight knight, Field dest) {

    }

    @Override
    public void tryMove(Rook rook, Field dest) {

    }

    @Override
    public void tryMove(Pawn pawn, Field dest) {

    }
}
