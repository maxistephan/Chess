package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.XY;

public class King extends Piece {
    public King(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'K' : 'k';
    }

    @Override
    public XY[] getPossibleMoves(PieceContext view) {
        return new XY[0];
    }
}
