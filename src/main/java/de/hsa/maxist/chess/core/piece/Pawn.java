package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.XY;

public class Pawn extends Piece {
    public Pawn(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'P' : 'p';
    }

    @Override
    public XY[] getPossibleMoves(PieceContext view) {
        return new XY[0];
    }
}
