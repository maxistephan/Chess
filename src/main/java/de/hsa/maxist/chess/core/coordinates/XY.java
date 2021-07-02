package de.hsa.maxist.chess.core.coordinates;

public final class XY {

    public final int x;
    public final int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /*******************************************************************************************************************
     * Adds this with another vector
     * @param a vector to add to this
     * @return addition of this + a
     ******************************************************************************************************************/
    public XY plus(XY a) {
        return new XY(a.x + x, a.y + y);
    }

    /*******************************************************************************************************************
     * Subtracts the given vector from this
     * @param a vector to be substracted from this
     * @return subtraction of this - a
     ******************************************************************************************************************/
    public XY minus(XY a) {
        return new XY(x - a.x, y - a.y);
    }

    /*******************************************************************************************************************
     * Negates the current values
     * @return negated vector of this
     ******************************************************************************************************************/
    public XY negate() {
        return new XY(-x, -y);
    }

    /*******************************************************************************************************************
     * Computes the Spot of the field clicked from raw coordinates
     * @param clicked the coordinates of the mouse clicked event
     * @param cellSize size of one chess square
     * @param offset offset from the top left corner
     * @return position on Board
     ******************************************************************************************************************/
    public static XY getBoardSpot(XY clicked, int cellSize, int offset) {
        return new XY((clicked.x - offset) / cellSize, (clicked.y - offset) / cellSize);
    }

    @Override
    public String toString() {
        return String.format("X: %d, Y: %d", x, y);
    }
}
