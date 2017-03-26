package cz.muni.fi.pv260.snake.model;

import cz.muni.fi.pv260.control.collision.Point;

import java.awt.Color;

/**
 * @author <a href="mailto:xstefank122@gmail.com">Martin Stefanko</a>
 */
public class Food {

    private Point position;
    private Color color;

    public Food(Point position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Point getPosition() {
        return position;
    }

    public Color getColor() {
        return color;
    }
}
