package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;

public class Rook extends Piece {
    public Rook(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'R' : 'r';
    }

    @Override
    public Field[] getPossibleMoves() {
        return new Field[0];
    }

    @Override
    public void move(PieceContext view, Field destination) {
        view.tryMove(this, destination);
    }
}
