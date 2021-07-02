package de.hsa.maxist.chess.engine;

import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.command.Command;
import de.hsa.maxist.chess.core.command.GameCommandType;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.Piece;
import de.hsa.maxist.chess.engine.ui.UI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Game {

    private final UI ui;
    private final long FPS = 25;
    private final State state;
    private Command userCmd;

    public Game(Board board, UI ui){
        this.ui = ui;
        this.state = new State(ui, board);
    }

    /*******************************************************************************************************************
     * Main-Gameloop
     ******************************************************************************************************************/
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

    /*******************************************************************************************************************
     * Render
     ******************************************************************************************************************/
    private void draw() {
        ui.draw(state.flatBoard());
    }

    /*******************************************************************************************************************
     * Processes User-Input
     ******************************************************************************************************************/
    private void processInput() {
        userCmd = ui.getInput();
    }

    /*******************************************************************************************************************
     * Update State
     ******************************************************************************************************************/
    private void update() {
        state.update(userCmd);
    }
}
