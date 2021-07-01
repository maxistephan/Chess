package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;

public class King extends Piece {
    public King(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'K' : 'k';
    }

    @Override
    public Field[] getPossibleMoves() {
        return new Field[0];
    }

    @Override
    public void move(PieceContext view, Field destination) {

    }
}
