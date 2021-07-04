package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;

import java.util.List;

public class Queen extends Piece {
    public Queen(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'Q' : 'q';
    }

    @Override
    public List<Field> possibleMoves(PieceContext view, XY xy, int depth) {
        return view.possibleMoves(this, xy, depth);
    }

}
