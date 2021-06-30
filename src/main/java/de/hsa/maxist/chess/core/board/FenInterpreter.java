package de.hsa.maxist.chess.core.board;

import de.hsa.maxist.chess.core.coordinates.Field;
import de.hsa.maxist.chess.core.piece.*;

import static de.hsa.maxist.chess.core.piece.Piece.BLACK;
import static de.hsa.maxist.chess.core.piece.Piece.WHITE;

public class FenInterpreter {

    public static final String DEFAULT_FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";

    public static Field[][] decode(String fen) {

        Field[][] board = new Field[8][8];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = new Field();
            }
        }

        int index = 0;
        int row = 0;
        for(int i = 0; i < fen.length(); i++) {
            char current = fen.charAt(i);

            Piece next = null;
            switch(current) {
                case 'k', 'K' -> next = new King(current - 'k' == 0 ? BLACK : WHITE);
                case 'q', 'Q' -> next = new Queen(current - 'q' == 0 ? BLACK : WHITE);
                case 'b', 'B' -> next = new Bishop(current - 'b' == 0 ? BLACK : WHITE);
                case 'n', 'N' -> next = new Knight(current - 'n' == 0 ? BLACK : WHITE);
                case 'r', 'R' -> next = new Rook(current - 'r' == 0 ? BLACK : WHITE);
                case 'p', 'P' -> next = new Pawn(current - 'p' == 0 ? BLACK : WHITE);
                case '/' -> {
                    index = 0;
                    row++;
                    continue;
                }
                default -> {
                    int offset = current - '0';
                    if(offset < 1 || 8 < offset) {
                        throw new ForsythEdwardsException();
                    } else {
                        index += offset;
                        continue;
                    }
                }
            }
            board[row][index].setContent(next);
            index++;
        }
        return board;
    }

    public static String encode(Field[] board) {
        return null;
    }

}
