package de.hsa.maxist.chess.core.piece;

import de.hsa.maxist.chess.core.coordinates.Field;

public interface PieceContext {

    /*******************************************************************************************************************
     * Try To move this King to its destination, observing the rules
     * @param king King to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(King king, Field dest);

    /*******************************************************************************************************************
     * Try To move this Queen to its destination, observing the rules
     * @param queen Queen to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Queen queen, Field dest);

    /*******************************************************************************************************************
     * Try To move this Bishop to its destination, observing the rules
     * @param bishop Bishop to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Bishop bishop, Field dest);

    /*******************************************************************************************************************
     * Try To move this Knight to its destination, observing the rules
     * @param knight Knight to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Knight knight, Field dest);

    /*******************************************************************************************************************
     * Try To move this Rook to its destination, observing the rules
     * @param rook Rook to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Rook rook, Field dest);

    /*******************************************************************************************************************
     * Try To move this Pawn to its destination, observing the rules
     * @param pawn Pawn to move
     * @param dest Deistionation Field
     ******************************************************************************************************************/
    void tryMove(Pawn pawn, Field dest);
}
