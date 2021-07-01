package de.hsa.maxist.chess.core.command;

public enum GameCommandType {
    NONE(),
    MOVE(),
    CLICK(),
    DRAG(),
    DROP();

    GameCommandType() {

    }
}
