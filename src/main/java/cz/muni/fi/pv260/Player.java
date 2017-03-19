package cz.muni.fi.pv260;

import java.util.ArrayList;

/**
 * Created by Marek on 19.3.2017.
 */
public class Player {

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

    private Position position;
    private Direction direction;
    private PlayerKeys keys;
    private ArrayList<Position> path;

    public Player(Position startingPosition, Direction startingDirection, PlayerKeys controlKeys) {
        position = startingPosition;
        direction = startingDirection;
        keys = controlKeys;
        path = new ArrayList<Position>();
    }

    public Position getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction){
        this.direction = direction;
    }

    public PlayerKeys getKeys(){
        return keys;
    }

    public ArrayList<Position> getPath() {
        return path;
    }

    public void setPath(ArrayList<Position> path) {
        this.path = path;
    }

    public void appendCurrentPositionToPath(){
        path.add(new Position(position.getCoordinateX(), position.getCoordinateY()));
    }

}
