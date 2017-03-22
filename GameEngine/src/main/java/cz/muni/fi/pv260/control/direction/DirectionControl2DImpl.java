package cz.muni.fi.pv260.control.direction;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class DirectionControl2DImpl implements DirectionControl2D {

    private Direction currentDirection;

    public DirectionControl2DImpl(Direction startDirection) {
        this.currentDirection = startDirection;
    }

    @Override
    public void directRight() {
        setDirection(Direction.DIRECTION_RIGHT);
    }

    @Override
    public void directLeft() {
        setDirection(Direction.DIRECTION_LEFT);
    }

    @Override
    public void directUp() {
        setDirection(Direction.DIRECTION_UP);
    }

    @Override
    public void directDown() {
        setDirection(Direction.DIRECTION_DOWN);
    }

    @Override
    public Direction getDirection() {
        return this.currentDirection;
    }

    private void setDirection(Direction newDirection) {
        if (currentDirection != newDirection.getOppositeDirection()) {
            currentDirection = newDirection;
        }
    }
}
