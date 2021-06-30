package de.hsa.maxist.chess.core.board;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class BoardCfg {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final String forsythEdwards;

    /*******************************************************************************************************************
     * Setup a new Board
     * @param boardName The name of the board configuration in json file "BoardConfig.json"
     ******************************************************************************************************************/
    public BoardCfg(@Nullable String boardName) {
        boardName = boardName == null ? "default" : boardName;


        String temp = "";
        Path filePath = FileSystems.getDefault().getPath("BoardConfig.json");
        try(InputStream is = Files.newInputStream(filePath)) {
            var boardNode = MAPPER.readTree(is).path(boardName);
            var fen = boardNode.path("fen");
            temp = fen.asText().isBlank() ? FenInterpreter.DEFAULT_FEN : fen.asText();
        } catch (IOException e) {
            temp = FenInterpreter.DEFAULT_FEN;
            System.out.println("Something went wrong reading the BoardConfig file. Using default board setup.");
            e.printStackTrace();
        }
        forsythEdwards = temp;
    }

    /*******************************************************************************************************************
     * Getter function for forsythEdwards
     * @return Forsyth-Edwards-Notation of board configuration
     ******************************************************************************************************************/
    public String getForsythEdwards() {
        return forsythEdwards;
    }
}
