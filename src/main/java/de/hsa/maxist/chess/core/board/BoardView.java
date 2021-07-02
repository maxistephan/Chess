package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.Piece;

public interface BoardView {

    /*******************************************************************************************************************
     * Get Piece at position
     * @param field position (e.g. 0/0 for top left, 8/8 for bottom right)
     * @return Piece at position
     ******************************************************************************************************************/
    Piece getPieceAt(XY field);

}
