package de.hsa.maxist.chess.engine.ui;

import de.hsa.maxist.chess.core.board.BoardView;
import de.hsa.maxist.chess.core.command.Command;

public interface UI {

    void draw(BoardView view);

    Command getInput();

}
