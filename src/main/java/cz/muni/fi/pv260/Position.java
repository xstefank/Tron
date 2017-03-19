package cz.muni.fi.pv260;

/**
 * Created by Marek on 19.3.2017.
 */
public class Position {
    private int coordinateX;
    private int coordinateY;

    public Position(int coordinateX, int coordinateY) {
        setCoordinates(coordinateX, coordinateY);
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinates(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public void moveCoordinates(int amountX, int amountY){
        coordinateX += amountX;
        coordinateY += amountY;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position){
            if(((Position) obj).coordinateX == coordinateX &&
                    ((Position) obj).coordinateY == coordinateY){
                return true;
            }
        }
        return false;
    }
}

