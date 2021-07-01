package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;

public class Pawn extends Piece {
    public Pawn(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'P' : 'p';
    }

    @Override
    public Field[] getPossibleMoves() {
        return new Field[0];
    }

    @Override
    public void move(PieceContext view, Field destination) {

    }


}
