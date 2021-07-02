package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;

public interface PieceContext {

    /*******************************************************************************************************************
     * Get Field at position
     * @param xy position (e.g. 0/0 for top left, 7/7 for bottom right)
     * @return Field at position
     ******************************************************************************************************************/
    Field fieldAt(XY xy);

    /*******************************************************************************************************************
     * Find out if the Field at a certain position is empty or not
     * @param xy Field to be tested
     * @return bool value of field being empty or not
     ******************************************************************************************************************/
    boolean isEmpty(XY xy);

    /*******************************************************************************************************************
     * Get Piece at position
     * @param xy position (e.g. 0/0 for top left, 8/8 for bottom right)
     * @return Piece at position
     ******************************************************************************************************************/
    Piece getPieceAt(XY xy);

    /*******************************************************************************************************************
     * Clicking on any Field triggers an action. Clicking on chess pieces display their possible moves, nothingness
     * makes the display of shown possibillities disappear and possible move options move the piece to its new location
     * @param field The chess Board coordinate clicked on
     ******************************************************************************************************************/
    void clickOn(XY field);
}
