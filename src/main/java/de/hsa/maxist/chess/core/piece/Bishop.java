package de.hsa.maxist.chess.core.piece;

public class Bishop extends Piece {
    public Bishop(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'B' : 'b';
    }
}
