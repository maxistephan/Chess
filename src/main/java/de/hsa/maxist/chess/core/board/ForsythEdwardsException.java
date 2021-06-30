package de.hsa.maxist.chess.core.board;

public class ForsythEdwardsException extends IllegalArgumentException {
    public ForsythEdwardsException() {
        super("String provided is not decodable.");
    }
}
