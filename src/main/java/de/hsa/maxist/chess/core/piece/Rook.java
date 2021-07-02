package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.XY;

import java.util.List;

public class Rook extends Piece {

    private boolean moved = false;

    public Rook(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'R' : 'r';
    }

    @Override
    public List<XY> possibleMoves(PieceContext view, XY xy) {
        return view.possibleMoves(this, xy);
    }

    public boolean isMoved() {
        return this.moved;
    }

    public void move() {
        moved = true;
    }
}
