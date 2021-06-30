package de.hsa.maxist.chess.core.piece;

public class Pawn extends Piece {
    public Pawn(int team) {
        super(team);
    }

    @Override
    public char getChar() {
        return this.team == WHITE ? 'P' : 'p';
    }


}
