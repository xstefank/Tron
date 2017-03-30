package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.control.collision.Path;
import cz.muni.fi.pv260.control.collision.PathListImpl;
import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.direction.Direction;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;
import cz.muni.fi.pv260.control.direction.DirectionControl2DImpl;

import java.awt.Color;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class Snake {

    private static final int EASY = 5;
    private static final int MEDIUM = 10;
    private static final int HARD = 20;

    private DirectionControl2D directionControl;
    private Path body;
    private Color color;
    private int speed;

    public Snake(Direction startDirection, Point startPosition, Color color) {
        this.directionControl = new DirectionControl2DImpl(startDirection);
        this.body = new PathListImpl(startPosition);
        this.color = color;
        this.speed = EASY;
    }

    public DirectionControl2D getDirectionControl() {
        return directionControl;
    }

    public Path getBody() {
        return body;
    }

    public Point getPosition() {
        return body.getHeadPosition();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void increaseSpeed() {
        switch (speed) {
            case EASY: speed = MEDIUM; break;
            case MEDIUM: speed = HARD; break;
            default: speed = MEDIUM;
        }
    }
}
