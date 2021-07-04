package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;

import java.util.List;

public class King extends Piece {

    private boolean moved = false;

    public King(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'K' : 'k';
    }

    @Override
    public List<Field> possibleMoves(PieceContext view, XY xy, int depth) {
        return view.possibleMoves(this, xy, depth);
    }

    public boolean isMoved() {
        return this.moved;
    }

    public void move() {
        moved = true;
    }

}
