package de.hsa.maxist.chess.engine.ui;

import javafx.scene.image.Image;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Locale;

public enum SpriteLoader {

    KING,
    QUEEN,
    BISHOP,
    KNIGHT,
    ROOK,
    PAWN;

    private final Image[] sprites;

    SpriteLoader() {
        this.sprites = getImages();
    }

    /**
     * Get Sprite for desired chess figure from resources
     * @return Sprite Images for desired piece
     */
    private Image[] getImages() {
        Path p = FileSystems.getDefault().getPath("src", "main", "resources", "Images", name().toLowerCase(Locale.ENGLISH));
        File f = new File(p + "/0.png");
        File fi = new File(p + "/1.png");
        Image i = null;
        Image i2 = null;

        try(FileInputStream fis = new FileInputStream(f)) {
            i = new Image(fis);
        } catch(IOException e) {
            System.out.println("This file doesnt exist");
        }

        try(FileInputStream fis = new FileInputStream(fi)) {
            i2 = new Image(fis);
        } catch(IOException e) {
            System.out.println("This file doesnt exist");
        }
        return new Image[]{i, i2};
    }

    /**
     * Get Sprite for desired chess figure from resources
     * @param color color of the piece (0 = white, 1 = black)
     * @return Sprite Images for desired piece
     */
    public Image getSprite(int color) {
        return sprites[color];
    }
}
