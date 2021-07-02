package de.hsa.maxist.chess.engine.ui;

import de.hsa.maxist.chess.core.board.BoardView;
import de.hsa.maxist.chess.core.command.Command;

public interface UI {

    /*******************************************************************************************************************
     * Renders Board View
     * @param view BoardView for reference
     ******************************************************************************************************************/
    void draw(BoardView view);

    /*******************************************************************************************************************
     * Get User Input
     * @return Command entered by user
     ******************************************************************************************************************/
    Command getInput();

    /*******************************************************************************************************************
     * Displays a message on UI
     * @param message String to be displayed
     ******************************************************************************************************************/
    void message(String message);

}
