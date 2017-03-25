package cz.muni.fi.pv260.control.direction;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public enum Direction {
    UP(0, -1) {
        @Override
        public Direction getOppositeDirection() {
            return DOWN;
        }

        @Override
        public Direction getRightTurnDirection() {
            return RIGHT;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return LEFT;
        }

    },

    RIGHT(1, 0) {
        @Override
        public Direction getOppositeDirection() {
            return Direction.LEFT;
        }

        @Override
        public Direction getRightTurnDirection() {
            return Direction.DOWN;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return Direction.UP;
        }
    },

    DOWN(0, 1) {
        @Override
        public Direction getOppositeDirection() {
            return Direction.UP;
        }

        @Override
        public Direction getRightTurnDirection() {
            return Direction.LEFT;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return Direction.RIGHT;
        }
    },

    LEFT(-1, 0) {
        @Override
        public Direction getOppositeDirection() {
            return Direction.RIGHT;
        }

        @Override
        public Direction getRightTurnDirection() {
            return Direction.UP;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return Direction.DOWN;
        }
    };

    private int multiplierX;
    private int multiplierY;

    Direction(int multiplierX, int multiplierY) {
        this.multiplierX = multiplierX;
        this.multiplierY = multiplierY;
    }

    public int getMultiplierX() {
        return multiplierX;
    }

    public int getMultiplierY() {
        return multiplierY;
    }

    public abstract Direction getOppositeDirection();

    public abstract Direction getRightTurnDirection();

    public abstract Direction getLeftTurnDirection();

}
