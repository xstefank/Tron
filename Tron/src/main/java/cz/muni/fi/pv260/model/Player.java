package cz.muni.fi.pv260.model;

import cz.muni.fi.pv260.control.collision.Point;
import cz.muni.fi.pv260.control.collision.TraveledPath;
import cz.muni.fi.pv260.control.collision.TraveledPathListImpl;
import cz.muni.fi.pv260.control.controller.KeyboardController;
import cz.muni.fi.pv260.control.direction.DirectionControl2D;
import java.awt.*;

/**
 * Class representing a player in the game.
 * Contains information about player position, path, color and keyboard bindings.
 *
 * @author <a href="mailto:umarekk@gmail.com">Marek Urban</a>
 */
public class Player {

    private Point position;
    private DirectionControl2D directionControl;
    private KeyboardController keyboardController;
    private TraveledPath path;
    private Color color;

    public Player(Point startingPoint, DirectionControl2D directionControl, KeyboardController keyboardController, Color color) {
        position = startingPoint;
        this.directionControl = directionControl;
        this.keyboardController = keyboardController;
        path = new TraveledPathListImpl();
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

    public Point getPosition() {
        return path.getHeadPosition();
    }

    public DirectionControl2D getDirectionControl() {
        return directionControl;
    }

    public KeyboardController getKeyboardController() {
        return keyboardController;
    }

    public TraveledPath getPath() {
        return path;
    }

    public void setPath(TraveledPath path) {
        this.path = path;
    }

    public void appendCurrentPositionToPath() {
        path.addPointToPath(new Point(position.getCoordinateX(), position.getCoordinateY()));
    }

}
