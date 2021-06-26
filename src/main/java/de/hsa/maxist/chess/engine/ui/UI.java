package de.hsa.maxist.chess.engine.ui;

import de.hsa.maxist.chess.core.command.Command;

public interface UI {

    void draw();

    Command getInput();

}
