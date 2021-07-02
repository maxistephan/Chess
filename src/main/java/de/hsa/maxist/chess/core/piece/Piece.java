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
    /*******************************************************************************************************************
     * @return 0 or 1 as team
     ******************************************************************************************************************/

    public int getTeam() {
        return this.team;
    }

    /*******************************************************************************************************************
     * Get specific Forsyth Edwards Char for this piece
     * @return FEN char
     ******************************************************************************************************************/
    public abstract char getChar();

    /*******************************************************************************************************************
     * Compute all possibillities for this piece
     * @return Field Array of Possible moves for this Piece
     ******************************************************************************************************************/
    public abstract Field[] getPossibleMoves();

    /*******************************************************************************************************************
     * Moves the Piece to given Loaction, if its in the rules
     * @param view BoardView for reference
     * @param destination Destination Field
     ******************************************************************************************************************/
    public abstract void move(PieceContext view, Field destination);
}
