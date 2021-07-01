package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.Piece;

public interface BoardView {

    Piece getPieceAt(XY field);

}
