package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.PieceType;

public interface BoardView {

    PieceType getPieceTypeAt(XY field);

}
