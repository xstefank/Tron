package cz.muni.fi.pv260.control.collision;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class Point {
    private int coordinateX;
    private int coordinateY;

    public Point(int coordinateX, int coordinateY) {
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
        if(obj instanceof Point){
            if(((Point) obj).coordinateX == coordinateX && ((Point) obj).coordinateY == coordinateY){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = coordinateX;
        result = 31 * result + coordinateY;
        return result;
    }
}
