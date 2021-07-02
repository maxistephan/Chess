package de.hsa.maxist.chess.core.piece;

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
    public List<XY> possibleMoves(PieceContext view, XY xy) {
        return view.possibleMoves(this, xy);
    }

}
