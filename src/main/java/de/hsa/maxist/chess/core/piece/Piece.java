package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;

public abstract class Piece {

    public static final int WHITE = 0;
    public static final int BLACK = 1;

    protected final int team;

    public Piece(int team) {
        if(team == WHITE || team == BLACK) {
            this.team = team;
        } else {
            this.team = 0;
            throw new IllegalArgumentException(team + " is not a valid team. Only 0 and 1 are available.");
        }
    }

    public int getTeam() {
        return this.team;
    }

    public abstract char getChar();

    public abstract Field[] getPossibleMoves();

    public abstract void move(PieceContext view, Field destination);
}
