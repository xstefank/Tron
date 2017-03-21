package cz.muni.fi.pv260.control.direction;

/**
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public enum Direction {
    DIRECTION_UP,
    DIRECTION_RIGHT,
    DIRECTION_DOWN,
    DIRECTION_LEFT;

    private int MULTIPLIER_X;
    private int MULTIPLIER_Y;

    private Direction OPPOSITE;

    static {
        DIRECTION_UP.MULTIPLIER_X = 0;
        DIRECTION_UP.MULTIPLIER_Y = -1;

        DIRECTION_RIGHT.MULTIPLIER_X = 1;
        DIRECTION_RIGHT.MULTIPLIER_Y = 0;

        DIRECTION_DOWN.MULTIPLIER_X = 0;
        DIRECTION_DOWN.MULTIPLIER_Y = 1;

        DIRECTION_LEFT.MULTIPLIER_X = -1;
        DIRECTION_LEFT.MULTIPLIER_Y = 0;

        DIRECTION_UP.OPPOSITE = DIRECTION_DOWN;
        DIRECTION_RIGHT.OPPOSITE = DIRECTION_LEFT;
        DIRECTION_DOWN.OPPOSITE = DIRECTION_UP;
        DIRECTION_LEFT.OPPOSITE = DIRECTION_RIGHT;
    }

    public int getMultiplierX(){
        return MULTIPLIER_X;
    }

    public int getMultiplierY(){
        return MULTIPLIER_Y;
    }

    public Direction getOpposite(){
        return OPPOSITE;
    }
}
