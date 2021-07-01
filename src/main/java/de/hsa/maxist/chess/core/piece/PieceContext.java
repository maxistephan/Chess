package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;

public interface PieceContext {

    void tryMove(King king, Field dest);

    void tryMove(Queen queen, Field dest);

    void tryMove(Bishop bishop, Field dest);

    void tryMove(Knight knight, Field dest);

    void tryMove(Rook rook, Field dest);

    void tryMove(Pawn pawn, Field dest);
}
