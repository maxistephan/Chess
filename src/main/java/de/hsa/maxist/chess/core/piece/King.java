package de.hsa.maxist.chess.core.piece;

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
