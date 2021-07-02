package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.XY;

public class Rook extends Piece {
    public Rook(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'R' : 'r';
    }

    @Override
    public XY[] getPossibleMoves(PieceContext view) {
        return new XY[0];
    }
}
