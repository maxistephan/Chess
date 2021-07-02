package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.XY;

public class Bishop extends Piece {
    public Bishop(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'B' : 'b';
    }

    @Override
    public XY[] getPossibleMoves(PieceContext view) {
        return new XY[0];
    }
}
