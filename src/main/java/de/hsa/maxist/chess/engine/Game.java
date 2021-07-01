package de.hsa.maxist.chess.engine;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.engine.ui.UI;

import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private final UI ui;
    private final long FPS = 25;
    private final State state;

    public Game(Board board, UI ui){
        this.ui = ui;
        this.state = new State(ui, board);
    }

    public void run() {
        new Timer("GameThread").scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                draw();
                processInput();
                update();
            }
        }, 100, (long) (1000f / FPS));
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
