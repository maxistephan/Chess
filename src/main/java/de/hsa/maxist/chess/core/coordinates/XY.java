package de.hsa.maxist.chess.core.coordinates;

public final class XY {

    public final int x;
    public final int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("X: %d, Y: %d", x, y);
    }

}
