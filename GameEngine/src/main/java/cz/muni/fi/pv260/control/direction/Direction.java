package cz.muni.fi.pv260.control.direction;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public enum Direction {
    DIRECTION_UP(0, -1) {
        @Override
        public Direction getOppositeDirection() {
            return DIRECTION_DOWN;
        }

        @Override
        public Direction getRightTurnDirection() {
            return DIRECTION_RIGHT;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return DIRECTION_LEFT;
        }

    },

    DIRECTION_RIGHT(1, 0) {
        @Override
        public Direction getOppositeDirection() {
            return Direction.DIRECTION_LEFT;
        }

        @Override
        public Direction getRightTurnDirection() {
            return Direction.DIRECTION_DOWN;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return Direction.DIRECTION_UP;
        }
    },

    DIRECTION_DOWN(0, 1) {
        @Override
        public Direction getOppositeDirection() {
            return Direction.DIRECTION_UP;
        }

        @Override
        public Direction getRightTurnDirection() {
            return Direction.DIRECTION_LEFT;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return Direction.DIRECTION_RIGHT;
        }
    },

    DIRECTION_LEFT(-1, 0) {
        @Override
        public Direction getOppositeDirection() {
            return Direction.DIRECTION_RIGHT;
        }

        @Override
        public Direction getRightTurnDirection() {
            return Direction.DIRECTION_UP;
        }

        @Override
        public Direction getLeftTurnDirection() {
            return Direction.DIRECTION_DOWN;
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
