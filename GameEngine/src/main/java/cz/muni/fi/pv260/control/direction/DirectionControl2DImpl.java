package cz.muni.fi.pv260.control.direction;

public class DirectionControl2DImpl implements DirectionControl2D {

    private Direction currentDirection;

    public DirectionControl2DImpl(Direction startDirection) {
        this.currentDirection = startDirection;
    }

    @Override
    public void directRight() {
        setDirection(Direction.LEFT, Direction.RIGHT);
    }

    @Override
    public void directLeft() {
        setDirection(Direction.RIGHT, Direction.LEFT);
    }

    @Override
    public void directUp() {
        setDirection(Direction.DOWN, Direction.UP);
    }

    @Override
    public void directDown() {
        setDirection(Direction.UP, Direction.DOWN);
    }

    @Override
    public Direction getDirection() {
        return this.currentDirection;
    }

    private void setDirection(Direction guardDirection, Direction newDirection) {
        if (currentDirection != guardDirection) {
            currentDirection = newDirection;
        }
    }
}
