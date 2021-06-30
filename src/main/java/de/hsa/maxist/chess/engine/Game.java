package de.hsa.maxist.chess.engine;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.engine.ui.UI;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {

    private final UI ui;
    private final long FPS = 25;
    private final State state;

    public Game(Board board, UI ui){
        this.ui = ui;
        this.state = new State(ui, board);
    }

    public void run() {
        draw();
        processInput();
        update();
    }

    private void draw() {
        ui.draw(state.flatBoard());
    }

    private void processInput() {
        Command command = ui.getInput();
    }

    private void update() {
        state.update();
    }
}
