package cz.muni.fi.pv260;

import cz.muni.fi.pv260.Player.Direction;

/**
 * Created by Marek on 19.3.2017.
 */
public class PlayerKeys {

    private int keyDirectionUp;
    private int keyDirectionRight;
    private int keyDirectionDown;
    private int keyDirectionLeft;

    public PlayerKeys(int keyDirectionUp, int keyDirectionRight, int keyDirectionDown, int keyDirectionLeft) {
        this.keyDirectionUp = keyDirectionUp;
        this.keyDirectionRight = keyDirectionRight;
        this.keyDirectionDown = keyDirectionDown;
        this.keyDirectionLeft = keyDirectionLeft;
    }

    public Boolean isPlayerKey(int keyCode) {
        if (keyCode == keyDirectionUp
                || keyCode == keyDirectionRight
                || keyCode == keyDirectionDown
                || keyCode == keyDirectionLeft) {
            return true;
        }
        return false;
    }

    public Direction getKeyCodeDirection(int keyCode) {
        if (keyCode == keyDirectionUp) {
            return Direction.DIRECTION_UP;
        }
        if (keyCode == keyDirectionRight) {
            return Direction.DIRECTION_RIGHT;
        }
        if (keyCode == keyDirectionDown) {
            return Direction.DIRECTION_DOWN;
        }
        if (keyCode == keyDirectionLeft) {
            return Direction.DIRECTION_LEFT;
        }
        return null;
    }
}

