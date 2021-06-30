package de.hsa.maxist.chess.core.piece;

public class Knight extends Piece {
    public Knight(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'N' : 'n';
    }
}
