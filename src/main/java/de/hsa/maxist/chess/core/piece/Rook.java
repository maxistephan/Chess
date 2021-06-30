package de.hsa.maxist.chess.core.piece;

public class Rook extends Piece {
    public Rook(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'R' : 'r';
    }
}
