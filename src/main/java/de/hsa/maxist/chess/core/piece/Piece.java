package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.XY;

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
     * @param view Piece Context for references
     * @return Coordinate Array of Possible moves for this Piece
     ******************************************************************************************************************/
    public abstract XY[] getPossibleMoves(PieceContext view);
}
