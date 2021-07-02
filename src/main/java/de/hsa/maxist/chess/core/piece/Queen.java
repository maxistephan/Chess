package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;

public class Queen extends Piece {
    public Queen(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'Q' : 'q';
    }

    @Override
    public XY[] getPossibleMoves(PieceContext view) {
        return new XY[0];
    }

    @Override
    public void move(PieceContext view, XY destination) {

    }
}
