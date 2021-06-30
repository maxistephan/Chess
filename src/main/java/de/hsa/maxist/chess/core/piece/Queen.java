package de.hsa.maxist.chess.core.piece;

public class Queen extends Piece {
    public Queen(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'Q' : 'q';
    }
}
