package de.hsa.maxist.chess.engine;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.engine.ui.UI;

import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {

    private final UI ui;
    private final long FPS = 25;
    private final State state;

    public Game(Board board, UI ui){
        this.ui = ui;
        this.state = new State(ui, board);
        this.run();
    }

    private void run() {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

        executor.scheduleAtFixedRate(() -> {
            draw();
            processInput();
            update();
        }, 0, FPS/1000, TimeUnit.MILLISECONDS);
    }

    private void draw() {
        ui.draw();
    }

    private void processInput() {
        Command command = ui.getInput();
    }

    private void update() {
        state.update();
    }
}
