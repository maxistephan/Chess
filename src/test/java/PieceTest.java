import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.board.BoardCfg;
import de.hsa.maxist.chess.core.board.FlatBoard;

import org.junit.Test;

public class PieceTest {

    @Test
    public void moveTest() {
        Board board = new Board(new BoardCfg(null));
        FlatBoard flatBoard = board.flatten();
    }

    @Test
    public void possibleMovesTest() {

    }

}
