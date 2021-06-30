package de.hsa.maxist.chess.core.coordinates;

import de.hsa.maxist.chess.core.piece.Piece;

import java.util.Optional;

public class Field {

    private Piece piece = null;

    public Field() {
        // EMPTY
    }

    public void reset() {
        this.piece = null;
    }

    public void setContent(Piece piece) {
        this.piece = piece;
    }

    public Optional<Piece> getContent() {
        return this.piece == null ? Optional.empty() : Optional.of(this.piece);
    }
}
