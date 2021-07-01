package de.hsa.maxist.chess.core.command;

public class Command {

    public static final Command NONE = new Command(GameCommandType.NONE);

    private final GameCommandType commandType;
    private final Object[] params;

    public Command(GameCommandType commandType, Object... params) {
        this.commandType = commandType;
        this.params = params;
    }

    public GameCommandType getCommandType() {
        return commandType;
    }

    public Object[] getParams() {
        return params;
    }
}
