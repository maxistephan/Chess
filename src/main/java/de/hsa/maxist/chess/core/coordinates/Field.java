package de.hsa.maxist.chess.core.coordinates;

import de.hsa.maxist.chess.core.piece.Piece;

import java.util.Optional;

public class Field {

    private Piece piece = null;

    public Field() {
        // EMPTY
    }

    /*******************************************************************************************************************
     * Reset the content of this Field
     ******************************************************************************************************************/
    public void reset() {
        this.piece = null;
    }

    public void setContent(Piece piece) {
        this.piece = piece;
    }

    /*******************************************************************************************************************
     * If there is a piece inside this container, it returns it as an optional. Instead its an empty optional
     * @return Optional value of contained Piece
     ******************************************************************************************************************/
    public Optional<Piece> getContent() {
        return this.piece == null ? Optional.empty() : Optional.of(this.piece);
    }
}
