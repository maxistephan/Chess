package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;

public class Queen extends Piece {
    public Queen(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'Q' : 'q';
    }

    @Override
    public Field[] getPossibleMoves() {
        return new Field[0];
    }

    @Override
    public void move(PieceContext view, Field destination) {

    }
}
