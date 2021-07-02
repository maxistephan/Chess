package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;

public interface PieceContext {

    /*******************************************************************************************************************
     * Try To move this King to its destination, observing the rules
     * @param king King to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(King king, XY dest);

    /*******************************************************************************************************************
     * Try To move this Queen to its destination, observing the rules
     * @param queen Queen to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Queen queen, XY dest);

    /*******************************************************************************************************************
     * Try To move this Bishop to its destination, observing the rules
     * @param bishop Bishop to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Bishop bishop, XY dest);

    /*******************************************************************************************************************
     * Try To move this Knight to its destination, observing the rules
     * @param knight Knight to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Knight knight, XY dest);

    /*******************************************************************************************************************
     * Try To move this Rook to its destination, observing the rules
     * @param rook Rook to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Rook rook, XY dest);

    /*******************************************************************************************************************
     * Try To move this Pawn to its destination, observing the rules
     * @param pawn Pawn to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Pawn pawn, XY dest);

    /*******************************************************************************************************************
     * Clicking on any Field triggers an action. Clicking on chess pieces display their possible moves, nothingness
     * makes the display of shown possibillities disappear and possible move options move the piece to its new location
     * @param field The chess Board coordinate clicked on
     ******************************************************************************************************************/
    void clickOn(XY field);
}
