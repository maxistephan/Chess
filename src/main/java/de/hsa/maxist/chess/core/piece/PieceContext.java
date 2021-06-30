package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.XY;

public interface PieceContext {

    void tryMove(King king, XY dest);

    void tryMove(Queen queen, XY dest);

    void tryMove(Bishop bishop, XY dest);

    void tryMove(Knight knight, XY dest);

    void tryMove(Rook rook, XY dest);

    void tryMove(Pawn pawn, XY dest);

}
