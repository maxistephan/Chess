import de.hsa.maxist.chess.core.board.Board;
import de.hsa.maxist.chess.core.board.BoardCfg;
import static org.junit.Assert.*;

import de.hsa.maxist.chess.core.board.FenInterpreter;
import de.hsa.maxist.chess.core.board.FlatBoard;
import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.coordinates.XY;
import de.hsa.maxist.chess.core.piece.PieceType;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {

    @Before
    public void init() {
    }

    @Test
    public void configTest() {
        // default
        BoardCfg boardCfg = new BoardCfg(null);
        assertEquals(FenInterpreter.DEFAULT_FEN, boardCfg.getForsythEdwards());

        // custom config
        BoardCfg custom = new BoardCfg("checkmate-1");
        assertEquals("rnbqkbnr/2pppQpp/p6p/1p6/2B1P3/8/PPPP1PPP/RNB1K1NR", custom.getForsythEdwards());

        // nonexistent config should return default
        BoardCfg nonexistend = new BoardCfg("öajlsbdfßü");
        assertEquals(FenInterpreter.DEFAULT_FEN, nonexistend.getForsythEdwards());
    }

    @Test
    public void flatBoardTest() {
        FlatBoard fb = new Board(new BoardCfg(null)).flatten();

        // PAWNS
        for(int i = 0; i < 8; i++) {
            for(int j = 1; j < 8; j += 5) {
                assertEquals(PieceType.PAWN, fb.getPieceTypeAt(new XY(i, j)));
            }
        }

        // ROOKS
        for(int i = 0; i < 8; i += 7) {
            for(int j = 0; j < 7; j += 7) {
                assertEquals(PieceType.ROOK, fb.getPieceTypeAt(new XY(i, j)));
            }
        }

        // NONE
        for(int i = 0; i < 8; i++) {
            for(int j = 2; j < 6; j++) {
                assertEquals(PieceType.NONE, fb.getPieceTypeAt(new XY(i, j)));
            }
        }

        Field[] flatboard = fb.getFlatboard();
        assertEquals(64, flatboard.length);

        for(Field f : flatboard) {
            f.reset();
            assertFalse(f.getContent().isPresent());
        }
    }

}
