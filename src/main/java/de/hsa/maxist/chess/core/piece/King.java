package de.hsa.maxist.chess.core.piece;

public class King extends Piece {
    public King(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'K' : 'k';
    }
}
