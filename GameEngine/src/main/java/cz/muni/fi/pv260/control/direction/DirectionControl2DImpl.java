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
        setDirection(Direction.RIGHT);
    }

    @Override
    public void directLeft() {
        setDirection(Direction.LEFT);
    }

    @Override
    public void directUp() {
        setDirection(Direction.UP);
    }

    @Override
    public void directDown() {
        setDirection(Direction.DOWN);
    }

    @Override
    public void directTurnRight() {
        setDirection(currentDirection.getRightTurnDirection());
    }

    @Override
    public void directTurnLeft() {
        setDirection(currentDirection.getLeftTurnDirection());
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
