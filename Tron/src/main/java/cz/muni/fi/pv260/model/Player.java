package cz.muni.fi.pv260.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.control.collision.TraveledPathListImpl;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;

import java.awt.Color;

/**
 * Class representing a player in the game.
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class Player {

    private DirectionControl2D directionControl;
    private TraveledPath path;
    private Color color;

    public Player(Point startingPoint, DirectionControl2D directionControl, Color color) {
        this.directionControl = directionControl;
        this.path = new TraveledPathListImpl(startingPoint);
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public Point getPosition() {
        return this.path.getHeadPosition();
    }

    public DirectionControl2D getDirectionControl() {
        return this.directionControl;
    }

    public TraveledPath getPath() {
        return this.path;
    }

}
